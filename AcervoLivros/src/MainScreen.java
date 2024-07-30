import javax.swing.*;
import java.awt.*;

class MainScreen extends JFrame {
    public MainScreen() {
        setTitle("Acervo Literário");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JLabel titleLabel = new JLabel("Acervo Literário", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(titleLabel, gbc);

        JButton addBooksButton = new JButton("ADD LIVROS");
        JButton acervoButton = new JButton("ACERVO");
        JButton emprestarButton = new JButton("EMPRESTAR");

        gbc.gridy = 1;
        add(addBooksButton, gbc);
        gbc.gridy = 2;
        add(acervoButton, gbc);
        gbc.gridy = 3;
        add(emprestarButton, gbc);

        addBooksButton.addActionListener(e -> new AddBooksScreen().setVisible(true));
        // Add action listeners for other buttons as needed
    }
}