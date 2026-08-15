package SD_First.task5;

import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadingProblems {

    /*
    Проблема изначального решения заключалась в том, что доступ к переменной counter не был синхронизирован.
    Стандартный инкремент в Java не атомарный. Мы сначала читаем значение, затем увеличиваем и потом сохраняем назад.
    Один поток мог считать значение переменной, отдать управление другому потоку, тот другой считал значение, сразу инкрементировал его и сохранил,
    затем управление возвращается первому потоку, он делает инкремент старого считанного значения и сохраняет его.
    Таким образом мы потеряли единицу из итогового результата. Таких потерь может быть много в большом количестве потоков и вычислений.

    В исправленном варианте я использовал счётчик типа AtomicInteger, который полагается на поддержку атомарности на аппаратном уровне.
    Получаем стабильный инкремент в многопоточной среде. В качестве альтернативы можно было использовать synchronized,
    но это более тяжелый вариант, который полагается на программные блокировки.
     */
    static class RaceConditionExample {

        private static final AtomicInteger counter = new AtomicInteger(0);

        public static void main(String[] args) {
            int numberOfThreads = 10;
            Thread[] threads = new Thread[numberOfThreads];

            for (int i = 0; i < numberOfThreads; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 100000; j++) {
                        counter.incrementAndGet();
                    }
                });
                threads[i].start();
            }

            for (int i = 0; i < numberOfThreads; i++) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Final counter value: " + counter);
        }
    }

    /*
    Проблема изначального решения заключалась в том, что мы пытались получить блокировку одних и тех же ресурсов в разном порядке.
    Один поток брал лок1, потом передавал управление другому, который брал лок2 и возвращал управление. Первый поток потом пытался получить занятый лок2, а второй -- занятый лок1.
    Мы попали в ситуацию, когда потоки не отдают захваченные локи, ибо они не выполнили задачу, а задачу не могут выполнить, потому что им не хватает других локов.
    Получаем бесконечное ожидание. Чтобы попасть в такую ситуацию, нужно чтобы сразу соблюдались 4 условия Коффмана:
    1. Каждый ресурс в данный момент может быть предоставлен только одному процессу.
    2. Процесс, уже владеющий хотя бы одним ресурсом, блокируется в ожидании получения дополнительных ресурсов, которые в данный момент удерживаются другими процессами.
    3. Ресурс не может быть принудительно изъят у процесса.
    4. Существует замкнутая цепочка процессов, в которой каждый процесс ожидает ресурс, удерживаемый следующим процессом в цепочке.

    Значит для решения проблемы нужно нарушить хотя бы одно из условий.

    Я решил изменить порядок захвата блокировок, второй поток теперь берёт блокировки в том же порядке, что и первый. Это помогает нам избежать возникновения условия под номером 4.
     */
    static class DeadlockExample {

        private static final Object lock1 = new Object();
        private static final Object lock2 = new Object();

        public static void main(String[] args) {
            Thread thread1 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread 1 acquired lock1");

                    try { Thread.sleep(50); }
                    catch (InterruptedException e) { e.printStackTrace(); }

                    synchronized (lock2) {
                        System.out.println("Thread 1 acquired lock2");
                    }
                }
            });

            Thread thread2 = new Thread(() -> {
                synchronized (lock1) {
                    System.out.println("Thread 2 acquired lock1");

                    try { Thread.sleep(50); }
                    catch (InterruptedException e) { e.printStackTrace(); }

                    synchronized (lock2) {
                        System.out.println("Thread 2 acquired lock2");
                    }
                }
            });

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Finished");
        }
    }
}
