package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Panstwo;
import pl.panszelescik.matura2020.base.Uzytkownik;
import pl.panszelescik.matura2020.base.Uzytkownik54;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Zadanie54 {

    public static void main(String[] args) {
        List<Panstwo> panstwa = FileUtils.mapFile("2020/Dane_PR2/panstwa.txt", Panstwo::new, 1);
        List<Jezyk> jezyki = FileUtils.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik54> uzytkownicy = FileUtils.mapFile("2020/Dane_PR2/uzytkownicy.txt", line -> new Uzytkownik54(line, panstwa, jezyki), 1);

        FileUtils.writeStream("rozwiazania/2020", "zadanie54.txt", uzytkownicy.stream()
                        .filter(uzytkownik -> (uzytkownik.panstwo.kontynent.equals("Ameryka Poludniowa") || uzytkownik.panstwo.kontynent.equals("Ameryka Polnocna")) && !uzytkownik.jezyk.rodzina.equals("indoeuropejska"))
                        .collect(Collectors.toMap(uzytkownik -> uzytkownik.jezyk, Uzytkownik::getAsBigDecimal, BigDecimal::add))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(6)
                        .map(entry -> entry.getKey().nazwa + " " + entry.getKey().rodzina + " " + entry.getValue()));
    }
}