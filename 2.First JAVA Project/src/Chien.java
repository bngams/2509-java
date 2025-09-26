public class Chien extends Animal {

    // Aggrégation  (getters / setter....)
    private Niche niche;

    // Composition (créer et utilisé en interne uniquement, pas de getter/ setter ..)
    private Tatouage tattoo;

    public Chien(String name) {
        super(name);
        this.tattoo = new Tatouage(this.getName());
    }

    public String getTattooValue() {
        return this.tattoo.getName();
    }

    public void aboyer() {

    }

    public void jouer(Os os) {
        //...
    }

}
