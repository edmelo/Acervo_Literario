package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;

public class CadastrarLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtImagem;
	private JFormattedTextField txtISBN;
	private JFormattedTextField formattedtxtDataPublicacao;
	private JTextField txtDescricao;
	private JTextField txtExemplares;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frameCadastrarLivro = new CadastrarLivro();
					frameCadastrarLivro.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frameCadastrarLivro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	//O método CadastrarLivro é o construtor da classe CadastrarLivro,
	// que é responsável por criar a interface gráfica para o cadastro de um livro.
	public CadastrarLivro() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		setResizable(false); // Add this line to make the frame non-resizable
		contentPane = new JPanel();
		contentPane.setBackground(new Color(39, 164, 232, 208));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setBackground(new Color(39, 164, 232, 208));
		GridBagConstraints gbc_panelCadastro = new GridBagConstraints();
		gbc_panelCadastro.gridx = 0;
		gbc_panelCadastro.gridy = 0;
		gbc_panelCadastro.fill = GridBagConstraints.BOTH;
		gbc_panelCadastro.weightx = 1.0;
		gbc_panelCadastro.weighty = 1.0;
		contentPane.add(panelCadastro, gbc_panelCadastro);
		GridBagLayout gbl_panelCadastro = new GridBagLayout();
		gbl_panelCadastro.columnWidths = new int[]{150, 468, 0, 71, 0, 0};
		gbl_panelCadastro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCadastro.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCadastro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCadastro.setLayout(gbl_panelCadastro);

		// Add the title label
		JLabel lblTitle = new JLabel("CADASTRAR LIVRO");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 4;
		gbc_lblTitle.insets = new Insets(30, 50, 60, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelCadastro.add(lblTitle, gbc_lblTitle);

		// Add the back button
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuPrincipal().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVoltar.setAlignmentX(0.5f);
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(30, 0, 60, 5);
		gbc_btnVoltar.gridx = 4;
		gbc_btnVoltar.gridy = 0;
		panelCadastro.add(btnVoltar, gbc_btnVoltar);

		// Add the ISBN label
		JLabel lblISBN = new JLabel("* ISBN:");
		lblISBN.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblISBN = new GridBagConstraints();
		gbc_lblISBN.insets = new Insets(0, 50, 10, 5);
		gbc_lblISBN.anchor = GridBagConstraints.EAST;
		gbc_lblISBN.gridx = 0;
		gbc_lblISBN.gridy = 1;
		panelCadastro.add(lblISBN, gbc_lblISBN);

		// Add the ISBN text field
		final JFormattedTextField txtIsbn = new JFormattedTextField();
		txtIsbn.setToolTipText("Código de identificação do livro");
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
		gbc_txtIsbn.insets = new Insets(0, 0, 10, 10);
		gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIsbn.gridx = 1;
		gbc_txtIsbn.gridy = 1;
		panelCadastro.add(txtIsbn, gbc_txtIsbn);

		// Add the "Cadastrar por ISBN" button
		JButton btnCadastrarPorIsbn = new JButton("Cadastrar por ISBN");
		btnCadastrarPorIsbn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCadastrarPorIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = txtIsbn.getText();
				String exemplares = txtExemplares.getText();
				LivroControlador controlador = new LivroControlador();
				try {
					controlador.cadastrarLivroPorISBN(ISBN, exemplares);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

//		JButton btnCadastrarPorIsbn = new JButton("Cadastrar por ISBN");
//		btnCadastrarPorIsbn.setAlignmentX(Component.CENTER_ALIGNMENT);
//		btnCadastrarPorIsbn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String ISBN = txtIsbn.getText();
//				String exemplares = txtExemplares.getText();
//				LivroControlador controlador = new LivroControlador();
//				try {
//					controlador.cadastrarLivroPorISBN(ISBN, exemplares);
//				} catch (ExcecaoControlador ex) {
//					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//				} catch (Exception exc) {
//					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//			}
//		});

		// Add the "Exemplares" label and text field
		JLabel lblNewLabel = new JLabel("* Exemplares:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 10, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panelCadastro.add(lblNewLabel, gbc_lblNewLabel);

		txtExemplares = new JTextField();
		txtExemplares.setToolTipText("Digite a Quantidade de Livros");
		txtExemplares.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 10, 5);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panelCadastro.add(txtExemplares, gbc_textField);
		txtExemplares.setColumns(10);

		// Add the "Cadastrar por ISBN" button
		btnCadastrarPorIsbn.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnCadastrarPorIsbn = new GridBagConstraints();
		gbc_btnCadastrarPorIsbn.gridwidth = 4;
		gbc_btnCadastrarPorIsbn.insets = new Insets(0, 50, 5, 5);
		gbc_btnCadastrarPorIsbn.gridx = 0;
		gbc_btnCadastrarPorIsbn.gridy = 2;
		panelCadastro.add(btnCadastrarPorIsbn, gbc_btnCadastrarPorIsbn);

		// Add the "Titulo" label and text field
		JLabel lblTitulo = new JLabel("* Titulo:");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.insets = new Insets(0, 50, 10, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 3;
		panelCadastro.add(lblTitulo, gbc_lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.gridwidth = 3;
		gbc_txtTitulo.insets = new Insets(0, 0, 10, 50);
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 3;
		panelCadastro.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);

		// Add the "Autor" label and text field
		JLabel lblAutor = new JLabel("*  Autor:");
		lblAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.EAST;
		gbc_lblAutor.insets = new Insets(0, 50, 10, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 4;
		panelCadastro.add(lblAutor, gbc_lblAutor);

		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.gridwidth = 3;
		gbc_txtAutor.insets = new Insets(0, 0, 10, 50);
		gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAutor.gridx = 1;
		gbc_txtAutor.gridy = 4;
		panelCadastro.add(txtAutor, gbc_txtAutor);
		txtAutor.setColumns(10);

		// Add the "Editora" label and text field
		JLabel lblEditora = new JLabel("Editora:");
		lblEditora.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEditora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblEditora = new GridBagConstraints();
		gbc_lblEditora.anchor = GridBagConstraints.EAST;
		gbc_lblEditora.insets = new Insets(0, 50, 10, 5);
		gbc_lblEditora.gridx = 0;
		gbc_lblEditora.gridy = 5;
		panelCadastro.add(lblEditora, gbc_lblEditora);

		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtEditora = new GridBagConstraints();
		gbc_txtEditora.gridwidth = 3;
		gbc_txtEditora.insets = new Insets(0, 0, 10, 50);
		gbc_txtEditora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEditora.gridx = 1;
		gbc_txtEditora.gridy = 5;
		panelCadastro.add(txtEditora, gbc_txtEditora);
		txtEditora.setColumns(10);

		// Add the "Data de publicação" label and text field
		JLabel lbldata = new JLabel("Data de publicação:");
		lbldata.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbldata.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lbldata = new GridBagConstraints();
		gbc_lbldata.anchor = GridBagConstraints.EAST;
		gbc_lbldata.insets = new Insets(0, 50, 10, 5);
		gbc_lbldata.gridx = 0;
		gbc_lbldata.gridy = 6;
		panelCadastro.add(lbldata, gbc_lbldata);

		final JFormattedTextField formattedtxtDataPublicacao_1 = new JFormattedTextField();
		formattedtxtDataPublicacao_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_formattedtxtDataPublicacao_1 = new GridBagConstraints();
		gbc_formattedtxtDataPublicacao_1.gridwidth = 3;
		gbc_formattedtxtDataPublicacao_1.insets = new Insets(0, 0, 10, 50);
		gbc_formattedtxtDataPublicacao_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedtxtDataPublicacao_1.gridx = 1;
		gbc_formattedtxtDataPublicacao_1.gridy = 6;
		panelCadastro.add(formattedtxtDataPublicacao_1, gbc_formattedtxtDataPublicacao_1);

		// Add the "Imagem" label and text field
		JLabel lblImagem = new JLabel("Imagem Link:");
		lblImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblImagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblImagem = new GridBagConstraints();
		gbc_lblImagem.anchor = GridBagConstraints.EAST;
		gbc_lblImagem.insets = new Insets(0, 50, 10, 5);
		gbc_lblImagem.gridx = 0;
		gbc_lblImagem.gridy = 7;
		panelCadastro.add(lblImagem, gbc_lblImagem);

		txtImagem = new JTextField();
		txtImagem.setToolTipText("Digite o link da imagem do link do livro");
		txtImagem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_txtImagem = new GridBagConstraints();
		gbc_txtImagem.gridwidth = 3;
		gbc_txtImagem.insets = new Insets(0, 0, 10, 50);
		gbc_txtImagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImagem.gridx = 1;
		gbc_txtImagem.gridy = 7;
		panelCadastro.add(txtImagem, gbc_txtImagem);
		txtImagem.setColumns(10);

		// Add the "Descrição" label and text field
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.anchor = GridBagConstraints.EAST;
		gbc_lblDescricao.insets = new Insets(0, 50, 10, 5);
		gbc_lblDescricao.gridx = 0;
		gbc_lblDescricao.gridy = 8;
		panelCadastro.add(lblDescricao, gbc_lblDescricao);

		txtDescricao = new JTextField();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gbc_txtDescricao.gridwidth = 3;
		gbc_txtDescricao.insets = new Insets(0, 0, 5, 50);
		gbc_txtDescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 8;
		panelCadastro.add(txtDescricao, gbc_txtDescricao);
		txtDescricao.setColumns(10);

		// Add the "Cadastrar" button
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtIsbn.getText();
				String titulo = txtTitulo.getText();
				String autor = txtAutor.getText();
				String editora = txtEditora.getText();
				String dataPublicacao = formattedtxtDataPublicacao_1.getText();
				String imagem = txtImagem.getText();
				String descricao = txtDescricao.getText();
				String exemplares = txtExemplares.getText();

				LivroControlador controlador = new LivroControlador();

				try {
					controlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, imagem, descricao, exemplares);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JLabel lblCamposObrigatorios = new JLabel("* campos obrigatórios");
		lblCamposObrigatorios.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCamposObrigatorios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCamposObrigatorios = new GridBagConstraints();
		gbc_lblCamposObrigatorios.gridwidth = 4;
		gbc_lblCamposObrigatorios.insets = new Insets(20, 50, 5, 5);
		gbc_lblCamposObrigatorios.gridx = 0;
		gbc_lblCamposObrigatorios.gridy = 10;
		panelCadastro.add(lblCamposObrigatorios, gbc_lblCamposObrigatorios);

		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridwidth = 4;
		gbc_btnCadastrar.insets = new Insets(0, 50, 0, 5);
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 11;
		panelCadastro.add(btnCadastrar, gbc_btnCadastrar);
	}
}