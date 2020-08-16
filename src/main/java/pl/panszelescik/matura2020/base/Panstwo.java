package pl.panszelescik.matura2020.base;

import java.util.ArrayList;
import java.util.List;

public class Panstwo {

    public final String nazwa;
    public final String kontynent;
    public final double populacja;

    public Panstwo(String line) {
        String[] array = line.split("\t");
        this.nazwa = array[0];
        this.kontynent = array[1];
        this.populacja = Double.parseDouble(array[2].replace(",", "."));
    }

    @Override
    public String toString() {
        return "{" +
                "nazwa='" + nazwa + '\'' +
                ", kontynent='" + kontynent + '\'' +
                ", populacja=" + populacja +
                '}';
    }
}