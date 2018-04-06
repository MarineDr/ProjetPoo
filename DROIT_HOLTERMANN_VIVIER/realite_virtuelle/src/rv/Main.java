package rv;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/** Ici se trouve la classe main du jeu.*/
public final class Main {

    /** constructeur vide pour �viter les erreurs. */
    private Main() {

    }

    /** Ici se trouve la m�thode main !
     * @param args : pas d'arguments utiles
     * @throws FileNotFoundException : je ne sais pas ce qu'il faut dire !
     * @throws IOException : Je ne sais toujours pas ce qu'il faut dire !*/
    public static void main(final String[] args)
            throws FileNotFoundException, IOException {

        // Declaration des variables

        final int exitCodeMusique = 2746;
        final int exitCodeVideo = 5875;
        final int levelLogic5 = 5;
        final int levelLogic3 = 3;
        final int pointsLogic3 = 3;
        final int int3 = 3;
        final int int4 = 4;
        final int int5 = 5;
        final int int6 = 6;
        final int int7 = 7;

        // Declaration des descriptions des pièces

        String texteHome = "~~~\nVous vous trouvez dans une pièce blanche "
                + "sans porte ni fenêtre, avec des dossiers posés par terre. "
                + "Il est inscrit en noir sur tous les murs \"/home\".";
        String texteMusiques = "~~~\nVous êtes dans une pièce plus sombre, "
                + "dont les murs sont constellés des pochettes "
                + "d'albums de vos groupes favoris. "
                + "Il y a deux dossiers, et un fichier.";
        String texteVPLSTO = "~~~\nVous vous retrouvez dans une "
                + "pièce identique, "
                + "et un fichier \"cap_ou_pas_cap.txt\" est posé par terre";
        String texteVideos = "~~~\nLes murs de cette pièce "
                + "sont comme des écrans géants"
                + " sur lesquels passent des extraits de vidéos "
                + "ou vous pouvez reconnaître vos proches. "
                + "Un seul dossier \"Dossier_compromettant\" est présent "
                + "dans cette pièce,"
                + " à se demander si les développeurs se "
                + "compliquent pas la vie "
                + "pour rien ...";
        String texteImages = "~~~\nLes murs de la pièce dans "
                + "laquelle vous êtes "
                + "sont épinglés de vos photos de vacances en famille, "
                + "et au pied de l'un d'eux un fichier nommé "
                + "\"enigme2\" est posé.";
        String texteDocuments = "~~~\nIci, la lumière est parfaite pour lire "
                + "les multiples feuilles placardées au murs. "
                + "Un seul dossier trône dans la piece, tel un Graal.";
        String texteParIci = "~~~\nRien de spécial dans cette pièce "
                + "si ce n'est un fichier nommé "
                + "\"enigme1\" sur le sol";
        String texteSamples = "~~~\nDes vinyles sont éparpillés "
                + "dans cette pièce, ainsi que deux fichiers, "
                + "nommés \"sound_of_death\" et \"sound_of_defeat\"."
                + " Pas très encourageant...";
        String texteCompromettant = "~~~\nDans ce dossier, des images "
                + "de vous dans toutes les situations embarassantes"
                + " que vous avez vécues sont affichées. "
                + "Un fichier \"Nudes\" se pavane dans "
                + "le petit espace, vous suppliant presque de l'ouvrir...";
        String texteEnigmes = "~~~\nDes suites de chiffres "
                + "sans queue ni tête sillonnent les murs blancs. "
                + "Un fichier semble vous attendre, "
                + "trônant au milieu de la piece : \"enigme10\".";
        String texteTravail = "~~~\nDans cette piece, un objet étrange"
                + " vous interpelle : c'est un rouage"
                + " s'appelant \"decrypteur\". "
                + "Peut-être vous sera-t-il utile ... "
                + "Un dossier plus discret est posé derrière.";
        String texteProjets = "~~~\nCette pièce est presque vide,"
                + " même les murs sont pauvres de trois pages"
                + " de code (du C peut-être ?) qui se battent"
                + " en duel. Un fichier assez volumineux nommé"
                + " \"projet_POO\" se promène dans la piece.";

        // Declaration des pieces avec une liste de sorties vide

        Place home = new Place("/home", texteHome);
        Place musiques = new Place("Musiques", texteMusiques);
        Place viensvoir = new Place("viens_voir", texteVPLSTO);
        Place videos = new Place("Videos", texteVideos);
        Place images = new Place("Images", texteImages);
        Place documents = new Place("Documents", texteDocuments);
        Place parIci = new Place("Par_ici", texteParIci);
        Place samples = new Place("Samples", texteSamples);
        Place compromettant = new Place("Dossier_compromettant",
                texteCompromettant);
        Place enigmes = new Place("Dossier_enigmes", texteEnigmes);
        Place travail = new Place("Travail", texteTravail);
        Place projets = new Place("Dossier_projet", texteProjets);

        // Ajout des sorties specifiques a chaque Place :

        home.addExit(new ExitSimple(home, viensvoir));
        home.addExit(new ExitSimple(home, musiques));
        home.addExit(new ExitSimple(home, images));
        home.addExit(new ExitSimple(home, videos));
        home.addExit(new ExitSimple(home, documents));

        musiques.addExit(new ExitCode(exitCodeMusique, musiques, samples));
        musiques.addExit(new ExitLogic(levelLogic5, musiques, enigmes));
        musiques.addExit(new ExitSimple(musiques, home));

        viensvoir.addExit(new ExitSimple(viensvoir, parIci));
        viensvoir.addExit(new ExitSimple(viensvoir, home));

        videos.addExit(new ExitCode(exitCodeVideo, videos, compromettant));
        videos.addExit(new ExitSimple(videos, home));

        images.addExit(new ExitSimple(images, home));

        documents.addExit(new ExitLogic(levelLogic3, documents, travail));
        documents.addExit(new ExitSimple(documents, home));

        parIci.addExit(new ExitSimple(parIci, viensvoir));

        samples.addExit(new ExitSimple(samples, musiques));

        compromettant.addExit(new ExitSimple(compromettant, videos));

        enigmes.addExit(new ExitSimple(enigmes, travail));

        travail.addExit(new ExitSimple(travail, projets));
        travail.addExit(new ExitSimple(travail, documents));

        projets.addExit(new ExitSimple(projets, travail));

        // Declaration des textes des énigmes :

        String en1 = "C'est le point commun d'un opportun "
                + "et de tout un chacun.";
        String en2 = "Mon homonyme peut être de lait ou avoir la rage,"
                + " et je désigne l'intérieur.";
        String en3 = "Je suis un saint qui n'aime pas le thé.";
        String en4 = "Manger cinq fruits et légumes l'est.";
        String en5 = "La première partie de mon mot "
                + "est une fois dans une minute, mais zéro fois "
                + "dans une seconde. \nLa deuxième partie de "
                + "mon mot est deux fois dans l'année "
                + "mais une seule fois par an.";
        String en6 = "L'existence d'un être dépend de moi,"
                + " et lorsqu'il cesse d'exister "
                + "je deviens inerte et l'on m'enterre.";
        String en7 = "Mon premier est une lettre de "
                + "l'alphabet associée au bruit du serpent, "
                + "\nmon second, on le fait pour montrer sa foi, "
                + "\nmon tout est un concept abstrait de l'existence hummaine.";

        // Declaration des fichiers énigmes

        Doc enigme1 = new Enigma("un", 1, "enigme1", en1);
        Doc enigme2 = new Enigma("dans", 2, "enigme2", en2);
        Doc enigme3 = new Enigma("sain", 2, "sound_of_defeat", en3);
        Doc enigme4 = new Enigma("sain", pointsLogic3, "sound_of_death", en4);
        Doc enigme5 = new Enigma("un", 1, "enigme5", en5);
        Doc enigme6 = new Enigma("corps", pointsLogic3, "nudes", en6);
        Doc enigme7 = new Enigma("esprit", pointsLogic3, "projet_POO", en7);

        // Déclaration des texte des fichiers

        String texteCOPC = "Lorsque vous touchez le fichier, "
                + "un texte s'affiche dans les airs devant vos yeux : "
                + " \"Bienvenue ! Si tu veux sortir "
                + "de mon systeme de fichiers, "
                + "il va te falloir réunir 7 clefs."
                + " Ces dernières sont sous forme de mots, "
                + "qui, une fois assemblés, formeront la phrase a prononcer"
                + " pour t'échapper ... Bonne chance !"
                + " Oh, et si tu te sens bien ici, "
                + "sache tu as une énergie limitée, "
                + "chaque déplacement t'en coûte... "
                + "Mange des pommes pour t'en redonner ! Bonne chance ! ";
        String texteEnigme10 = "Contenu du fichier : \n Ha ! Je t'ai eu ! "
                + "tu pensais vraiment qu'il y avait 10 énigmes "
                + "pour 7 mots a trouver ? "
                + "Allez, retourne a ta chasse aux mots !";

        // Déclaration des fichiers

        Doc cOPC = new Doc("cap_ou_pas_cap.txt", texteCOPC);
        Doc enigme10 = new Doc("enigme10", texteEnigme10);

        // Ajout des énigmes et des fichiers se trouvant dans les dossiers

        musiques.addFile(enigme5);
        viensvoir.addFile(cOPC);
        parIci.addFile(enigme1);
        samples.addFile(enigme4);
        samples.addFile(enigme3);
        compromettant.addFile(enigme6);
        enigmes.addFile(enigme10);
        projets.addFile(enigme7);
        images.addFile(enigme2);

        // Ajout du decrypteur
        travail.addStuff(new Paper("decrypteur",
                "Cet objet sert manifestement à "
                + "décrypter des codes à 4 chiffres."));

        // =========================================================
        // ==== HERE COMES THE REAL MAIN !!!!!! ====
        // =========================================================

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner sc = new Scanner(new File("contexte.txt"));
        String str = sc.nextLine();
        Command comm = Command.valueOf("none");
        Stuff stuff;
        boolean validComm = false;
        String[] tab, answer = new String[7];
        answer[0] = "un";
        answer[1] = "esprit";
        answer[2] = "sain";
        answer[int3] = "dans";
        answer[int4] = "un";
        answer[int5] = "corps";
        answer[int6] = "sain";

        while (sc.hasNext()) {
            System.out.println(str);
            str = sc.nextLine();
        }

        sc = new Scanner(System.in);
        System.out
                .println("\nEntrez le nom de votre personnage (définitif) : ");
        String name = sc.nextLine();
        System.out.println("\nBienvenue " + name + " !\n");

        Hero mainCharacter = new Hero(name, home);
        System.out.println(mainCharacter.getCurrentPlace().TEXT);

        while (mainCharacter.getEnergy() >= 0) { // Boucle principale du jeu

            System.out.print("Que faire ? ");
            str = sc.nextLine();
            tab = str.split(" ", int7);

            for (Command c : Command.values()) {
                if (tab[0].equalsIgnoreCase(c.toString())) {
                    validComm = true;
                    comm = Command.valueOf(tab[0]);
                }
            }
            if (!validComm) {
                comm = Command.valueOf("none");
            }
            validComm = false;
            System.out.println();
            switch (comm) {
                case aller :
                    if (tab.length > 1) {
                        comm.aller(tab[1], mainCharacter);
                        System.out
                                .println(mainCharacter.getCurrentPlace().TEXT);
                    } else {
                        System.out.println("Aller ou ?");
                    }
                    break;

                case aide :
                    comm.aide();
                    break;

                case observer :
                    if (tab.length > 1) {
                        // ne doit pas fonctionner pour l'usage voulu...

                        stuff = mainCharacter.searchInventory(tab[1]);
                        if (stuff != null) {
                            comm.observer(stuff);
                        }
                    } else {
                        comm.observer(mainCharacter.getCurrentPlace());
                    }
                    break;

                case prendre :
                    if (tab.length > 1) {
                        stuff = mainCharacter.getCurrentPlace()
                                .searchStuff(tab[1]);
                        if (stuff != null) {
                            mainCharacter.addInventory(stuff);
                            mainCharacter.getCurrentPlace().supprStuff(stuff);
                        }
                    } else {
                        System.out.println("Prendre quoi ? ");
                    }

                    break;

                case quitter :
                    comm.quitter();
                    break;

                case utiliser :
                    if (tab.length > 1) {
                        stuff = mainCharacter.searchInventory(tab[1]);
                        if (tab.length > 2) {
                            Stuff s2 = mainCharacter.searchInventory(tab[2]);
                            if (stuff != null && s2 != null) {
                                comm.utiliser(stuff, s2);
                            }
                        } else {
                            comm.utiliser(stuff, mainCharacter);
                        }
                    } else {
                        System.out.println("Utiliser quoi ?");
                    }

                    break;

                case inventaire :
                    mainCharacter.printCharac();
                    break;

                case ouvrir :
                    if (tab.length > 1) {
                        Doc d = mainCharacter.getCurrentPlace()
                                .searchFile(tab[1]);
                        if (d != null) {
                            comm.ouvrir(d, mainCharacter);
                        }
                    } else {
                        System.out.println("Ouvrir quoi ?");
                    }
                    break;

                case un :
                    if (tab.length > int6) {
                        boolean win = true;
                        for (int i = 0; i < int7; i++) {
                            if (!tab[i].equalsIgnoreCase(answer[i])) {
                                win = false;
                            }
                        }
                        if (win) {
                            System.out.println(
                                    "Tout ce que vous voyez commence à se "
                                    + "désintégrer en pixels, "
                                            + "et tout devient vite noir. "
                                            + "Une lumière  verte familière "
                                            + "et des séries de "
                                            + "chiffres binaires vous "
                                            + "rappellent votre arrivée, "
                                            + "quand une douleur vive au"
                                            + " front vous ramène brutalement "
                                            + "à la réalité. "
                                            + "Vous vous relevez d'un coup et"
                                            + " constatez être de retour "
                                            + "devant votre ordinateur. "
                                            + "Sur l'écran noir vous "
                                            + "voyez votre reflet pourvu de "
                                            + "marques de clavier, "
                                            + "ainsi qu'une unique fenêtre"
                                            + " contenant le célèbre adage : "
                                            + "\"Un esprit sain dans "
                                            + "un corps sain.\"");
                            comm.quitter();
                        } else {
                            System.out.println("Raté, recommencez !");
                        }
                    } else {
                        System.out.println(
                                "Bien essayé, mais trop peu de mots !");
                    }

                default :
                    System.out.println("Commande invalide, recommencez !");
            }
            System.out.println();
        }

    }

}

