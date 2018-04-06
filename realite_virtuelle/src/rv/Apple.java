package rv;

public class Apple extends Stuff {
    public static final int RECOVERED_ENERGY = 3;
    public static final String APPLENAME = "Pomme";
    public static final String APPLEDESC = "Ceci est une pomme qui vous redonnera "
            + Apple.RECOVERED_ENERGY + " d'énergie si vous l'utilisez.";

    public Apple() {
        super(Apple.APPLENAME, Apple.APPLEDESC);
    }

    public void use(Hero h) {
        System.out.println("Vous avez regagné " + Apple.RECOVERED_ENERGY
                + " d'énergie ! ");
        h.setEnergy(Apple.RECOVERED_ENERGY);
        h.removeStuff(this);
    }
}
