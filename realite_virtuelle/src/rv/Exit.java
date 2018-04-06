package rv;

public abstract class Exit {

    public static final int ENERGY_CONSUMED = -1;
    private final Place to;
    private final Place from;

    abstract public void pass(Hero h);

    public Exit(Place from, Place to) {
        this.to = to;
        this.from = from;
    }

    @Override
    public String toString() {
        return this.to.NAME;
    }

    public Place getTo() {
        return this.to;
    }

    public Place getFrom() {
        return this.from;
    }

}
