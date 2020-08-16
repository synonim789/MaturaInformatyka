package pl.panszelescik.api;

import java.util.*;

public class StringUtils {

    // Zlicza znaki w podanym słowie, zwraca w postaci Mapy
    public static Map<Character, Integer> wordToMap(String word) {
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : word.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        return map;
    }

    // Zlicza ciągi znaków
    public static List<Pair<Character, Integer>> subString(String input) {
        char[] chars = input.toCharArray();
        Pair<Character, Integer> pair = null;
        List<Pair<Character, Integer>> pairs = new ArrayList<>();
        for (char aChar : chars) {
            if (pair == null) {
                pair = new Pair<>(aChar, 1);
                continue;
            }

            if (pair.left == aChar) {
                pair.right++;
            } else {
                pairs.add(pair);
                pair = new Pair<>(aChar, 1);
            }
        }
        if (pair != null) pairs.add(pair);
        return pairs;
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