package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.api.StringUtils;
import pl.panszelescik.matura2020.base.Para;

import java.util.Comparator;
import java.util.List;

public class Zadanie42 {

    public static void main(String[] args) {
        List<Para> pary = FileUtils.mapFile("2020/Dane_PR2/pary.txt", Para::new);
        FileUtils.writeStream("2020_zadanie42.txt", pary.stream()
                .map(para -> StringUtils.subString(para.string))
                .map(list -> list.stream()
                        .max(Comparator.comparing(pair -> pair.right))
                        .get())
                .map(pair -> StringUtils.repeat(pair.left.toString(), pair.right) + " " + pair.right));
    }
}