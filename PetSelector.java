import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PetSelector extends JFrame implements ActionListener {
    private JRadioButton dogButton, catButton, birdButton, pigButton, rabbitButton;
    private JLabel resultLabel, imageLabel;
    private ButtonGroup petGroup;

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Create radio buttons
        dogButton = new JRadioButton("Dog");
        catButton = new JRadioButton("Cat");
        birdButton = new JRadioButton("Bird");
        pigButton = new JRadioButton("Pig");
        rabbitButton = new JRadioButton("Rabbit");

        // Create button group and add radio buttons
        petGroup = new ButtonGroup();
        petGroup.add(dogButton);
        petGroup.add(catButton);
        petGroup.add(birdButton);
        petGroup.add(rabbitButton);
        petGroup.add(pigButton);

        // Add action listeners
        dogButton.addActionListener(this);
        catButton.addActionListener(this);
        birdButton.addActionListener(this);
        pigButton.addActionListener(this);
        rabbitButton.addActionListener(this);

        // Add buttons to the button panel
        buttonPanel.add(dogButton);
        buttonPanel.add(catButton);
        buttonPanel.add(birdButton);
        buttonPanel.add(pigButton);
        buttonPanel.add(rabbitButton);

        // Create result label and image label
        resultLabel = new JLabel("Select a pet");
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(300, 300));

        // Create a panel for the result label and image label
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.add(resultLabel);
        displayPanel.add(imageLabel);

        // Add components to frame
        add(buttonPanel, BorderLayout.WEST);
        add(displayPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String petName = "";
        String imagePath = "";

        if (e.getSource() == dogButton) {
            petName = "Dog";
            imagePath = "dog.jpg";
        } else if (e.getSource() == catButton) {
            petName = "Cat";
            imagePath = "cat.jpg";
        } else if (e.getSource() == birdButton) {
            petName = "Bird";
            imagePath = "bird.jpg";
        } else if (e.getSource() == pigButton) {
            petName = "Pig";
            imagePath = "pig.jpg";
        } else if (e.getSource() == rabbitButton) {
            petName = "Rabbit";
            imagePath = "rabbit.jpg";
        }

        resultLabel.setText("You selected a " + petName);

        // Load and display the image
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetSelector();
            }
        });
    }
}