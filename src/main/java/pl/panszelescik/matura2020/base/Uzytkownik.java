package pl.panszelescik.matura2020.base;

public class Uzytkownik {

    public final String panstwo;
    public final String jezyk;
    public final double ilosc;
    public final boolean urzedowy;

    public Uzytkownik(String line) {
        String[] array = line.split("\t");
        this.panstwo = array[0];
        this.jezyk = array[1];
        this.ilosc = Double.parseDouble(array[2]);
        this.urzedowy = array[3].equalsIgnoreCase("tak") ? true : false;
    }
}