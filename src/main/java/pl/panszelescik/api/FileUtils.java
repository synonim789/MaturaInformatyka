package pl.panszelescik.api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    // Wczytuje plik, zwraca listę linii
    public static List<String> read(String path) {
        return read(path, 0);
    }

    // Wczytuje plik, zwraca listę linii, skip pozwala na pominięcie np. pierwszej linii
    public static List<String> read(String path, int skip) {
        InputStream inputStream = Printers.class.getClassLoader().getResourceAsStream(path);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            return br.lines()
                    .skip(skip)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    // Mapuje plik we wskazany sposób
    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper) {
        return mapFile(fileName, mapper, 0);
    }

    // Mapuje plik we wskazany sposób
    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper, int skip) {
        return read(fileName, skip).stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    // UWAGA!!!
    // Zapisywanie na maturze nie jest potrzebne

    // Wyświetla na consoli i zapisuje do pliku
    public static void endStream(MyWriter writer, Stream<?> stream) {
        stream.peek(Printers.CONSUMER)
                .forEach(writer::writeLine);
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

        public MyWriter writeLine(Object o) {
            this.write(o);
            this.write("\n");
            return this;
        }
    }
}