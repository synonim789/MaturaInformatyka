package pl.panszelescik.matura2020.base;

import pl.panszelescik.api.DateUtils;
import pl.panszelescik.api.NumberUtils;

import java.time.LocalDate;

public class Statek {

    public final LocalDate date;
    public final String port;
    public final String towar;
    public final Type type;
    public final int waga;
    public final int cena;

    public Statek(String line) {
        String[] array = line.split("\t");
        this.date = DateUtils.parse(array[0], "yyyy-MM-dd");
        this.port = array[1];
        this.towar = array[2];
        this.type = array[3].equals("W") ? Type.WYLADUNEK : array[3].equals("Z") ? Type.ZALADUNEK : null;
        this.waga = NumberUtils.parseInt(array[4]);
        this.cena = NumberUtils.parseInt(array[5]);
    }

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", port='" + port + '\'' +
                ", towar='" + towar + '\'' +
                ", type=" + type +
                ", waga=" + waga +
                ", cena=" + cena +
                '}';
    }
}