package pl.panszelescik.matura2020.base;

public class StanKonta implements Comparable<StanKonta> {

    public int talary;
    public final Statek statek;
    public final int index;

    public StanKonta() {
        this.talary = 500_000;
        this.statek = null;
        this.index = 0;
    }

    public StanKonta(StanKonta old, Statek statek) {
        this.talary = old.talary + statek.getCena();
        this.statek = statek;
        this.index = old.index + 1;
    }

    @Override
    public String toString() {
        return statek != null ? "{" +
                "talary=" + talary +
                ", statek=" + statek +
                ", index=" + index +
                '}' : String.valueOf(talary);
    }

    @Override
    public int compareTo(StanKonta o) {
        if (this.statek.date.equals(o.statek.date)) {
            return Integer.compare(this.index, o.index);
        }
        return Integer.compare(this.talary, o.talary);
    }
}