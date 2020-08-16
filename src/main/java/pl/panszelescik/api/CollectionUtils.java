package pl.panszelescik.api;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class CollectionUtils {

    // Tworzy IntStream z List<Integer>
    public static IntStream createIntStream(java.util.Collection<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }

    // Zwraca pierwszy zgodny obiekt z listy
    public static <T> T getFromList(java.util.Collection<T> list, Predicate<? super T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    // Dodaje do kolekcji i ją zwraca, kompatybilne z listami i setami
    public static <C extends java.util.Collection<E>, E> C add(C collection, E value) {
        collection.add(value);
        return collection;
    }
}