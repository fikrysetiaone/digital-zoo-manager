// Bird.java
// Subclass dari Animal.

public class Bird extends Animal {

    // Field khusus untuk Bird.
    private boolean canFly;

    // Constructor Bird.
    public Bird(String name, int age, boolean canFly) {

        // Memanggil constructor dari parent class Animal.
        super(name, age);

        // Mengisi field khusus Bird.
        this.canFly = canFly;
    }

    // Getter untuk canFly.
    public boolean isCanFly() {
        return canFly;
    }

    // Setter untuk canFly.
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    // Override method makeSound() dari Animal.
    @Override
    public String makeSound() {
        return "The bird chirps.";
    }

    // Override getInfo() dari Animal.
    @Override
    public String getInfo() {
        return "Name: " + getName()
                + ", Age: " + getAge()
                + ", Can Fly: " + (canFly ? "Yes" : "No");
    }
}