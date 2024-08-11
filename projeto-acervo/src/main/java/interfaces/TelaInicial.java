package interfaces;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controladores.EmprestimoControlador;
import dados.ConexaoDados;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ConexaoDados execucaoScript = new ConexaoDados();
	private static EmprestimoControlador emprestimo = new EmprestimoControlador();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					execucaoScript.criarBancoDados();
					emprestimo.verificarEmprestimosIncial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 232, 182, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblBemVindo = new JLabel("<html><div style='text-align: center;'>"
				+ "Bem Vindo!<br><br>"
				+ "Este é um projeto de um cadastro de acervo literário pessoal.<br>"
				+ "Este projeto compõe a nota da disciplina de LPOO 2024.2 do IFPE-Paulista.<br>"
				+ "Orientado pelo professor Bruno Cartaxo.<br><br>"
				+ "CODIFICADO PELOS ALUNOS:<br>"
				+ "Ednaldo Batista de Melo<br>"
				+ "Hudson Pessoa dos Santos<br>"
				+ "Arthur arruda teixeira<br>"
				+ "Felipe da Silva Ribeiro<br>"
				+ "André Luiz José Sales<br>"
				+ "Robert Alan Dos Santos França<br>"
				+ "Erick Bruno vera cruz carneiro<br>"
				+ "Thuanny Helen de Souza França<br>"
				+ "</div></html>");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.insets = new Insets(0, 0, 5, 0);
		gbc_lblBemVindo.gridx = 1;
		gbc_lblBemVindo.gridy = 1;
		contentPane.add(lblBemVindo, gbc_lblBemVindo);

		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnIniciar = new GridBagConstraints();
		gbc_btnIniciar.insets = new Insets(0, 0, 5, 0);
		gbc_btnIniciar.gridx = 1;
		gbc_btnIniciar.gridy = 2;
		contentPane.add(btnIniciar, gbc_btnIniciar);
	}
}