package pl.panszelescik.matura2020.base;

public class StanKonta {

    public int talary;
    public final Statek statek;

    public StanKonta() {
        this.talary = 500_000;
        this.statek = null;
    }

    public StanKonta(StanKonta old, Statek statek) {
        this.talary = old.talary + statek.getCena();
        this.statek = statek;
    }

    @Override
    public String toString() {
        return statek != null ? "{" +
                "talary=" + talary +
                ", statek=" + statek +
                '}' : String.valueOf(talary);
    }
}