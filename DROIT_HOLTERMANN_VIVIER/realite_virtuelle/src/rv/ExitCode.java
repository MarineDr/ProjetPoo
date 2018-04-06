package rv;

import java.util.Scanner;

public class ExitCode extends Exit {

    private final int CODE;

    public ExitCode(int CODE, Place from, Place to) {
        super(from, to);
        this.CODE = CODE;
    }

    @Override
    public void pass(Hero h) {
        Scanner sc = new Scanner(System.in);
        int code = -1;

        while (code != this.CODE && code != 0) {
            System.out.print(
                    "Veuillez entrer le code (4 chiffres) pour déverouiller le dossier ou 0 pour quitter : ");
            code = sc.nextInt();
        }

        if (code == this.CODE) {
            h.setCurrentPlace(super.getTo());
            h.setEnergy(Exit.ENERGY_CONSUMED);
        }
    }

}
