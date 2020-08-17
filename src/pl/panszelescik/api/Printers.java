package pl.panszelescik.api;

import java.util.function.*;

public final class Printers {

    // Printer, ktory mozna wsadzic do .forEach() lub .peek()
    public static final Consumer<Object> CONSUMER = System.out::println;
    public static final DoubleConsumer DOUBLE_CONSUMER = System.out::println;
    public static final IntConsumer INT_CONSUMER = System.out::println;
    public static final LongConsumer LONG_CONSUMER = System.out::println;
    public static final ObjDoubleConsumer<Object> OBJ_DOUBLE_CONSUMER = (o, o2) -> System.out.println(o + " " + o2);
    public static final ObjIntConsumer<Object> OBJ_INT_CONSUMER = (o, o2) -> System.out.println(o + " " + o2);
    public static final ObjLongConsumer<Object> OBJ_LONG_CONSUMER = (o, o2) -> System.out.println(o + " " + o2);
    public static final BiConsumer<Object, Object> BI_CONSUMER = (o, o2) -> System.out.println(o + " " + o2);
}