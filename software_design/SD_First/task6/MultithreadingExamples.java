package SD_First.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class MultithreadingExamples {

    /*
    1. Допустим нам нужно сделать известное число операций прежде чем начать какую-то работу, например узнать прогноз погоды и выпить кофе.
    Для этого можно использовать CountDownLatch, который будет говорить о том, что вся предварительная работа выполнена.
     */
    static class CountDownLatchDemo {
        public static void main(String[] args) throws InterruptedException {
            int latchCount = 2;
            CountDownLatch latch = new CountDownLatch(latchCount);
            new Thread(() -> {
                try {
                    System.out.println("Получить прогноз погоды");
                    Thread.sleep(500);
                    System.out.println("Прогноз получен");
                    latch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

            new Thread(() -> {
                try {
                    System.out.println("Выпить кофе");
                    Thread.sleep(1000);
                    System.out.println("Кофе выпит");
                    latch.countDown();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();

            System.out.println("Ждём завершения утренней рутины перед основной работой");
            latch.await();
            System.out.println("Рутина завершена. Приступаем к основной работе");
        }
    }


    /*
     2. Допустим у нас есть длительная операция с БД и мы бы хотели, чтобы в один момент времени выполнялась только одна такая операция.
     А попытки вызвать эту операцию повторно завершались бы с ошибкой. Тут можно использовать ReentrantLock.
     */
    static class ReentrantLockDemo {
        static ReentrantLock lock = new ReentrantLock();
        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                new Thread(ReentrantLockDemo::longTask).start();
            }
        }

        static void longTask() {
            if (lock.tryLock()) {
                try {
                    System.out.println("Начали долгую работу");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                    System.out.println("Закончили долгую работу");
                }
            } else {
                System.out.println("Долгая работа уже выполняется, ничего не делаем");
            }
        }
    }


    /*
    3. Допустим у нас есть задача, загрузить список изображений в своё хранилище. Изображений много и грузить мы их хотим параллельно.
    Для этого можно использовать ExecutorService, который будет вызывать метод загрузки отдельных изображений независимо.
     */
    static class ExecutorServiceDemo {
        public static void main(String[] args) {
            ExecutorService executor = Executors.newFixedThreadPool(5);

            try {
                List<Future<String>> futures = new ArrayList<>();

                for (int i = 0; i < 10; i++) {
                    String imageName = String.valueOf(i + 1);
                    //Ставим изображение на загрузку
                    futures.add(executor.submit(() -> downloadImage(imageName)));
                }

                for (Future<String> future : futures) {
                    try {
                        //Что-то делаем с загруженным изображением
                        System.out.println(future.get());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                executor.shutdown();
            }
        }

        private static String downloadImage(String name) throws InterruptedException {
            Thread.sleep(1000);
            return "Image " + name + " downloaded";
        }
    }

    /*
    4. Допустим у нас есть длительная задача и мы бы хотели, чтобы в один момент времени выполнялась только одна такая задача.
    А попытки вызвать эту задачу повторно игнорировались. Тут можно использовать AtomicBoolean.
     */
    static class AtomicBooleanDemo {
        static AtomicBoolean isStarted = new AtomicBoolean(false);

        public static void main(String[] args) {
            for (int i = 0; i < 3; i++) {
                new Thread(AtomicBooleanDemo::task).start();
            }
        }

        private static void task() {
            boolean isThisThreadStart = false;
            try {
                System.out.println("Пытаемся выполнить задачу в " + Thread.currentThread().getName());
                if (isStarted.getAndSet(true)) {
                    System.out.println(Thread.currentThread().getName() + " Задача уже запущена.");
                    return;
                }
                isThisThreadStart = true;
                System.out.println(Thread.currentThread().getName() + " Выполняем сложную работу");
            } finally {
                if (isThisThreadStart) {
                    isStarted.set(false);
                }
            }
        }
    }

    /*
    5. Допустим нам нужно собрать данные из нескольких источников, как-то обработать их и вернуть пользователю.
    Для ускорения процесса, мы можем обращаться к разным источникам параллельно. В этом деле нам может помочь Future и CompletableFuture.
     */
    static class FutureDemo {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            CompletableFuture<String> firstServiceFutureData = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Данные из первого источника";
            });

            CompletableFuture<String> secondServiceFutureData = CompletableFuture.supplyAsync(() -> {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "Данные из второго источника";
            });

            secondServiceFutureData = secondServiceFutureData
                    .thenApply(s -> {
                        System.out.println("Проводим всякие сложные операции со вторым источником");
                        return s;
                    })
                    .thenApply(s -> s.concat(" тоже обогащены"));

            firstServiceFutureData = firstServiceFutureData
                    .thenApply(s -> {
                        System.out.println("Проводим всякие сложные операции с первым источником");
                        return s;
                    })
                    .thenApply(s -> s.concat(" обогащены"));

            System.out.println(firstServiceFutureData.get());
            System.out.println(secondServiceFutureData.get());
            System.out.println("Работа закончена");
        }
    }
}
