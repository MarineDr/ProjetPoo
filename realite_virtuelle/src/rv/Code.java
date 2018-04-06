package rv;

public class Code extends Stuff {
    private boolean crypted = true;

    public Code(String n, String d) {
        super(n, d);
    }

    @Override
    public String getDescription() {
        if (crypted)
            return "Vous ne voyez sur ce bout de papier que des pixels vous empêchant d'en lire le contenu.";
        else
            return super.getDescription();
    }

    @Override
    public void use(Hero h) {
        if (this.crypted)
            System.out
                    .println("Vous ne pouvez pas encore utiliser cet objet ! ");
        else
            System.out.println(super.toString());
    }

    public void decrypt() {
        this.crypted = false;
        System.out.println(super.toString() + " décrypté avec succès !");
    }

}
