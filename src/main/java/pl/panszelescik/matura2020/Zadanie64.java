package pl.panszelescik.matura2020;

import pl.panszelescik.api.*;
import pl.panszelescik.matura2020.base.Statek;
import pl.panszelescik.matura2020.base.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Zadanie64 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        FileUtils.write("rozwiazania/2020", "zadanie64.txt", writer -> {
            zaladunek(writer, statki);
            wyladunek(writer, statki);
        });
    }

    public static void zapisz(FileUtils.MyWriter writer, List<Statek> statki, Type type) {
        writer.writeLine(type);
        System.out.println(type);
        Map<String, Integer> map = statki.stream()
                .filter(statek -> statek.towar.equals("T5"))
                .filter(statek -> statek.type.equals(type))
                .filter(statek -> statek.date.isAfter(DateUtils.parse("2016-01-01", "yyyy-MM-dd").minusDays(1)) && statek.date.isBefore(DateUtils.parse("2018-12-18", "yyyy-MM-dd").plusDays(1)))
                .sorted(Comparator.comparing(statek -> statek.date))
                .collect(CollectionUtils.toSumMap(statek -> DateUtils.format(statek.date, "yyyy-MM"), statek -> statek.waga));
        for (int i = 2016; i < 2019; i++) {
            for (int j = 1; j < 13; j++) {
                map.putIfAbsent(i + "-" + NumberUtils.prettyNumber(j), 0);
            }
        }
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .forEach(string -> {
                    writer.writeLine(string);
                    System.out.println(string);
                });
        writer.write("\n");
        System.out.println(" ");
    }

    public static void zaladunek(FileUtils.MyWriter writer, List<Statek> statki) {
        zapisz(writer, statki, Type.ZALADUNEK);
    }

    public static void wyladunek(FileUtils.MyWriter writer, List<Statek> statki) {
        zapisz(writer, statki, Type.WYLADUNEK);
    }
}