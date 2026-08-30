Добавляем возможность задавать местоположение директории с изображениями через конфигурацию.

До:
```java
@Slf4j
@Component
public class FileStorage {

    private static final String IMAGES_DIRECTORY = "/var/images";

    public void saveImg(String name, byte[] imageData) throws IOException {
        Path dir = Paths.get(IMAGES_DIRECTORY);

        if (Files.notExists(dir)) {
            Files.createDirectories(dir);
            log.info("Создана папка для изображений: {}", dir.toAbsolutePath());
        }
        Path imagePath = dir.resolve(name);
        Files.write(imagePath, imageData);
        log.debug("Изображение сохранено: {}", imagePath.toAbsolutePath());
    }

    public Optional<File> findImg(String fileName) {
        File file = new File(IMAGES_DIRECTORY, fileName);
        return file.isFile() ? Optional.of(file) : Optional.empty();
    }

    public void deleteImg(String imageName) {
        File file = new File(IMAGES_DIRECTORY, imageName);
        if (file.isFile()) {
            try {
                Files.delete(file.toPath());
            } catch (Exception e) {
                log.error("Exception while deleting file: {}", file, e);
            }
        } else {
            log.debug("Изображение не найдено в ФС: {}", imageName);
        }
    }
}
```

После:
```java
@Slf4j
@Component
public class FileStorage {
    @Value("${app.storage.images:/var/images}")
    private String imgDir;

    public void saveImg(String name, byte[] imageData) throws IOException {
        Path dir = Paths.get(imgDir);

        if (Files.notExists(dir)) {
            Files.createDirectories(dir);
            log.info("Создана папка для изображений: {}", dir.toAbsolutePath());
        }
        Path imagePath = dir.resolve(name);
        Files.write(imagePath, imageData);
        log.debug("Изображение сохранено: {}", imagePath.toAbsolutePath());
    }

    public Optional<File> findImg(String fileName) {
        File file = new File(imgDir, fileName);
        return file.isFile() ? Optional.of(file) : Optional.empty();
    }

    public void deleteImg(String imageName) {
        File file = new File(imgDir, imageName);
        if (file.isFile()) {
            try {
                Files.delete(file.toPath());
            } catch (Exception e) {
                log.error("Exception while deleting file: {}", file, e);
            }
        } else {
            log.debug("Изображение не найдено в ФС: {}", imageName);
        }
    }
}
```