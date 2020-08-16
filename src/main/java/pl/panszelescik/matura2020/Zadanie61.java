package pl.panszelescik.matura2020;

import pl.panszelescik.api.CollectionUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Statek;
import pl.panszelescik.matura2020.base.Type;

import java.util.List;
import java.util.Map;

public class Zadanie61 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        statki.stream()
                .filter(statek -> statek.type.equals(Type.ZALADUNEK))
                .collect(CollectionUtils.toCountMap(statek -> statek.towar))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> {
                    String string = entry.getKey() + " " + entry.getValue();
                    FileUtils.write("2020_zadanie61.txt", writer -> writer.write(string));
                    System.out.println(string);
                });
    }
}