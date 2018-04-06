package rv;

public class ExitSimple extends Exit {

    public ExitSimple(Place from, Place to) {
        super(from, to);
    }

    @Override
    public void pass(Hero h) {
        h.setCurrentPlace(super.getTo());
        h.setEnergy(Exit.ENERGY_CONSUMED);
    }
}