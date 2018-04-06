package rv;

/** Classe Doc.*/
public class Doc {

    /**Nom du document.*/
    private final String name;
    /**Texte du document.*/
    private final String texte;

    /**Constructeur.
     * @param n : nom du doc
     * @param t : texte du doc*/
    public Doc(final String n, final String t) {
        this.name = n;
        this.texte = t;
    }

    /**Ouvrir le document affiche le texte.
     * @param h : avec le héro h*/
    public void open(final Hero h) {
        System.out.println(this.texte);
    }

    /**Un Ovveride !*/
    @Override
    public String toString() {
        return this.name;
    }

}
