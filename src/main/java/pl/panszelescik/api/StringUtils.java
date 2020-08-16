package pl.panszelescik.api;

import java.util.HashMap;
import java.util.Map;

public class StringUtils {

    // Zlicza znaki w podanym słowie, zwraca w postaci Mapy
    public static Map<Character, Integer> wordToMap(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
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

    // Odwraca String
    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}