package pl.panszelescik.api;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.*;

public final class CollectionUtils {

    // Tworzy IntStream z List<Integer>
    public static IntStream createIntStream(Collection<Integer> list) {
        return list.stream().mapToInt(Integer::intValue);
    }

    // Tworzy LongStream z List<Long>
    public static LongStream createLongStream(Collection<Long> list) {
        return list.stream().mapToLong(Long::longValue);
    }

    // Tworzy DoubleStream z List<Double>
    public static DoubleStream createDoubleStream(Collection<Double> list) {
        return list.stream().mapToDouble(Double::doubleValue);
    }

    // Zwraca pierwszy zgodny obiekt z listy
    public static <T> T getFirstFromList(Collection<T> list, Predicate<? super T> predicate) {
        return list.stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    // Zwraca pierwszy zgodny Entry z mapy
    public static <K, V> Map.Entry<K, V> getFirstFromMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        return map.entrySet()
                .stream()
                .filter(predicate)
                .findFirst()
                .get();
    }

    // Dodaje do kolekcji i ja zwraca, kompatybilne z listami i setami
    public static <C extends Collection<E>, E> C add(C collection, E value) {
        collection.add(value);
        return collection;
    }

    // Dodaje do mapy i ja zwraca
    public static <M extends Map<K, V>, K, V> M put(M map, K key, V value) {
        map.put(key, value);
        return map;
    }

    // Collector zliczajacy ilosc T w Streamie i mapuje do Map<K, Integer>
    public static <T, K> Collector<T, ?, Map<K, Integer>> toCountMap(Function<? super T, ? extends K> keyMapper) {
        return toSumMap(keyMapper, u -> 1);
    }

    // Collector zliczajacy wartosci z T w Streamie i mapuje do Map<K, Integer>
    public static <T, K> Collector<T, ?, Map<K, Integer>> toSumMap(Function<? super T, ? extends K> keyMapper, Function<? super T, Integer> valueMapper) {
        return Collectors.toMap(keyMapper, valueMapper, Integer::sum);
    }
}