public class Client {
    public static void main(String[] args) {
        Chien c = new Chien("Medor");
        Animal a = c;
        // a.aboyer() // pas possible car on se base sur la classe animal
        c.aboyer();
    }
}
