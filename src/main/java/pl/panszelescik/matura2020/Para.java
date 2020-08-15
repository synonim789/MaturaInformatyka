package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;

public class Para {

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