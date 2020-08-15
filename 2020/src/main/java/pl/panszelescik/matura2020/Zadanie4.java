package pl.panszelescik.matura2020;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zadanie4 {

    public static void main(String[] args) {
        List<String> lines = API.read("Dane_PR2/pary.txt");
        List<Para> pary = lines.stream()
                .map(Para::new)
                .collect(Collectors.toList());
        //pary.forEach(FileUtils.PRINTER);
        zadanie1(pary);
    }

    public static void zadanie1(List<Para> pary) {
        API.write("pary.txt", writer -> {
            pary.stream()
                    .filter(para -> API.isEven(para.number))
                    .map(para -> API.primeToEvenNumbers(para.number))
                    .map(set -> set.stream()
                            .min(Comparator.comparingInt(API::sumIntList))
                            .get())
                    .peek(list -> list.add(0, API.sumIntList(list)))
                    //.peek(FileUtils.PRINTER)
                    .forEach(list -> writer.write(list.stream().map(Object::toString).collect(Collectors.joining(" ")) + "\n"));
        });
    }

    public static final class Para {

        public final int number;
        public final String string;

        public Para(String line) {
            String[] array = line.split(" ");
            this.number = API.parse(array[0]);
            this.string = array[1];
        }

        @Override
        public String toString() {
            return "{" +
                    "number=" + number +
                    ", string='" + string + '\'' +
                    '}';
        }
    }
}