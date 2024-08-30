### `LivrosLista.java`

**Descrição:**
- Esta classe representa a interface gráfica para listar todos os livros cadastrados no sistema.

**Detalhes do Código:**
- **Atributos:**
    - `contentPane`: Painel principal da interface.
    - `livroControlador`: Instância do controlador de livros para buscar dados dos livros.

- **Métodos:**
    - `main`: Método principal para iniciar a aplicação.
    - `LivrosLista`: Construtor que inicializa a interface, configura o layout e adiciona componentes.
    - **Componentes:**
        - `JLabel lblNewLabel`: Título da interface.
        - `JList<LivroModelo> listaLivros`: Lista de livros exibida na interface.
        - `JButton btnVisualizarLivro`: Botão para visualizar detalhes de um livro selecionado.
        - `JButton btnVoltar`: Botão para voltar ao menu principal.

**Relação com Outras Classes:**
- Utiliza `LivroControlador` para buscar todos os livros.
- Interage com `LivroEdicao` para editar um livro selecionado.
- Interage com `MenuPrincipal` para voltar ao menu principal.

### `MenuPrincipal.java`

**Descrição:**
- Esta classe representa a interface gráfica do menu principal da aplicação.

**Detalhes do Código:**
- **Atributos:**
    - `contentPane`: Painel principal da interface.
    - `metodoDeDados`: Instância para conexão com os dados.

- **Métodos:**
    - `main`: Método principal para iniciar a aplicação.
    - `MenuPrincipal`: Construtor que inicializa a interface, configura o layout e adiciona componentes.
    - **Componentes:**
        - `JLabel tituloMenu`: Título do menu.
        - **Botões:**
            - `botaoSair`: Sai da aplicação e volta para a tela inicial.
            - `botaoLivroExemplares`: Abre a interface de controle de exemplares.
            - `botaoRealizarEmprestimo`: Abre a interface para realizar empréstimos.
            - `btnNewButton`: Abre a interface para visualizar leitores.
            - `botaoCadastrarLeitor`: Abre a interface para cadastrar novos leitores.
            - `botaoCadastrarLivro`: Abre a interface para cadastrar novos livros.
            - `botaoTodosOsLivros`: Abre a interface para visualizar todos os livros.
            - `botaoVisualizarEmprestimo`: Abre a interface para visualizar empréstimos.

**Relação com Outras Classes:**
- Interage com várias interfaces (`TelaInicial`, `ControleAcervo`, `EmprestarLivro`, `VisualizarAmigo`, `CadastrarAmigo`, `CadastrarLivro`, `LivrosLista`, `VisualizarEmprestimos`) para navegar entre diferentes funcionalidades.

### `TelaInicial.java`

**Descrição:**
- Esta classe representa a interface gráfica inicial da aplicação.

**Detalhes do Código:**
- **Atributos:**
    - `contentPane`: Painel principal da interface.
    - `execucaoScript`: Instância para conexão com os dados.
    - `emprestimo`: Controlador de empréstimos.

- **Métodos:**
    - `main`: Método principal para iniciar a aplicação.
    - `TelaInicial`: Construtor que inicializa a interface, configura o layout e adiciona componentes.
    - **Componentes:**
        - `JLabel lblBemVindo`: Mensagem de boas-vindas.
        - `JButton btnIniciar`: Botão para iniciar a aplicação e abrir o menu principal.

**Relação com Outras Classes:**
- Utiliza `ConexaoDados` para criar o banco de dados.
- Utiliza `EmprestimoControlador` para verificar empréstimos iniciais.
- Interage com `MenuPrincipal` para navegar para o menu principal.

### `VisualizarAmigo.java`

**Descrição:**
- Esta classe representa a interface gráfica para visualizar e editar dados de amigos leitores.

**Detalhes do Código:**
- **Atributos:**
    - `contentPane`: Painel principal da interface.
    - `txtCpf`, `txtNome`, `txtEmail`, `txtEmprestimosAtivos`: Campos de texto para exibir e editar dados do leitor.
    - `listaAmigos`: Lista de amigos exibida na interface.
    - `controlador`: Controlador de leitores.

- **Métodos:**
    - `main`: Método principal para iniciar a aplicação.
    - `VisualizarAmigo`: Construtor que inicializa a interface, configura o layout e adiciona componentes.
    - **Componentes:**
        - `JLabel lblNewLabel_1`: Título da interface.
        - `JButton btnVoltar`: Botão para voltar ao menu principal.
        - `JButton btnBuscarLeitor`: Botão para buscar um leitor pelo CPF.
        - `JButton btnEditarDados`: Botão para habilitar a edição dos dados do leitor.
        - `JButton btnAtualizarDados`: Botão para atualizar os dados do leitor.
        - `JScrollPane scrollPane`: Painel de rolagem para a lista de amigos.

**Relação com Outras Classes:**
- Utiliza `LeitorControlador` para buscar e atualizar dados dos leitores.
- Interage com `MenuPrincipal` para voltar ao menu principal.

### `VisualizarEmprestimos.java`

**Descrição:**
- Esta classe representa a interface gráfica para visualizar todos os empréstimos.

**Detalhes do Código:**
- **Atributos:**
    - `contentPane`: Painel principal da interface.
    - `emprestimoControlador`, `livroControlador`, `leitorControlador`: Controladores para buscar dados de empréstimos, livros e leitores.

- **Métodos:**
    - `main`: Método principal para iniciar a aplicação.
    - `VisualizarEmprestimos`: Construtor que inicializa a interface, configura o layout e adiciona componentes.
    - **Componentes:**
        - `JLabel lblNewLabel`: Título da interface.
        - `JButton btnNewButton_1`: Botão para voltar ao menu principal.
        - `JList<EmprestimoModelo> jList`: Lista de empréstimos exibida na interface.
        - `JScrollPane scrollPane`: Painel de rolagem para a lista de empréstimos.
        - `JButton btnNewButton`: Botão para visualizar detalhes de um empréstimo selecionado.

**Relação com Outras Classes:**
- Utiliza `EmprestimoControlador` para buscar todos os empréstimos.
- Utiliza `LivroControlador` e `LeitorControlador` para buscar detalhes de livros e leitores relacionados aos empréstimos.
- Interage com `MenuPrincipal` para voltar ao menu principal.
- Interage com `Emprestado` para visualizar detalhes de um empréstimo selecionado.