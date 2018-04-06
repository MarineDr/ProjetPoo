
package rv;

import java.util.ArrayList;
import java.util.List;

public class Place {

    public final String NAME;
    public final String TEXT;
    private final List<Exit> LISTEXIT = new ArrayList<Exit>();
    private final List<Doc> LISTFILE = new ArrayList<Doc>();
    private final List<Stuff> LISTSTUFF = new ArrayList<Stuff>();

    public Place(String name, String text) {
        this.NAME = name;
        this.TEXT = text;
    }

    public void addExit(Exit e) {
        this.LISTEXIT.add(e);
    }

    public void addFile(Doc f) {
        this.LISTFILE.add(f);
    }

    public void printExit() {
        System.out.print("Sorties : ");
        for (Exit e : LISTEXIT) {
            System.out.print("| " + e + " |");
        }
        System.out.println();
    }

    public void printFile() {
        System.out.print("Fichiers :");
        for (Doc d : LISTFILE) {
            System.out.print("| " + d + " |");
        }
        System.out.println();
    }

    public void printStuff() {
        System.out.print("Objets : ");
        for (Stuff s : LISTSTUFF) {
            System.out.print("| " + s + " |");
        }
        System.out.println();
    }

    public void printPlace() {
        // System.out.println(this.TEXT); => redondant
        System.out.println(
                "En y regardant de plus près, vous voyez tous les noms des sorties, des fichiers et des objets de la pièce : ");
        this.printExit();
        if (!this.LISTFILE.isEmpty())
            this.printFile();
        if (!this.LISTSTUFF.isEmpty())
            this.printStuff();
    }
    public void addStuff(Stuff s) {
        this.LISTSTUFF.add(s);
    }

    public void supprStuff(Stuff s) {
        this.LISTSTUFF.remove(s);
    }

    public String getName() {
        return this.NAME;
    }

    public List<Exit> getListExit() {
        return this.LISTEXIT;
    }

    public Stuff searchStuff(String name) {
        for (Stuff s : this.LISTSTUFF) {
            if (name.equalsIgnoreCase(s.toString())) // cherche l'objet de nom
                                                     // passé en param
                return s;
        }
        System.out.println("Objet non valide !");
        return null;
    }

    public Doc searchFile(String name) {
        for (Doc d : this.LISTFILE) {
            if (name.equalsIgnoreCase(d.NAME))
                return d;
        }
        System.out.println("Pas de fichier de ce nom ici !");
        return null;
    }
}
