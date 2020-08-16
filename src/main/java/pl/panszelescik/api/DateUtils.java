package pl.panszelescik.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static LocalDate parse(String string, String pattern) {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern(pattern));
    }
}