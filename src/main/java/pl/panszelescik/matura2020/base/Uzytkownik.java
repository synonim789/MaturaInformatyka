package pl.panszelescik.matura2020.base;

public class Uzytkownik {

    public final String nazwaPanstwa;
    public final String nazwaJezyka;
    public final double ilosc;
    public final boolean urzedowy;

    public Uzytkownik(String line) {
        String[] array = line.split("\t");
        this.nazwaPanstwa = array[0];
        this.nazwaJezyka = array[1];
        this.ilosc = Double.parseDouble(array[2].replace(",", "."));
        this.urzedowy = array[3].equalsIgnoreCase("tak");
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