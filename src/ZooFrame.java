// ZooFrame.java

// Import ArrayList untuk menyimpan kumpulan Animal.
import java.util.ArrayList;

// Import komponen GUI dari Swing.
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Import layout manager.
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ZooFrame extends JFrame {

    // =========================================================
    // ARRAYLIST
    // =========================================================

    // ArrayList menggunakan tipe Animal.
    //
    // Ini merupakan contoh POLYMORPHISM karena ArrayList Animal
    // dapat menyimpan object Mammal maupun Bird.
    private ArrayList<Animal> animals = new ArrayList<>();


    // =========================================================
    // GUI COMPONENTS
    // =========================================================

    // Text field untuk nama animal.
    private JTextField nameField;

    // Text field untuk umur animal.
    private JTextField ageField;

    // ComboBox untuk memilih jenis animal.
    private JComboBox<String> typeComboBox;

    // Text field untuk warna bulu Mammal.
    private JTextField furColorField;

    // Checkbox untuk menentukan apakah Bird dapat terbang.
    private JCheckBox canFlyCheckBox;

    // Tombol Add Animal.
    private JButton addButton;

    // Text area untuk menampilkan log.
    private JTextArea logArea;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public ZooFrame() {

        // Judul window.
        setTitle("Digital Zoo Manager");

        // Ukuran window.
        setSize(650, 500);

        // Ketika tombol X ditekan, program akan berhenti.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat window berada di tengah layar.
        setLocationRelativeTo(null);

        // Membuat GUI.
        createGUI();
    }


    // =========================================================
    // CREATE GUI
    // =========================================================

    private void createGUI() {

        // Menggunakan GridBagLayout agar komponen dapat
        // disusun dengan lebih rapi.
        setLayout(new GridBagLayout());

        // GridBagConstraints digunakan untuk mengatur
        // posisi setiap komponen.
        GridBagConstraints gbc = new GridBagConstraints();

        // Jarak antar komponen.
        gbc.insets = new Insets(5, 5, 5, 5);

        // Supaya komponen memenuhi area yang tersedia.
        gbc.fill = GridBagConstraints.HORIZONTAL;


        // =====================================================
        // NAME
        // =====================================================

        JLabel nameLabel = new JLabel("Name:");

        nameField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;

        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;

        add(nameField, gbc);


        // =====================================================
        // AGE
        // =====================================================

        JLabel ageLabel = new JLabel("Age:");

        ageField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(ageLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        add(ageField, gbc);


        // =====================================================
        // ANIMAL TYPE
        // =====================================================

        JLabel typeLabel = new JLabel("Animal Type:");

        // Pilihan jenis animal.
        String[] animalTypes = {
                "Generic Mammal",
                "Generic Bird"
        };

        typeComboBox = new JComboBox<>(animalTypes);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(typeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;

        add(typeComboBox, gbc);


        // =====================================================
        // FUR COLOR
        // =====================================================

        JLabel furColorLabel = new JLabel("Fur Color:");

        furColorField = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(furColorLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;

        add(furColorField, gbc);


        // =====================================================
        // CAN FLY
        // =====================================================

        JLabel canFlyLabel = new JLabel("Can Fly:");

        canFlyCheckBox = new JCheckBox("Yes");

        gbc.gridx = 0;
        gbc.gridy = 4;

        add(canFlyLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;

        add(canFlyCheckBox, gbc);


        // =====================================================
        // ADD BUTTON
        // =====================================================

        addButton = new JButton("Add Animal");

        gbc.gridx = 1;
        gbc.gridy = 5;

        add(addButton, gbc);


        // =====================================================
        // LOG AREA
        // =====================================================

        JLabel logLabel = new JLabel("Zoo Log:");

        gbc.gridx = 0;
        gbc.gridy = 6;

        add(logLabel, gbc);


        // JTextArea digunakan untuk menampilkan
        // informasi animal yang telah ditambahkan.
        logArea = new JTextArea(12, 40);

        // User tidak dapat mengedit log.
        logArea.setEditable(false);

        // JScrollPane membuat log dapat di-scroll.
        JScrollPane scrollPane = new JScrollPane(logArea);

        // Membuat scroll pane mengambil dua kolom.
        gbc.gridx = 0;
        gbc.gridy = 7;

        gbc.gridwidth = 2;

        // Agar scroll pane memenuhi area yang tersedia.
        gbc.fill = GridBagConstraints.BOTH;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        add(scrollPane, gbc);


        // =====================================================
        // BUTTON ACTION
        // =====================================================

        // Ketika tombol Add Animal diklik,
        // method addAnimal() akan dijalankan.
        addButton.addActionListener(e -> addAnimal());
    }


    // =========================================================
    // ADD ANIMAL
    // =========================================================

    private void addAnimal() {

        // Mengambil data dari Name TextField.
        String name = nameField.getText().trim();

        // Mengambil data dari Age TextField.
        String ageText = ageField.getText().trim();

        // Validasi agar nama tidak kosong.
        if (name.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Name cannot be empty."
            );

            return;
        }

        // Validasi agar age tidak kosong.
        if (ageText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age cannot be empty."
            );

            return;
        }


        // =====================================================
        // CONVERT AGE
        // =====================================================

        int age;

        try {

            // Mengubah String menjadi int.
            age = Integer.parseInt(ageText);

        } catch (NumberFormatException e) {

            // Jika user memasukkan bukan angka.
            JOptionPane.showMessageDialog(
                    this,
                    "Age must be a number."
            );

            return;
        }


        // Validasi umur.
        if (age < 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "Age cannot be negative."
            );

            return;
        }


        // =====================================================
        // GET ANIMAL TYPE
        // =====================================================

        // Mengambil pilihan dari ComboBox.
        String selectedType =
                (String) typeComboBox.getSelectedItem();


        // Variable Animal.
        //
        // Kita menggunakan tipe Animal karena nantinya
        // variable ini dapat menyimpan Mammal atau Bird.
        Animal animal;


        // =====================================================
        // CREATE MAMMAL
        // =====================================================

        if (selectedType.equals("Generic Mammal")) {

            // Mengambil Fur Color.
            String furColor =
                    furColorField.getText().trim();

            // Validasi Fur Color.
            if (furColor.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Fur Color cannot be empty."
                );

                return;
            }

            // Membuat object Mammal.
            animal = new Mammal(
                    name,
                    age,
                    furColor
            );


            // =====================================================
            // CREATE BIRD
            // =====================================================

        } else {

            // Mengambil nilai dari checkbox.
            boolean canFly =
                    canFlyCheckBox.isSelected();

            // Membuat object Bird.
            animal = new Bird(
                    name,
                    age,
                    canFly
            );
        }


        // =====================================================
        // ADD TO ARRAYLIST
        // =====================================================

        // Object Mammal/Bird dimasukkan ke ArrayList Animal.
        //
        // Inilah salah satu contoh polymorphism.
        animals.add(animal);


        // =====================================================
        // DISPLAY LOG
        // =====================================================

        // Menampilkan informasi animal.
        logArea.append(
                "Added a new "
                        + selectedType
                        + "!\n"
        );

        logArea.append(
                "Info: "
                        + animal.getInfo()
                        + "\n"
        );

        // Memanggil makeSound().
        logArea.append(
                "Sound: "
                        + animal.makeSound()
                        + "\n"
        );

        logArea.append(
                "----------------------------------------\n"
        );


        // =====================================================
        // CLEAR FORM
        // =====================================================

        // Mengosongkan input setelah animal ditambahkan.
        nameField.setText("");

        ageField.setText("");

        furColorField.setText("");

        canFlyCheckBox.setSelected(false);

        // Cursor kembali ke Name field.
        nameField.requestFocus();
    }


    // =========================================================
    // MAIN METHOD
    // =========================================================

    public static void main(String[] args) {

        // SwingUtilities.invokeLater digunakan agar GUI
        // dijalankan pada Event Dispatch Thread.
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Membuat object ZooFrame.
            ZooFrame frame = new ZooFrame();

            // Menampilkan window.
            frame.setVisible(true);
        });
    }
}