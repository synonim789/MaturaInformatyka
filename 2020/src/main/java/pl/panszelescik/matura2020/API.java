package pl.panszelescik.matura2020;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class API {

    public static final Consumer<Object> PRINTER = o -> System.out.println(o.toString());

    public static List<String> read(String path) {
        InputStream inputStream = API.class.getClassLoader().getResourceAsStream(path);
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void write(String fileName, Consumer<MyWriter> onOpen) {
        try (Writer output = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            onOpen.accept(new MyWriter(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper) {
        return mapLines(read(fileName), mapper);
    }

    public static <R> List<R> mapLines(List<String> lines, Function<String, ? extends R> mapper) {
        return lines.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

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
                .filter(API::isPrimeNumber)
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

    public static int sumIntList(List<Integer> list) {
        return createIntStream(list).sum();
    }

    public static IntStream createIntStream(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }

    public static class MyWriter {

        public final Writer writer;

        public MyWriter(Writer writer) {
            this.writer = writer;
        }

        public MyWriter write(Object o) {
            try {
                this.writer.write(o.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return this;
        }
    }
}
