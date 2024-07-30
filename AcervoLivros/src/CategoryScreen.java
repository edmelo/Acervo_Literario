import javax.swing.*;
import java.awt.*;

class CategoryScreen extends JFrame {
    public CategoryScreen() {
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

        // Implement the rest of the category screen
        backButton.addActionListener(e -> dispose());
    }
}