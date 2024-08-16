package interfaces;

import java.awt.EventQueue;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.LivroModelo;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class LivrosLista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final LivroControlador livroControlador = new LivroControlador();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LivrosLista frame = new LivrosLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LivrosLista() {
		List<LivroModelo> livros = new ArrayList<>();
		try {
			livros = livroControlador.buscarTodosOsLivros();
		} catch (ExcecaoControlador e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao buscar os livros.", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
		}

		DefaultListModel<LivroModelo> modeloJList = new DefaultListModel<>();
		for (LivroModelo livro : livros) {
			modeloJList.addElement(livro);
		}

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); // Configurar a tela para não ser redimensionável
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 164, 232, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Visualizar Livros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(40, 0, 15, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JList<LivroModelo> listaLivros = new JList<>(modeloJList);
		listaLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		JScrollPane scrollPane = new JScrollPane(listaLivros);
		scrollPane.setPreferredSize(new Dimension(600, 400)); // Diminuir o tamanho horizontal do campo da lista
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2; // Centralizar a lista no meio da tela
		gbc_scrollPane.insets = new Insets(0, 0, 20, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		JButton btnVisualizarLivro = new JButton("Visualizar Livro");
		btnVisualizarLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVisualizarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivroModelo livroClicado = listaLivros.getSelectedValue();
				try {
					LivroEdicao enviar = new LivroEdicao();
					enviar.enviarValores(livroClicado);
					enviar.setVisible(true);
					dispose();
				} catch (ExcecaoControlador ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnVisualizarLivro = new GridBagConstraints();
		gbc_btnVisualizarLivro.insets = new Insets(0, 0, 20, 5);
		gbc_btnVisualizarLivro.gridx = 1;
		gbc_btnVisualizarLivro.gridy = 2;
		contentPane.add(btnVisualizarLivro, gbc_btnVisualizarLivro);

		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 20, 0);
		gbc_btnVoltar.gridx = 2;
		gbc_btnVoltar.gridy = 2;
		contentPane.add(btnVoltar, gbc_btnVoltar);
	}
}