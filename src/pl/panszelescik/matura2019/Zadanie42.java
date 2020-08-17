package pl.panszelescik.matura2019;

import pl.panszelescik.api.CollectionUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.api.NumberUtils;

import java.util.List;

public class Zadanie42 {

    public static void main(String[] args) {
        List<Integer> liczby = FileUtils.mapFile("2019/Dane_PR2/liczby.txt", Integer::new);
        FileUtils.writeStream("rozwiazania/2019", "zadanie42.txt", CollectionUtils.createIntStream(liczby)
                .filter(liczba -> liczba == CollectionUtils
                        .createIntStream(NumberUtils.getDigits(liczba))
                        .map(NumberUtils::silnia)
                        .sum())
        );
    }
}