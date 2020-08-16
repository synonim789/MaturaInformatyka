package pl.panszelescik.matura2020;

import pl.panszelescik.api.CollectionUtils;
import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Panstwo;
import pl.panszelescik.matura2020.base.Uzytkownik53;

import java.util.*;

public class Zadanie53 {

    public static void main(String[] args) {
        List<Panstwo> panstwa = FileUtils.mapFile("2020/Dane_PR2/panstwa.txt", Panstwo::new, 1);
        List<Jezyk> jezyki = FileUtils.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik53> uzytkownicy = FileUtils.mapFile("2020/Dane_PR2/uzytkownicy.txt", line -> new Uzytkownik53(line, panstwa, jezyki), 1);
        Map<String, Set<String>> valid = new HashMap<>();

        uzytkownicy.forEach(uzytkownik -> {
            valid.putIfAbsent(uzytkownik.jezyk.nazwa, new HashSet<>());
            valid.computeIfPresent(uzytkownik.jezyk.nazwa, (key, set) -> CollectionUtils.add(set, uzytkownik.panstwo.kontynent));
        });

        FileUtils.writeStream("2020_zadanie53.txt", valid.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 4)
                .map(Map.Entry::getKey));
    }

    public static Jezyk getJezyk(List<Jezyk> jezyki, String name) {
        return CollectionUtils.getFromList(jezyki, jezyk -> jezyk.nazwa.equals(name));
    }

    public static Panstwo getPanstwo(List<Panstwo> panstwa, String name) {
        return CollectionUtils.getFromList(panstwa, panstwo -> panstwo.nazwa.equals(name));
    }
}