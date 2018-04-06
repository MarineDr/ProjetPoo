package rv;

public abstract class Stuff {
    private final String name;
    private final String description;

    public Stuff(String n, String d) {
        this.name = n;
        this.description = d;
    }

    abstract public void use(Hero h);

    @Override
    public String toString() {
        return this.name;
    }

    public void decrypt() {
    }

    public String getDescription() {
        return this.description;
    }
}
