package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;
import pl.panszelescik.matura2020.base.Jezyk;

import java.util.*;

public class Zadanie51 {

    public static void main(String[] args) {
        List<Jezyk> jezyki = API.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new);
        Map<String, Integer> map = new HashMap<>();
        jezyki.stream()
                .map(jezyk -> jezyk.rodzina)
                .forEach(rodzina -> map.merge(rodzina, 1, Integer::sum));
        API.writeStream("2020_zadanie51.txt", map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey() + " " + entry.getValue() + "\n"));
    }
}