package pl.panszelescik.matura2020;

import pl.panszelescik.api.API;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Uzytkownik;

import java.util.List;

public class Zadanie52 {

    public static void main(String[] args) {
        List<Jezyk> jezyki = API.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik> uzytkownicy = API.mapFile("2020/Dane_PR2/uzytkownicy.txt", Uzytkownik::new, 1);
        uzytkownicy.stream()
                .filter(uzytkownik -> uzytkownik.urzedowy)
                .forEach(uzytkownik -> jezyki.removeIf(jezyk -> uzytkownik.nazwaJezyka.equals(jezyk.nazwa)));
        System.out.println(jezyki.size());
        API.write("2020_zadanie52.txt", writer -> writer.write(jezyki.size()));
    }
}