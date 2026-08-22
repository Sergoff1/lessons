package SD_First.task7;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateExample {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /*
    Одна из проблем кода в примере, заключается в том, что там применяются легаси-классы для работы с датой и временем.
    В Java 8, которая вышла уже довольно давно, были введены новые, более удобные и безопасные классы для работы с датами.
    Просто перейдя на их использование получим иммутабельность и потокобезопасноть.
    Также SimpleDateFormat по умолчанию парсит даже те даты, что не соответствуют переданному формату.
     */
    public static void main(String[] args) {
        String dateString = "2024-05-13 14:30:00";
        LocalDateTime date = LocalDateTime.parse(dateString, FORMATTER);
        System.out.println("Date: " + date);
        //Тут представлены минимальная реализация метода на новых классах, которая является иммутабельной и потокобезопасной,
        // также здесь меньше всяких неожиданностей, типа обработки дат с некорректным форматом.
        // Дополнительно можно добавить обработку ошибок парсинга и/или учёт часовых поясов.
    }
}
