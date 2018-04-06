package rv;

import java.util.Scanner;

/**Classe Enigmes.*/
public class Enigma extends Doc {

    /**Savoir si l'�nigme � �t� r�solue.*/
    private boolean resolved = false;
    /**R�ponse de l'�nigme.*/
    private final String answer;
    /**la r�compense pour r�soudre l'�nigme.*/
    private final int award;

    /**Constructeur.
     * @param as : reponse
     * @param aw : recompense
     * @param n : nom
     * @param t : texte */
    public Enigma(final String as, final int aw,
            final String n, final String t) {
        super(n, t);
        this.answer = as;
        this.award = aw;
    }

    public void open(Hero h) {
        System.out.println("Ouverture de l'énigme ...");

        if (!this.resolved) {
            Scanner sc = new Scanner(System.in);

            System.out.println(super.texte);
            System.out.print("Votre réponse : ");
            String ans = sc.next();
            while (!ans.equalsIgnoreCase(this.answer)
                    && !ans.equalsIgnoreCase("quitter")) {
                System.out.println("\nRaté ! Essaie encore : ");
                System.out.println(super.texte);
                System.out.print("Votre réponse :");
                ans = sc.next();
            }

            if (ans.equals(this.answer)) {
                System.out.println("Bravo !");

                h.addLogic(award);
                System.out.println("Vous venez de gagner " + this.award
                        + " points de logique !\n");
                this.resolved = true;

                // En fonction des énigmes, on fait apparaitre des objets
                // spécifiques
                if (this.NAME.equalsIgnoreCase("enigme1")) {
                    h.getCurrentPlace().addStuff(
                            new Code("Code1", "Ce code te sera utile : 5875"));
                    System.out.println(
                            "Trois objets ont été ajoutés dans la pièce !\n");
                } else if (this.NAME.equalsIgnoreCase("enigme2")) {
                    h.getCurrentPlace().addStuff(
                            new Code("Code2", "Ce code te sera utile : 2746"));
                    System.out.println(
                            "Trois objets ont été ajoutés dans la pièce !\n");
                } else {
                    System.out.println(
                            "Deux objets ont été ajoutés dans la pièce !\n");
                }
                h.getCurrentPlace().addStuff(new Paper(this.answer,
                        "Le contenu de ce bout de papier est le meme que son titre : "
                                + this.answer));
                h.getCurrentPlace().addStuff(new Apple());
            }
        } else {
            System.out.println("Enigme déjà résolue !");
        }

    }
}
