package pl.panszelescik.api;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    // Parsuje date ze stringa w podanym patternie
    public static LocalDate parse(String string, String pattern) {
        return LocalDate.parse(string, DateTimeFormatter.ofPattern(pattern));
    }

    // Zwraca ilosc pelnych dni miedzy dwoma datami
    public static long getFullDays(LocalDate before, LocalDate after) {
        return ChronoUnit.DAYS.between(before, after) - 1;
    }

    // Parsuje stringa z daty w podanym patternie
    public static String format(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}