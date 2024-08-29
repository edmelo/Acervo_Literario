package interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dados.ConexaoDados;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MenuPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static ConexaoDados metodoDeDados = new ConexaoDados();
    MenuPrincipal frameMenuPrincipal;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // Cria e exibe a tela principal da aplicação
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frameMenuPrincipal = new MenuPrincipal();
                    frameMenuPrincipal.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        // Define o tamanho da tela para ocupar toda a tela do usuário
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Desativa o botão de maximizar
        setResizable(false);

        // Cria o painel de conteúdo
        contentPane = new JPanel();
        contentPane.setFocusable(true);

        // Mapeia a tecla de atalho Ctrl+L para a ação "inserirDados"
//        InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
//        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK), "inserirDados");

//        ActionMap actionMap = contentPane.getActionMap();
//        actionMap.put("inserirDados", new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                metodoDeDados.inserirDadosNoSistema();
//            }
//        });

        // Define a cor de fundo do painel de conteúdo

        contentPane.setForeground(new Color(0, 0, 0));
        contentPane.setBackground(new Color(39, 164, 232, 208));
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{275, 224, 226, 57, 0};
        gbl_contentPane.rowHeights = new int[]{59, 30, 36, 36, 36, 36, 36, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);

        // Adiciona o título "MENU" ao painel de conteúdo
        JLabel tituloMenu = new JLabel("MENU");
        tituloMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
        GridBagConstraints gbc_tituloMenu = new GridBagConstraints();
        gbc_tituloMenu.insets = new Insets(35, 0, 5, 5);
        gbc_tituloMenu.gridx = 1;
        gbc_tituloMenu.gridy = 0;
        contentPane.add(tituloMenu, gbc_tituloMenu);

        // Adiciona o botão "Sair" ao painel de conteúdo
        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Tahoma", Font.BOLD, 15));
        botaoSair.setForeground(new Color(255, 0, 0));
        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaInicial().setVisible(true);
            }
        });
        GridBagConstraints gbc_botaoSair = new GridBagConstraints();
        gbc_botaoSair.anchor = GridBagConstraints.NORTHWEST;
        gbc_botaoSair.insets = new Insets(20, 0, 5, 10);
        gbc_botaoSair.gridx = 2;
        gbc_botaoSair.gridy = 0;
        contentPane.add(botaoSair, gbc_botaoSair);

        // Adiciona o botão "Controle de Exemplares" ao painel de conteúdo
        JButton botaoLivroExemplares = new JButton("Controle de Exemplares");
        botaoLivroExemplares.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoLivroExemplares.setPreferredSize(new Dimension(300, 50));
        botaoLivroExemplares.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ControleAcervo().setVisible(true);
            }
        });

        // Adiciona o botão "Realizar Empréstimo" ao painel de conteúdo
        JButton botaoRealizarEmprestimo = new JButton("Realizar Empréstimo");
        botaoRealizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoRealizarEmprestimo.setPreferredSize(new Dimension(300, 50));
        botaoRealizarEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EmprestarLivro().setVisible(true);
            }
        });

        // Adiciona o botão "Visualizar Leitor" ao painel de conteúdo
        JButton btnNewButton = new JButton("Visualizar Leitor");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setPreferredSize(new Dimension(300, 50));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisualizarAmigo().setVisible(true);
            }
        });

        // Adiciona o botão "Cadastrar Amigo Leitor" ao painel de conteúdo
        JButton botaoCadastrarLeitor = new JButton("Cadastrar Amigo Leitor");
        botaoCadastrarLeitor.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoCadastrarLeitor.setPreferredSize(new Dimension(300, 50));
        botaoCadastrarLeitor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CadastrarAmigo().setVisible(true);
            }
        });

        // Adiciona o botão "Cadastrar Livro" ao painel de conteúdo
        JButton botaoCadastrarLivro = new JButton("Cadastrar Livro");
        botaoCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoCadastrarLivro.setPreferredSize(new Dimension(300, 50));
        botaoCadastrarLivro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CadastrarLivro().setVisible(true);
            }
        });

        // Adiciona o botão "Visualizar Livros" ao painel de conteúdo
        JButton botaoTodosOsLivros = new JButton("Visualizar Livros");
        botaoTodosOsLivros.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoTodosOsLivros.setPreferredSize(new Dimension(300, 50));
        botaoTodosOsLivros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LivrosLista().setVisible(true);
            }
        });

        // Adiciona o botão "Visualizar Livros" ao painel de conteúdo
        GridBagConstraints gbc_botaoTodosOsLivros = new GridBagConstraints();
        gbc_botaoTodosOsLivros.weightx = 1.0;
        // gbc_botaoTodosOsLivros.fill = GridBagConstraints.BOTH;
        gbc_botaoTodosOsLivros.insets = new Insets(0, 0, 20, 5);
        gbc_botaoTodosOsLivros.gridx = 1;
        gbc_botaoTodosOsLivros.gridy = 2;
        contentPane.add(botaoTodosOsLivros, gbc_botaoTodosOsLivros);

        // Adiciona o botão "Cadastrar Livro" ao painel de conteúdo
        GridBagConstraints gbc_botaoCadastrarLivro = new GridBagConstraints();
        //gbc_botaoCadastrarLivro.fill = GridBagConstraints.BOTH;
        gbc_botaoCadastrarLivro.insets = new Insets(0, 0, 20, 5);
        gbc_botaoCadastrarLivro.gridx = 1;
        gbc_botaoCadastrarLivro.gridy = 3;
        contentPane.add(botaoCadastrarLivro, gbc_botaoCadastrarLivro);

        // Adiciona o botão "Cadastrar Amigo Leitor" ao painel de conteúdo
        GridBagConstraints gbc_botaoCadastrarLeitor = new GridBagConstraints();
        //gbc_botaoCadastrarLeitor.fill = GridBagConstraints.BOTH;
        gbc_botaoCadastrarLeitor.insets = new Insets(0, 0, 20, 5);
        gbc_botaoCadastrarLeitor.gridx = 1;
        gbc_botaoCadastrarLeitor.gridy = 4;
        contentPane.add(botaoCadastrarLeitor, gbc_botaoCadastrarLeitor);

        //add botao visualizar leitor
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        //gbc_btnNewButton.fill = GridBagConstraints.BOTH;
        gbc_btnNewButton.insets = new Insets(0, 0, 20, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 5;
        contentPane.add(btnNewButton, gbc_btnNewButton);

        // Adiciona o botão "Realizar Empréstimo" ao painel de conteúdo
        GridBagConstraints gbc_botaoRealizarEmprestimo = new GridBagConstraints();
        //gbc_botaoRealizarEmprestimo.fill = GridBagConstraints.BOTH;
        gbc_botaoRealizarEmprestimo.insets = new Insets(0, 0, 20, 5);
        gbc_botaoRealizarEmprestimo.gridx = 1;
        gbc_botaoRealizarEmprestimo.gridy = 6;
        contentPane.add(botaoRealizarEmprestimo, gbc_botaoRealizarEmprestimo);

        // Adiciona o botão "Controle de Exemplares" ao painel de conteúdo
        GridBagConstraints gbc_botaoLivroExemplares = new GridBagConstraints();
        //gbc_botaoLivroExemplares.fill = GridBagConstraints.BOTH;
        gbc_botaoLivroExemplares.insets = new Insets(0, 0, 20, 5);
        gbc_botaoLivroExemplares.gridx = 1;
        gbc_botaoLivroExemplares.gridy = 7;
        contentPane.add(botaoLivroExemplares, gbc_botaoLivroExemplares);

        // Adiciona o botão "Visualizar Empréstimos" ao painel de conteúdo
        JButton botaoVisualizarEmprestimo = new JButton("Visualizar Empréstimos");
        botaoVisualizarEmprestimo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisualizarEmprestimos().setVisible(true);
            }
        });

        botaoVisualizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoVisualizarEmprestimo.setPreferredSize(new Dimension(300, 50));
        GridBagConstraints gbc_botaoVisualizarEmprestimo = new GridBagConstraints();
       // gbc_botaoVisualizarEmprestimo.fill = GridBagConstraints.HORIZONTAL;
        gbc_botaoVisualizarEmprestimo.insets = new Insets(0, 0, 0, 5);
        gbc_botaoVisualizarEmprestimo.gridx = 1;
        gbc_botaoVisualizarEmprestimo.gridy = 8;
        contentPane.add(botaoVisualizarEmprestimo, gbc_botaoVisualizarEmprestimo);
    }
}