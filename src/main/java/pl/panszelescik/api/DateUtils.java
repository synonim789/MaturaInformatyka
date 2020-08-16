package pl.panszelescik.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {

    public static LocalDate parse(String string, String pattern) {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern(pattern));
    }

    public static long getFullDays(LocalDate before, LocalDate after) {
        return ChronoUnit.DAYS.between(before, after) - 1;
    }
}