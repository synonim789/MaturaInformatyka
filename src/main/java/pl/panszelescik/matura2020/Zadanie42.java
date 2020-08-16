package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.api.StringUtils;
import pl.panszelescik.matura2020.base.Para;

import java.util.List;
import java.util.Map;

public class Zadanie42 {

    public static void main(String[] args) {
        List<Para> pary = FileUtils.mapFile("2020/Dane_PR2/pary.txt", Para::new);
        FileUtils.writeStream("2020_zadanie42.txt", pary.stream()
                .map(para -> StringUtils.wordToMap(para.string))
                .map(map -> map.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get())
                .map(entry -> StringUtils.repeat(entry.getKey().toString(), entry.getValue()) + " " + entry.getValue()));
    }
}