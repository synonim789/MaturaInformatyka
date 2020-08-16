package pl.panszelescik.matura2020;

import pl.panszelescik.api.*;
import pl.panszelescik.matura2020.base.Statek;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Zadanie64 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        Map<String, Integer> map = statki.stream()
                .filter(statek -> statek.towar.equals("T5"))
                .filter(statek -> statek.date.isAfter(DateUtils.parse("2016-01-01", "yyyy-MM-dd")) && statek.date.isBefore(DateUtils.parse("2018-12-18", "yyyy-MM-dd")))
                .sorted(Comparator.comparing(statek -> statek.date))
                .collect(CollectionUtils.toSumMap(statek -> DateUtils.format(statek.date, "yyyy-MM"), statek -> statek.waga));
        for (int i = 2016; i < 2019; i++) {
            for (int j = 1; j < 13; j++) {
                map.putIfAbsent(i + "-" + NumberUtils.prettyNumber(j), 0);
            }
        }
        FileUtils.writeStream("2020_zadanie64.txt", map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()));
    }
}