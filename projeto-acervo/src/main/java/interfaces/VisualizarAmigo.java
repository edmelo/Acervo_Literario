package interfaces;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import modelos.LeitorModelo;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarAmigo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEmprestimosAtivos;

	/* O método main desta classe é responsável por iniciar a aplicação,
    instanciando um objeto da classe VisualizarAmigo e tornando-o visível. */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarAmigo frame = new VisualizarAmigo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* Cria a janela de visualização de um amigo. */
	public VisualizarAmigo() {
		final LeitorControlador controlador = new LeitorControlador();
		final JButton btnEditarDados = new JButton("Editar dados");
		final JButton btnAtualizarDados = new JButton("Atualizar dados");

		// Configura o frame para ajustar ao tamanho da tela do usuário e impedir redimensionamento
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);

		// Configura o painel de conteúdo com uma cor de fundo e borda
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 164, 232, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Usa GridBagLayout para gerenciamento flexível do layout
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 395, 97, 0};
		gbl_contentPane.rowHeights = new int[]{44, 88, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		// Adiciona um rótulo de título
		JLabel lblNewLabel_1 = new JLabel("VISUALIZAR AMIGO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(30, 50, 60, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Adiciona um botão "Voltar" para retornar ao menu principal
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.anchor = GridBagConstraints.EAST;
		gbc_btnVoltar.insets = new Insets(30, 0, 60, 5);
		gbc_btnVoltar.gridx = 2;
		gbc_btnVoltar.gridy = 0;
		contentPane.add(btnVoltar, gbc_btnVoltar);

		// Adiciona um rótulo e campo de texto para entrada de CPF
		JLabel lblCpf = new JLabel("Digite o CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 50, 10, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 1;
		contentPane.add(lblCpf, gbc_lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtCpf.setColumns(10);
		GridBagConstraints gbc_textCpf = new GridBagConstraints();
		gbc_textCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCpf.insets = new Insets(0, 0, 10, 50);
		gbc_textCpf.gridx = 1;
		gbc_textCpf.gridy = 1;
		contentPane.add(txtCpf, gbc_textCpf);

		// Adiciona um botão "Buscar Amigo" para buscar um leitor pelo CPF
		JButton btnBuscarLeitor = new JButton("Buscar Amigo");
		btnBuscarLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpf = txtCpf.getText();
				try {
					LeitorModelo leitor = controlador.buscarLeitorPorCpf(cpf);
					txtNome.setText(leitor.getNome());
					txtEmail.setText(leitor.getEmail());
					txtEmprestimosAtivos.setText("" + leitor.getEmprestimo());
					btnEditarDados.setEnabled(true);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		btnBuscarLeitor.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnBuscarLeitor = new GridBagConstraints();
		gbc_btnBuscarLeitor.anchor = GridBagConstraints.EAST;
		gbc_btnBuscarLeitor.insets = new Insets(0, 0, 10, 5);
		gbc_btnBuscarLeitor.gridx = 2;
		gbc_btnBuscarLeitor.gridy = 1;
		contentPane.add(btnBuscarLeitor, gbc_btnBuscarLeitor);

		// Adiciona um rótulo e campo de texto para o nome do leitor
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		contentPane.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 10, 50);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		contentPane.add(txtNome, gbc_txtNome);

		// Adiciona um rótulo e campo de texto para o e-mail do leitor
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		contentPane.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 10, 50);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		contentPane.add(txtEmail, gbc_txtEmail);

		// Adiciona um rótulo e campo de texto para o número de empréstimos ativos
		JLabel lblEmprestimos = new JLabel("Empréstimos ativos:");
		lblEmprestimos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmprestimos = new GridBagConstraints();
		gbc_lblEmprestimos.anchor = GridBagConstraints.EAST;
		gbc_lblEmprestimos.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmprestimos.gridx = 0;
		gbc_lblEmprestimos.gridy = 4;
		contentPane.add(lblEmprestimos, gbc_lblEmprestimos);

		txtEmprestimosAtivos = new JTextField();
		txtEmprestimosAtivos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEmprestimosAtivos.setEditable(false);
		txtEmprestimosAtivos.setColumns(10);
		GridBagConstraints gbc_txtEmprestimosAtivos = new GridBagConstraints();
		gbc_txtEmprestimosAtivos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmprestimosAtivos.insets = new Insets(0, 0, 10, 50);
		gbc_txtEmprestimosAtivos.gridx = 1;
		gbc_txtEmprestimosAtivos.gridy = 4;
		contentPane.add(txtEmprestimosAtivos, gbc_txtEmprestimosAtivos);

		// Adiciona um botão "Editar dados" para habilitar a edição dos dados do leitor
		btnEditarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditarDados.setEnabled(false);
		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setEditable(true);
				txtEmail.setEditable(true);
				btnAtualizarDados.setEnabled(true);
			}
		});
		GridBagConstraints gbc_btnEditarDados = new GridBagConstraints();
		gbc_btnEditarDados.anchor = GridBagConstraints.EAST;
		gbc_btnEditarDados.insets = new Insets(0, 0, 10, 5);
		gbc_btnEditarDados.gridx = 0;
		gbc_btnEditarDados.gridy = 6;
		contentPane.add(btnEditarDados, gbc_btnEditarDados);

		// Adiciona um botão "Atualizar dados" para salvar os dados atualizados do leitor
		btnAtualizarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizarDados.setEnabled(false);
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				try {
					LeitorModelo leitor = controlador.buscarLeitorPorCpf(cpf);
					if (!email.trim().isEmpty()) {
						controlador.atualizarEmailLeitor(leitor, email);
					}
					if (!nome.trim().isEmpty()) {
						controlador.atualizarNomeLeitor(leitor, nome);
					}
					JOptionPane.showMessageDialog(null, "Dados do leitor atualizados com sucesso", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnAtualizarDados = new GridBagConstraints();
		gbc_btnAtualizarDados.insets = new Insets(0, 0, 10, 5);
		gbc_btnAtualizarDados.anchor = GridBagConstraints.EAST;
		gbc_btnAtualizarDados.gridx = 2;
		gbc_btnAtualizarDados.gridy = 6;
		contentPane.add(btnAtualizarDados, gbc_btnAtualizarDados);
	}
}