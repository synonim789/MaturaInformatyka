package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie41 {

    public static void main(String[] args) {
        List<Para> pary = API.mapFile("Dane_PR2/pary.txt", Para::new);
        //pary.forEach(API.PRINTER);
        API.write("2020_zadanie41.txt", writer -> {
            pary.stream()
                    .filter(para -> API.isEven(para.number))
                    .map(para -> API.primeToEvenNumbers(para.number))
                    .map(set -> set.stream()
                            .min(Comparator.comparingInt(API::sumIntList))
                            .get())
                    .peek(list -> list.add(0, API.sumIntList(list)))
                    //.peek(API.PRINTER)
                    .forEach(list -> writer.write(list.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining(" ")) + "\n"));
        });
    }
}