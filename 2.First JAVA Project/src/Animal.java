public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, String nickname) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(String name, String nickname) {
        this.name = name;
    }

    // a.equals(b)
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Animal animal)) return false;

        return getName().equals(animal.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
