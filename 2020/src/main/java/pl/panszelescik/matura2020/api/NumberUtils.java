package pl.panszelescik.matura2020.api;

import java.util.*;
import java.util.stream.IntStream;

public class NumberUtils {

    public static int parse(String string) {
        return Integer.parseInt(string);
    }

    // Czy jest parzysta
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Zwraca wszystkie liczby pierwsze, mniejsze od parametru number
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

    // Zwraca sumę liczb pierwszych podanej liczby
    public static Set<List<Integer>> primeToEvenNumbers(int liczba) {
        int[] liczbyPierwsze = NumberUtils.getPrimeNumbersLowerThan(liczba);
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

    public static int sumIntList(List<Integer> list) {
        return createIntStream(list).sum();
    }

    public static IntStream createIntStream(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }
}