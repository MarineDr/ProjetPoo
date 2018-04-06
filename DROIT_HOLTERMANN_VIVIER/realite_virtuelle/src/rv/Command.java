package rv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public enum Command {
    aller, aide, observer, prendre, quitter, utiliser, inventaire, un, // pour
                                                                       // déclencher
                                                                       // la
                                                                       // vérification
                                                                       // de la
                                                                       // phrase
                                                                       // à
                                                                       // prononcer
    ouvrir, none; // pour gérer les cas ou la commande est invalide

    public void aller(String s, Hero h) {
        boolean b = false;
        for (Exit e : h.getCurrentPlace().getListExit()) {
            if (s.equalsIgnoreCase(e.getTo().getName())) {
                e.pass(h);
                b = true;
            }
        }
        if (!b) {
            System.out.println("Le dossier n'existe pas !");
        }
    }

    // faire des diagrammes d'états et de séquences pour une fonctionnalité
    public void aide() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("aide.txt"));
        String str = sc.nextLine();
        while (sc.hasNext()) {
            System.out.println(str);
            str = sc.nextLine();
        }

    }

    public void observer(Place p) {
        p.printPlace();
    }

    public void observer(Stuff s) {
        System.out.println("| " + s.toString() + " | " + s.getDescription());
    }

    public void quitter() {
        System.out.println("Au revoir, et peut-être à bientôt...");
        System.exit(0);
    }

    public void utiliser(Stuff s, Hero h) {
        s.use(h);
    }

    public void utiliser(Stuff s1, Stuff s2) {
        if (s1.toString().equalsIgnoreCase("decrypteur")
                && s2.toString().equalsIgnoreCase("Code1"))
            s2.decrypt();
        else if (s1.toString().equalsIgnoreCase("decrypteur")
                && s2.toString().equalsIgnoreCase("Code2"))
            s2.decrypt();
        else
            System.out.println(
                    "Vous n'avez pas utilisé le(s) bon(s) objet(s) ! (le decrypteur doit etre en premier)");
    }

    public void ouvrir(Doc d, Hero h) {
        d.open(h);
        System.out.println(h.getCurrentPlace().TEXT);
    }

}
