package rv;

public class Paper extends Stuff {

    public Paper(String n, String d) {
        super(n, d);
    }

    @Override
    public void use(Hero h) {
        System.out.println("Vous ne pouvez pas utiliser cet objet.");
    }

}
