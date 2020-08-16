package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.api.NumberUtils;
import pl.panszelescik.matura2020.base.Para;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie41 {

    public static void main(String[] args) {
        List<Para> pary = FileUtils.mapFile("2020/Dane_PR2/pary.txt", Para::new);
        FileUtils.writeStream("rozwiazania/2020", "zadanie41.txt", pary.stream()
                .filter(para -> NumberUtils.isEven(para.number))
                .map(para -> NumberUtils.primeToEvenNumbers(para.number))
                .map(set -> set.stream()
                        .min(Comparator.comparingInt(NumberUtils::sumIntList))
                        .get())
                .peek(list -> list.add(0, NumberUtils.sumIntList(list)))
                .map(list -> list.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(" "))));
    }
}