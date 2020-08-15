package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;

import java.util.List;
import java.util.Map;

public class Zadanie42 {

    public static void main(String[] args) {
        List<Para> pary = API.mapFile("2020/Dane_PR2/pary.txt", Para::new);
        //pary.forEach(API.PRINTER);
        API.writeStream("2020_zadanie42.txt", pary.stream()
                .map(para -> API.wordToMap(para.string))
                .map(map -> map.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .get())
                .map(entry -> API.repeat(entry.getKey().toString(), entry.getValue()) + " " + entry.getValue()));
    }
}