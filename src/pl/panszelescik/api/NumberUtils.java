package pl.panszelescik.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtils {

    // Parsuje int
    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }

    // Parsuje long
    public static long parseLong(String string) {
        return Long.parseLong(string);
    }

    // Parsuje double
    public static double parseDouble(String string) {
        return Double.parseDouble(string.replace(",", "."));
    }

    // Sprawdza czy podana liczba jest parzysta
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Zwraca wszystkie liczby pierwsze, mniejsze od podanej liczby
    public static int[] getPrimeNumbersLowerThan(int liczba) {
        return IntStream.range(2, liczba)
                .filter(NumberUtils::isPrimeNumber)
                .toArray();
    }

    // Sprawdza czy podana liczba jest pierwsza
    public static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Odejmuje 2 inty, przydatne jako referencja
    public static int substract(int a, int b) {
        return a - b;
    }

    // Zwraca sumy liczb pierwszych podanej liczby
    public static Set<List<Integer>> primeToEvenNumbers(int liczba) {
        int[] liczbyPierwsze = getPrimeNumbersLowerThan(liczba);
        Set<List<Integer>> valid = new HashSet<>();
        for (int liczbaPierwsza : liczbyPierwsze) {
            for (int liczbaPierwsza2 : liczbyPierwsze) {
                if (liczbaPierwsza + liczbaPierwsza2 == liczba) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(liczbaPierwsza, liczbaPierwsza2));
                    list.sort(Integer::compareTo);
                    valid.add(list);
                }
            }
        }
        return valid;
    }

    // Dla liczb 1-9 zapisuje 01, 02...
    public static String prettyNumber(int number) {
        if (number != 0 && number < 10) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    // Oblicza silnie
    public static int silnia(int i) {
        if (i <= 1) {
            return 1;
        }
        return i * silnia(i - 1);
    }

    // Zwraca cyfry liczby
    public static List<Integer> getDigits(int number) {
        return Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    // Zwraca cyfry liczby
    public static List<Integer> getDigits(long number) {
        return Long.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    // Tworzy liczbe z podanych cyfr
    public static String getNumberFromDigits(Collection<Integer> digits) {
        return getNumberFromDigits(CollectionUtils.createIntStream(digits));
    }

    // Tworzy liczbe z podanych cyfr
    public static String getNumberFromDigits(IntStream digits) {
        return digits.collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
    }

    // Przelicza sume wszystkich wartosci z listy
    public static int sumIntList(Collection<Integer> list) {
        return CollectionUtils.createIntStream(list).sum();
    }

    // Zwraca najwiekszy int z listy
    public static int getMax(Collection<Integer> list) {
        return CollectionUtils.createIntStream(list).max().getAsInt();
    }

    // Zwraca najmniejszy int z listy
    public static int getMin(Collection<Integer> list) {
        return CollectionUtils.createIntStream(list).min().getAsInt();
    }

    // Zwraca liczbe w systemie binarnym
    public static String toBinary(int number) {
        return Integer.toBinaryString(number);
    }

    // Zwraca liczbe w normalnym systemie
    public static int parseFromBinary(String binary) {
        return Integer.parseInt(binary, 2);
    }
}