package pl.panszelescik.api;

import java.util.*;
import java.util.stream.IntStream;

public class NumberUtils {

    // Parsuje int
    public static int parseInt(String string) {
        return Integer.parseInt(string);
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

    public static String prettyNumber(int number) {
        if (number < 10) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    // Przelicza sumę wszystkich wartości z listy
    public static int sumIntList(Collection<Integer> list) {
        return CollectionUtils.createIntStream(list).sum();
    }

    // Zwraca największy int z listy
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