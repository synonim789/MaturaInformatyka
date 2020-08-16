package pl.panszelescik.matura2020.base;

import pl.panszelescik.api.NumberUtils;

import java.math.BigDecimal;

public class Uzytkownik {

    public final String nazwaPanstwa;
    public final String nazwaJezyka;
    public final double ilosc;
    public final String iloscString;
    public final boolean urzedowy;

    public Uzytkownik(String line) {
        String[] array = line.split("\t");
        this.nazwaPanstwa = array[0];
        this.nazwaJezyka = array[1];
        this.iloscString = array[2].replace(",", ".");
        this.ilosc = NumberUtils.parseDouble(this.iloscString);
        this.urzedowy = array[3].equals("tak");
    }

    public BigDecimal getAsBigDecimal() {
        return new BigDecimal(iloscString);
    }

    @Override
    public String toString() {
        return "{" +
                "panstwo='" + nazwaPanstwa + '\'' +
                ", jezyk='" + nazwaJezyka + '\'' +
                ", ilosc=" + ilosc +
                ", urzedowy=" + urzedowy +
                '}';
    }
}