package pl.panszelescik.matura2020;

import pl.panszelescik.api.DateUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Magazyn;
import pl.panszelescik.matura2020.base.Statek;

import java.time.LocalDate;
import java.util.List;
import java.util.Map.Entry;

public class Zadanie63 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        Magazyn magazyn1 = getMagazynForDate(statki, "2016-02-01", "yyyy-MM-dd");
        Magazyn magazyn2 = getMagazynForDate(statki, "2018-08-01", "yyyy-MM-dd");
        FileUtils.write("rozwiazania/2020", "zadanie63.txt", writer -> {
            String string = String.join("\n", "2016-02-01", getMax(magazyn1), getMin(magazyn1), "\n2018-08-01", getMax(magazyn2), getMin(magazyn2));
            System.out.println(string);
            writer.write(string);
        });
    }

    public static Magazyn getMagazynForDate(List<Statek> statki, String dateStr, String pattern) {
        LocalDate date = DateUtils.parse(dateStr, pattern);
        Magazyn magazyn = new Magazyn();
        statki.stream()
                .filter(statek -> statek.date.compareTo(date) < 0)
                .forEach(magazyn::myCount);
        return magazyn;
    }

    public static String getMax(Magazyn magazyn) {
        Entry<String, Integer> towar = magazyn.entrySet()
                .stream()
                .max(Entry.comparingByValue())
                .get();
        return towar.getKey() + " " + towar.getValue();
    }

    public static String getMin(Magazyn magazyn) {
        Entry<String, Integer> towar = magazyn.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .min(Entry.comparingByValue())
                .get();
        return towar.getKey() + " " + towar.getValue();
    }
}