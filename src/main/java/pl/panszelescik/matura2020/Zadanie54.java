package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Panstwo;
import pl.panszelescik.matura2020.base.Uzytkownik54;

import java.math.BigDecimal;
import java.util.*;

public class Zadanie54 {

    public static void main(String[] args) {
        List<Panstwo> panstwa = API.mapFile("2020/Dane_PR2/panstwa.txt", Panstwo::new, 1);
        List<Jezyk> jezyki = API.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik54> uzytkownicy = API.mapFile("2020/Dane_PR2/uzytkownicy.txt", line -> new Uzytkownik54(line, panstwa, jezyki), 1);

        Map<Jezyk, BigDecimal> uzywanie = new HashMap<>();
        uzytkownicy.stream()
                .filter(uzytkownik -> (uzytkownik.panstwo.kontynent.equals("Ameryka Poludniowa") || uzytkownik.panstwo.kontynent.equals("Ameryka Polnocna")) && !uzytkownik.jezyk.rodzina.equals("indoeuropejska"))
                .forEach(uzytkownik -> uzywanie.merge(uzytkownik.jezyk, uzytkownik.getAsBigDecimal(), BigDecimal::add));

        API.writeStream("2020_zadanie54.txt", uzywanie.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(6)
                .map(entry -> entry.getKey().nazwa + " " + entry.getKey().rodzina + " " + entry.getValue()));
    }
}