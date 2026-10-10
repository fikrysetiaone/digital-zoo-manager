// Animal.java
// Superclass / parent class untuk semua jenis hewan.

public class Animal {

    // Private field sesuai requirement soal.
    private String name;
    private int age;

    // Constructor
    // Digunakan untuk memberikan nilai awal name dan age.
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter untuk name
    public String getName() {
        return name;
    }

    // Setter untuk name
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk age
    public int getAge() {
        return age;
    }

    // Setter untuk age
    public void setAge(int age) {
        this.age = age;
    }

    // Method yang nantinya akan di-override oleh subclass.
    public String makeSound() {
        return "The animal makes a sound.";
    }

    // Mengembalikan informasi dasar animal.
    public String getInfo() {
        return "Name: " + name + ", Age: " + age;
    }
}