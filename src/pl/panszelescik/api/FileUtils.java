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
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileUtils {

    // Wczytuje plik, zwraca liste linii
    public static List<String> read(String path) {
        return read(path, 0);
    }

    // Wczytuje plik, zwraca liste linii, skip pozwala na pominiecie np. pierwszej linii
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

    // Mapuje plik we wskazany sposob
    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper) {
        return mapFile(fileName, mapper, 0);
    }

    // Mapuje plik we wskazany sposob
    public static <R> List<R> mapFile(String fileName, Function<String, ? extends R> mapper, int skip) {
        return read(fileName, skip).stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    // UWAGA!!!
    // Zapisywanie na maturze nie jest potrzebne

    // Wyswietla na consoli i zapisuje do pliku
    public static void endStream(MyWriter writer, Stream<?> stream) {
        stream.peek(Printers.CONSUMER)
                .forEach(writer::writeLine);
    }

    // Wyswietla na consoli i zapisuje do pliku
    public static void endStream(MyWriter writer, IntStream stream) {
        stream.peek(Printers.INT_CONSUMER)
                .forEach(writer::writeLine);
    }

    // Wyswietla na consoli i zapisuje do pliku
    public static void writeStream(String dir, String fileName, Stream<?> stream) {
        write(dir, fileName, writer -> endStream(writer, stream));
    }

    // Wyswietla na consoli i zapisuje do pliku
    public static void writeStream(String dir, String fileName, IntStream stream) {
        write(dir, fileName, writer -> endStream(writer, stream));
    }

    // Po otwarciu pliku, mozna do niego wpisac cokolwiek uzywajac Consumera
    public static void write(String dir, String fileName, Consumer<MyWriter> onOpen) {
        try {
            Files.createDirectories(Paths.get(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (Writer output = Files.newBufferedWriter(Paths.get(dir, fileName), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            onOpen.accept(new MyWriter(output));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Klasa wewnetrzna, by nie pisac ciagle try/catch
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