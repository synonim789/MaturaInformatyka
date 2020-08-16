package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.Jezyk;
import pl.panszelescik.matura2020.base.Panstwo;
import pl.panszelescik.matura2020.base.Uzytkownik54;

import java.text.DecimalFormat;
import java.util.List;

public class Zadanie55 {

    public static final DecimalFormat format = new DecimalFormat("0.00");

    public static void main(String[] args) {
        List<Panstwo> panstwa = FileUtils.mapFile("2020/Dane_PR2/panstwa.txt", Panstwo::new, 1);
        List<Jezyk> jezyki = FileUtils.mapFile("2020/Dane_PR2/jezyki.txt", Jezyk::new, 1);
        List<Uzytkownik54> uzytkownicy = FileUtils.mapFile("2020/Dane_PR2/uzytkownicy.txt", line -> new Uzytkownik54(line, panstwa, jezyki), 1);

        FileUtils.writeStream("2020_zadanie55.txt", uzytkownicy.stream()
                .filter(uzytkownik -> !uzytkownik.urzedowy)
                .filter(uzytkownik -> uzytkownik.ilosc / uzytkownik.panstwo.populacja >= 0.3)
                .map(uzytkownik -> uzytkownik.panstwo.nazwa + " " + uzytkownik.jezyk.nazwa + " " + format.format(uzytkownik.ilosc / uzytkownik.panstwo.populacja * 100) + "%"));
    }
}