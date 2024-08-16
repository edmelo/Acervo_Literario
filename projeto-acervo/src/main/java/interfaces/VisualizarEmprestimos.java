package interfaces;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import controladores.LivroControlador;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class VisualizarEmprestimos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EmprestimoControlador emprestimoControlador = new EmprestimoControlador();
	private LivroControlador livroControlador = new LivroControlador();
	private LeitorControlador leitorControlador = new LeitorControlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEmprestimos frame = new VisualizarEmprestimos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizarEmprestimos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to adjust to the user's screen size
		setResizable(false); // Prevent the frame from being resized
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 164, 232, 208)); // Set the background color
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		List<EmprestimoModelo> emprestimos = new ArrayList<>();
		try {
			emprestimos = emprestimoControlador.buscarTodosEmprestimos();
		} catch (ExcecaoControlador e) {
			e.printStackTrace();
		}

		DefaultListModel<EmprestimoModelo> modeloJList = new DefaultListModel<>();
		for (EmprestimoModelo emprestimo : emprestimos) {
			modeloJList.addElement(emprestimo);
		}

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 395, 97, 0};
		gbl_contentPane.rowHeights = new int[]{44, 88, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("VISUALIZAR EMPRÉSTIMOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(30, 50, 60, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(30, 0, 60, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JList<EmprestimoModelo> jList = new JList<>(modeloJList);
		JScrollPane scrollPane = new JScrollPane(jList);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 15, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		JButton btnNewButton = new JButton("VISUALIZAR EMPRÉSTIMO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoModelo emprestimoClicado = jList.getSelectedValue();

				try {
					LivroModelo livro = livroControlador.buscarLivroPorIsbn(emprestimoClicado.getIsbn());
					LeitorModelo leitor = leitorControlador.buscarLeitorPorCpf(emprestimoClicado.getCpf());
					Emprestado enviar = new Emprestado();
					enviar.enviarValores(emprestimoClicado, livro, leitor);
					enviar.setVisible(true);
					dispose();
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
}