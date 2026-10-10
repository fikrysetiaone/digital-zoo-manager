// Mammal.java
// Subclass dari Animal.

public class Mammal extends Animal {

    // Field khusus untuk Mammal.
    private String furColor;

    // Constructor Mammal.
    public Mammal(String name, int age, String furColor) {

        // super() digunakan untuk memanggil constructor dari Animal.
        super(name, age);

        // Mengisi field khusus Mammal.
        this.furColor = furColor;
    }

    // Getter untuk furColor.
    public String getFurColor() {
        return furColor;
    }

    // Setter untuk furColor.
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    // Override method makeSound() dari Animal.
    @Override
    public String makeSound() {
        return "The mammal makes a sound.";
    }

    // Override getInfo() dari Animal.
    // Informasi Mammal ditambahkan dengan fur color.
    @Override
    public String getInfo() {
        return "Name: " + getName()
                + ", Age: " + getAge()
                + ", Fur Color: " + furColor;
    }
}