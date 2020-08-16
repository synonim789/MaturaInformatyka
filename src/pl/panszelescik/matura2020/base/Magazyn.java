package pl.panszelescik.matura2020.base;

import pl.panszelescik.api.NumberUtils;

import java.util.HashMap;

public class Magazyn extends HashMap<String, Integer> {

    public void myAdd(String towar, int ton) {
        this.merge(towar, ton, Integer::sum);
    }

    public void myRemove(String towar, int ton) {
        this.merge(towar, ton, NumberUtils::substract);
    }

    public void myCount(Statek statek) {
        if (statek.type.equals(Type.ZALADUNEK)) {
            this.myAdd(statek.towar, statek.waga);
        } else if (statek.type.equals(Type.WYLADUNEK)) {
            this.myRemove(statek.towar, statek.waga);
        }
    }
}