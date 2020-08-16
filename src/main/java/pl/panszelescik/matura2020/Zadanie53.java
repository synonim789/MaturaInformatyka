package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Panstwo;
import pl.panszelescik.matura2020.base.Uzytkownik53;

import java.util.*;

public class Zadanie53 {

    public static void main(String[] args) {
        List<Panstwo> panstwa = API.mapFile("2020/Dane_PR2/panstwa.txt", Panstwo::new, 1);
        List<Jezyk> jezyki = API.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik53> uzytkownicy = API.mapFile("2020/Dane_PR2/uzytkownicy.txt", line -> new Uzytkownik53(line, panstwa, jezyki), 1);
        Map<String, Set<String>> valid = new HashMap<>();

        uzytkownicy.forEach(uzytkownik -> valid.merge(uzytkownik.jezyk.nazwa, new HashSet<>(Collections.singletonList(uzytkownik.panstwo.kontynent)), (set, unneeded) -> {
            set.add(uzytkownik.panstwo.kontynent);
            return set;
        }));

        API.writeStream("2020_zadanie53.txt", valid.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= 4)
                .map(Map.Entry::getKey));
    }

    public static Jezyk getJezyk(List<Jezyk> jezyki, String name) {
        return jezyki.stream()
                .filter(jezyk -> jezyk.nazwa.equals(name))
                .findFirst()
                .get();
    }

    public static Panstwo getPanstwo(List<Panstwo> panstwa, String name) {
        return panstwa.stream()
                .filter(panstwo -> panstwo.nazwa.equals(name))
                .findFirst()
                .get();
    }
}