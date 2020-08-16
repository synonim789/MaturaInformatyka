package pl.panszelescik.matura2020.base;

public class Jezyk {

    public final String nazwa;
    public final String rodzina;

    public Jezyk(String line) {
        String[] array = line.split("\t");
        this.nazwa = array[0];
        this.rodzina = array[1];
    }

    @Override
    public String toString() {
        return "{" +
                "nazwa='" + nazwa + '\'' +
                ", rodzina='" + rodzina + '\'' +
                '}';
    }
}