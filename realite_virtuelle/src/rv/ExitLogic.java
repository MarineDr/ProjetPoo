package rv;

public class ExitLogic extends Exit {

    private int minLogic;

    public ExitLogic(int minLogic, Place from, Place to) {
        super(from, to);
        this.minLogic = minLogic;
    }

    @Override
    public void pass(Hero h) {
        System.out.println("Vous devez avoir " + this.minLogic
                + " de logique pour entrer dans le dossier.");
        if (h.getLogic() < this.minLogic) {
            System.out.println("\nVous n'avez pas assez de logique !");
        } else {
            System.out.println(
                    "\nBravo, mais attention de ne pas vous croire plus malin que vous ne l'êtes...");
            h.setCurrentPlace(super.getTo());
            h.setEnergy(Exit.ENERGY_CONSUMED);
        }
    }

}
