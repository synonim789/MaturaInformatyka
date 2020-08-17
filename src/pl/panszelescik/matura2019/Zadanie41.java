package pl.panszelescik.matura2019;

import pl.panszelescik.api.CollectionUtils;
import pl.panszelescik.api.FileUtils;

import java.util.List;

public class Zadanie41 {

    public static void main(String[] args) {
        List<Integer> liczby = FileUtils.mapFile("2019/Dane_PR2/liczby.txt", Integer::new);
        FileUtils.writeStream("rozwiazania/2019", "zadanie41.txt", CollectionUtils.createIntStream(liczby)
                .filter(number -> {
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {
                        int x = (int) Math.pow(3, i);
                        if (x > 1_000_000) {
                            return false;
                        }
                        if (x == number) {
                            return true;
                        }
                    }
                    return false;
                }));
    }
}