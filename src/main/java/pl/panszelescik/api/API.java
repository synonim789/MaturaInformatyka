package pl.panszelescik.api;

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
import java.util.stream.Stream;

public class API {

    // Printer, który można wsadzić do .forEach() lub .peek()
    public static final Consumer<Object> PRINTER = o -> System.out.println(o.toString());

    // Wczytuje plik, zwraca listę linii
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

    // Mapuje plik we wskazany sposób
    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper) {
        return mapLines(read(fileName), mapper);
    }

    // Mapuje linie we wskazany sposób
    public static <R> List<R> mapLines(List<String> lines, Function<String, ? extends R> mapper) {
        return lines.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    // Parsuje inta
    public static int parse(String string) {
        return Integer.parseInt(string);
    }

    // Sprawdza czy podana liczba jest parzysta
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Zwraca wszystkie liczby pierwsze, mniejsze od podanej liczby
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

    // Przelicza sumę wszystkich wartości podanej liczby intów
    public static int sumIntList(List<Integer> list) {
        return createIntStream(list).sum();
    }

    // Tworzy IntStream z List<Integer>
    public static IntStream createIntStream(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }

    // Zlicza znaki w podanym słowie, zwraca w postaci Mapy
    public static Map<Character, Integer> wordToMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        System.out.println(map);
        return map;
    }

    // Powtarza ciąg znaków o podaną ilość razy
    public static String repeat(String repeat, int amount) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < amount; i++) {
            string.append(repeat);
        }
        return string.toString();
    }

    // UWAGA!!!
    // Zapisywanie na maturze nie jest potrzebne

    // Wyświetla na consoli i zapisuje do pliku
    public static void endStream(MyWriter writer, Stream<?> stream) {
        stream.peek(PRINTER)
                .forEach(writer::write);
    }

    // Wyświetla na consoli i zapisuje do pliku
    public static void writeStream(String fileName, Stream<?> stream) {
        write(fileName, writer -> endStream(writer, stream));
    }

    // Po otwarciu pliku, można do niego wpisać cokolwiek używając Consumera
    public static void write(String fileName, Consumer<MyWriter> onOpen) {
        try (Writer output = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            onOpen.accept(new MyWriter(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Klasa wewnętrzna, by nie pisać ciągle try/catch
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
