package pl.panszelescik.api;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Printers {

    // Printer, który można wsadzić do .forEach() lub .peek()
    public static final Consumer<Object> CONSUMER = System.out::println;
    public static final BiConsumer<Object, Object> BI_CONSUMER = (o, o2) -> System.out.println(o + " " + o2);
}