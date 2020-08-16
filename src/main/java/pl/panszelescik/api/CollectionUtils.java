package pl.panszelescik.api;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionUtils {

    // Tworzy IntStream z List<Integer>
    public static IntStream createIntStream(Collection<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }

    // Zwraca pierwszy zgodny obiekt z listy
    public static <T> T getFromList(Collection<T> list, Predicate<? super T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    // Dodaje do kolekcji i ją zwraca, kompatybilne z listami i setami
    public static <C extends Collection<E>, E> C add(C collection, E value) {
        collection.add(value);
        return collection;
    }

    public static <T, K> Collector<T, ?, Map<K, Integer>> toCountMap(Function<? super T, ? extends K> keyMapper) {
        return Collectors.toMap(keyMapper, u -> 1, Integer::sum);
    }
}