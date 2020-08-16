package pl.panszelescik.matura2020;

import pl.panszelescik.api.CollectionUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Jezyk;

import java.util.*;

public class Zadanie51 {

    public static void main(String[] args) {
        List<Jezyk> jezyki = FileUtils.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        FileUtils.writeStream("rozwiazania/2020", "zadanie51.txt", jezyki.stream()
                .collect(CollectionUtils.toCountMap(jezyk -> jezyk.rodzina))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey() + " " + entry.getValue()));
    }
}