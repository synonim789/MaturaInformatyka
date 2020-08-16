package pl.panszelescik.matura2020;

import pl.panszelescik.api.FileUtils;
import pl.panszelescik.matura2020.base.StanKonta;
import pl.panszelescik.matura2020.base.Statek;
import pl.panszelescik.matura2020.base.Type;

import java.util.ArrayList;
import java.util.List;

public class Zadanie65 {

    public static void main(String[] args) {
        List<Statek> statki = FileUtils.mapFile("2020/Dane_PR2/statek.txt", Statek::new, 1);
        StanKonta stanKonta = new StanKonta();
        List<StanKonta> list = new ArrayList<>();
        for (Statek statek : statki) {
            stanKonta = new StanKonta(stanKonta, statek);
            list.add(stanKonta);
        }

        FileUtils.write("rozwiazania/2020", "zadanie65.txt", writer -> {
            int count = list.get(list.size() - 1).talary;
            writer.writeLine(count);
            writer.write("\n");
            System.out.println(count);

            list.stream()
                    .filter(konto -> konto.statek.type.equals(Type.ZALADUNEK))
                    .max(StanKonta::compareTo)
                    .ifPresent(konto -> {
                        String string = konto.statek.date + " " + konto.talary;
                        writer.writeLine(string);
                        writer.write("\n");
                        System.out.println(string);
                    });

            list.stream()
                    .mapToInt(konto -> konto.talary)
                    .min()
                    .ifPresent(num -> {
                        int min = -num + 500_000;
                        writer.writeLine(min);
                        System.out.println(min);
                    });
        });
    }
}