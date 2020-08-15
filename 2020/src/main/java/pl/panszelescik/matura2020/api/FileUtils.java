package pl.panszelescik.matura2020.api;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FileUtils {

    public static final Consumer<Object> PRINTER = o -> System.out.println(o.toString());

    public static List<String> read(String path) {
        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(path);
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