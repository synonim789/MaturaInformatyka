package pl.panszelescik.matura2020.base;

import pl.panszelescik.matura2020.Zadanie53;

import java.util.List;

public class Uzytkownik53 extends Uzytkownik {

    public final Panstwo panstwo;
    public final Jezyk jezyk;

    public Uzytkownik53(String line, List<Panstwo> panstwa, List<Jezyk> jezyki) {
        super(line);
        String[] array = line.split("\t");
        this.panstwo = Zadanie53.getPanstwo(panstwa, array[0]);
        this.jezyk = Zadanie53.getJezyk(jezyki, array[1]);
    }

    @Override
    public String toString() {
        return "{" +
                "panstwo='" + panstwo + '\'' +
                ", jezyk='" + jezyk + '\'' +
                ", ilosc=" + ilosc +
                ", urzedowy=" + urzedowy +
                '}';
    }
}