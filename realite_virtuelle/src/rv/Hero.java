
package rv;

import java.util.ArrayList;
import java.util.List;

/** Class Hero. */
public class Hero {
    /** Energie max du joueur.*/
    public static final int MAX_ENERGY = 15;
    /** Nom du joueur.*/
    private final String name;
    /** Logique du joueur.*/
    private int logic;
    /** Place du joueur.*/
    private Place currentPlace;
    /** Inventaire du joueur.*/
    private List<Stuff> inventory = new ArrayList<Stuff>();
    /** Energie du joueur.*/
    private int energy;

    /** Constructeur joueur.
     * @param n : Nom du joueur
     * @param p : lieu de base du joueur */
    public Hero(final String n, final Place p) {
        this.name = n;
        this.logic = 0;
        this.currentPlace = p;
        this.energy = Hero.MAX_ENERGY;
    }

    /** retourne l'énergie du joueur.
     * @return enrgie*/
    public int getEnergy() {
        return energy;
    }

    /** retourne la logique du joueur.
     * @return logique*/
    public int getLogic() {
        return logic;
    }

    /** modifie l'énergie du joueur.
     * @param e : en passant l'énergie du joueur en parametre */
    public void setEnergy(final int e) {
        if (this.energy + e <= Hero.MAX_ENERGY) {
            this.energy += e;
        } else {
            this.energy = Hero.MAX_ENERGY;
            System.out.println("Vous avez atteint le maximum d'Ã©nergie !");
        }
    }

    /** Ajoute de la logique au joueur.
     * @param x :  montant de la logique ajouté*/
    public void addLogic(final int x) {
        this.logic += x;
    }

    /** Ajoute un objet à l'inventaire.
     * @param s : ajout l'objet s */
    public void addInventory(final Stuff s) {
        this.inventory.add(s);
        System.out.println("Objet ajoutÃ© Ã  votre inventaire ! ");
    }

    /** Change la place du joueur.
     * @param p : pour la place p*/
    public void setCurrentPlace(final Place p) {
        this.currentPlace = p;
    }

    /** retourne la place du joueur.
     * @return place du joueur*/
    public Place getCurrentPlace() {
        return this.currentPlace;
    }

    /**Affiche l'inventaire du joueur.*/
    public void printInventory() {
        System.out.print("Inventaire :");
        for (Stuff s : this.inventory) {
            System.out.print("| " + s + " |");
        }
        System.out.println();
    }

    /**Affiche les caractéristique du joueur.*/
    public void printCharac() {
        System.out.println("Nom : " + this.name);
        System.out.println("Logique : " + this.logic);
        System.out.println("Energie : " + this.energy);
        if (!this.inventory.isEmpty()) {
            this.printInventory();
        }
    }

    /** Cherche si l'objet est dans l'inventaire.
     * @param n : l'objet a chercher
     * @return l'objet si il a été trouvé*/
    public Stuff searchInventory(final String n) {
        for (Stuff s : this.inventory) {
            if (n.equalsIgnoreCase(s.toString())) { // cherche l'objet de nom
                                                     // passÃ© en param
                return s;
            }
        }
        System.out.println("Objet non valide !");
        return null;
    }

    /**Enleve un objet de l'inventaire.
     * @param s : l'objet a enlever*/
    public void removeStuff(final Stuff s) {
        this.inventory.remove(s);
    }

}
