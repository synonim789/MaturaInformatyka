package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Para;

import java.util.List;

public class Zadanie43 {

    public static void main(String[] args) {
        List<Para> pary = FileUtils.mapFile("2020/Dane_PR2/pary.txt", Para::new);
        pary.stream()
                .sorted((para1, para2) -> {
                    if (para1.number < para2.number) {
                        return -1;
                    }
                    if (para1.number == para2.number && para1.string.compareTo(para2.string) < 0) {
                        return -1;
                    }
                    return 1;
                })
                .filter(para -> para.number == para.string.length())
                .findFirst()
                .ifPresent(para -> {
                    String string = para.number + " " + para.string;
                    FileUtils.write("rozwiazania/2020", "zadanie43.txt", writer -> writer.write(string));
                    System.out.println(string);
                });
    }
}