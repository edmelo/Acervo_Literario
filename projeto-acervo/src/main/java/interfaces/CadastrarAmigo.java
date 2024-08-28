package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;

public class CadastrarAmigo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;

	// Main method to launch the application
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAmigo frameCadastrarAmigo = new CadastrarAmigo();
					frameCadastrarAmigo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Constructor to set up the frame
	public CadastrarAmigo() {
		// Set default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set the frame to fill the entire screen
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// Disable resizing
		setResizable(false);

		// Create the content pane and set its background color and border
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 164, 232, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Set the layout for the content pane
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);

		// Create a panel to hold the form elements
		JPanel panel = new JPanel();
		panel.setBackground(new Color(39, 164, 232, 208));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);

		// Set the layout for the panel
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{162, 393, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		// Add the title label
		JLabel lblTitulo = new JLabel("CADASTRAR AMIGO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(30, 50, 60, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);

		// Add the "Voltar" button
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_botaoVoltar = new GridBagConstraints();
		gbc_botaoVoltar.insets = new Insets(30, 0, 60, 5);
		gbc_botaoVoltar.gridx = 2;
		gbc_botaoVoltar.gridy = 0;
		panel.add(botaoVoltar, gbc_botaoVoltar);

		// Add the "Nome" label and text field
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 50, 10, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		panel.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 10, 50);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		// Add the "Email" label and text field
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 50, 10, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		panel.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 10, 50);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		panel.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		// Add the "CPF" label and text field
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.EAST;
		gbc_lblCPF.insets = new Insets(0, 50, 10, 5);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 4;
		panel.add(lblCPF, gbc_lblCPF);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.insets = new Insets(0, 0, 10, 50);
		gbc_txtCpf.gridx = 1;
		gbc_txtCpf.gridy = 4;
		panel.add(txtCpf, gbc_txtCpf);
		txtCpf.setColumns(10);

		// Add the "Cadastrar" button
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String cpf = txtCpf.getText();

				LeitorControlador controlador = new LeitorControlador();

				try {
					controlador.cadastrarLeitor(nome, cpf, email);
					JOptionPane.showMessageDialog(null, "O leitor foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
					//Update the list of friends in VisualizarAmigo
					VisualizarAmigo visualizarAmigo = new VisualizarAmigo();
					visualizarAmigo.atualizarListaAmigos();
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridwidth = 2;
		gbc_btnCadastrar.insets = new Insets(20, 50, 60, 5);
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 5;
		panel.add(btnCadastrar, gbc_btnCadastrar);
	}
}
