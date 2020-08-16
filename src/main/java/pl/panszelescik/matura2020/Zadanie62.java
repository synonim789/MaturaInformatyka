package pl.panszelescik.matura2020;

import pl.panszelescik.api.DateUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Statek;

import java.util.ArrayList;
import java.util.List;

public class Zadanie62 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < statki.size() - 1; i++) {
            Statek statek = statki.get(i);
            Statek next = statki.get(i + 1);
            list.add(DateUtils.getFullDays(statek.date, next.date));
        }
        long count = list.stream()
                .filter(num -> num > 20)
                .count();
        FileUtils.write("2020_zadanie62.txt", writer -> writer.write(count));
        System.out.println(count);
    }
}