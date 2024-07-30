import javax.swing.*;
import java.awt.*;

class AddBooksScreen extends JFrame {
    public AddBooksScreen() {
        setTitle("BASE DE DADOS");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton backButton = new JButton("Voltar");
        topPanel.add(backButton);
        JLabel titleLabel = new JLabel("BASE DE DADOS");
        topPanel.add(titleLabel);
        add(topPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton booksButton = new JButton("LIVROS");
        JButton categoryButton = new JButton("CATEGORIA");
        buttonPanel.add(booksButton);
        buttonPanel.add(categoryButton);
        add(buttonPanel, BorderLayout.CENTER);

        // Add action listeners for buttons
        backButton.addActionListener(e -> dispose());
        booksButton.addActionListener(e -> showBooksForm());
        categoryButton.addActionListener(e -> new CategoryScreen().setVisible(true));
    }

    private void showBooksForm() {
        // Implement the form for adding books
    }
}