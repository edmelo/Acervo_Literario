### `ExcecaoDados.java`
Esta classe define uma exceção personalizada que estende a classe `Exception`. Ela é usada para lançar exceções específicas relacionadas a operações de dados no sistema.

### `InterfaceEmprestimoDados.java`
Esta interface define os métodos que devem ser implementados para manipular dados de empréstimos. Os métodos incluem:
- `realizarEmprestimo(EmprestimoModelo emprestimo)`: Realiza um empréstimo.
- `verificarEmprestimo(String cpf, String isbn)`: Verifica se um empréstimo existe.
- `buscarEmprestimo(String cpf, String isbn)`: Busca um empréstimo específico.
- `verificarDevolucao(EmprestimoModelo emprestimo)`: Verifica se um empréstimo foi devolvido.
- `buscarTodosEmprestimos()`: Busca todos os empréstimos não devolvidos.
- `fazerDevolucao(EmprestimoModelo emprestimo)`: Marca um empréstimo como devolvido.
- `verificarAtraso(EmprestimoModelo emprestimo)`: Verifica se há atraso em um empréstimo.
- `atualizarAtraso(EmprestimoModelo emprestimo)`: Atualiza os dias de atraso de um empréstimo.

### `InterfaceLeitorDados.java`
Esta interface define os métodos para manipular dados de leitores. Os métodos incluem:
- `cadastrarLeitor(LeitorModelo leitor)`: Cadastra um novo leitor.
- `atualizarNomeLeitor(LeitorModelo leitor)`: Atualiza o nome de um leitor.
- `atualizarEmailLeitor(LeitorModelo leitor)`: Atualiza o email de um leitor.
- `verificarLeitor(String cpf)`: Verifica se um leitor existe.
- `buscarLeitorPorCpf(String cpf)`: Busca um leitor pelo CPF.
- `adicionarEmprestimo(LeitorModelo leitor)`: Adiciona um empréstimo ao leitor.
- `removerEmprestimo(LeitorModelo leitor)`: Remove um empréstimo do leitor.
- `deletarLeitorPorCpf(String cpf)`: Deleta um leitor pelo CPF.
- `buscarTodosLeitores()`: Busca todos os leitores.

### `InterfaceLivroDados.java`
Esta interface define os métodos para manipular dados de livros. Os métodos incluem:
- `cadastrarLivro(LivroModelo livro)`: Cadastra um novo livro.
- `verificarLivro(String isbn)`: Verifica se um livro existe.
- `acrescentarExemplarLivro(LivroModelo livro, int exemplarASomar)`: Acrescenta exemplares de um livro.
- `deletarExemplarLivro(LivroModelo livro, int exemplarASubtrair)`: Deleta exemplares de um livro.
- `buscarQuantidadeLivros(String isbn)`: Busca a quantidade de exemplares de um livro.
- `buscarTodosOsLivros()`: Busca todos os livros.
- `buscarLivroPorIsbn(String isbn)`: Busca um livro pelo ISBN.
- `buscarLivroPorTitulo(String titulo)`: Busca um livro pelo título.
- `buscarLivroPorAutor(String autor)`: Busca livros por autor.
- `buscarLivroPorTituloModelo(String titulo)`: Busca um livro pelo título (modelo).
- `modificarExemplarFazerEmprestimo(LivroModelo livro)`: Modifica os exemplares ao fazer um empréstimo.
- `modificarExemplarFinalizarEmprestimo(LivroModelo livro)`: Modifica os exemplares ao finalizar um empréstimo.

### `LeitorDados.java`
Esta classe implementa a interface `InterfaceLeitorDados` e define a lógica para manipular dados de leitores. Ela usa JDBC para interagir com o banco de dados. Métodos incluem:
- `cadastrarLeitor(LeitorModelo leitor)`: Insere um novo leitor no banco de dados.
- `atualizarNomeLeitor(LeitorModelo leitor)`: Atualiza o nome de um leitor no banco de dados.
- `atualizarEmailLeitor(LeitorModelo leitor)`: Atualiza o email de um leitor no banco de dados.
- `verificarLeitor(String cpf)`: Verifica se um leitor existe no banco de dados.
- `buscarLeitorPorCpf(String cpf)`: Busca um leitor pelo CPF no banco de dados.
- `adicionarEmprestimo(LeitorModelo leitor)`: Adiciona um empréstimo ao leitor no banco de dados.
- `removerEmprestimo(LeitorModelo leitor)`: Remove um empréstimo do leitor no banco de dados.
- `deletarLeitorPorCpf(String cpf)`: Deleta um leitor pelo CPF no banco de dados.
- `buscarTodosLeitores()`: Busca todos os leitores no banco de dados.

### `LivroDados.java`
Esta classe implementa a interface `InterfaceLivroDados` e define a lógica para manipular dados de livros. Ela usa JDBC para interagir com o banco de dados. Métodos incluem:
- `cadastrarLivro(LivroModelo livro)`: Insere um novo livro no banco de dados.
- `verificarLivro(String isbn)`: Verifica se um livro existe no banco de dados.
- `atualizarLivro(LivroModelo livro)`: Atualiza as informações de um livro no banco de dados.
- `deletarExemplarLivro(LivroModelo livro, int exemplarASubtrair)`: Deleta exemplares de um livro no banco de dados.
- `acrescentarExemplarLivro(LivroModelo livro, int exemplarASomar)`: Acrescenta exemplares de um livro no banco de dados.
- `buscarQuantidadeLivros(String isbn)`: Busca a quantidade de exemplares de um livro no banco de dados.
- `buscarTodosOsLivros()`: Busca todos os livros no banco de dados.
- `buscarLivroPorIsbn(String isbn)`: Busca um livro pelo ISBN no banco de dados.
- `buscarLivroPorTitulo(String titulo)`: Busca um livro pelo título no banco de dados.
- `buscarLivroPorAutor(String autor)`: Busca livros por autor no banco de dados.
- `buscarLivroPorTituloModelo(String titulo)`: Busca um livro pelo título (modelo) no banco de dados.
- `modificarExemplarFazerEmprestimo(LivroModelo livro)`: Modifica os exemplares ao fazer um empréstimo no banco de dados.
- `modificarExemplarFinalizarEmprestimo(LivroModelo livro)`: Modifica os exemplares ao finalizar um empréstimo no banco de dados.

### Relações com Outras Classes
- **Modelos**: As classes de dados (`LeitorDados`, `LivroDados`, `EmprestimoDados`) interagem com classes de modelo (`LeitorModelo`, `LivroModelo`, `EmprestimoModelo`) para manipular os dados.
- **Conexão com Banco de Dados**: Todas as classes de dados utilizam a classe `ConexaoDados` para obter uma conexão com o banco de dados.
- **Exceções**: As classes de dados lançam a exceção `ExcecaoDados` para tratar erros específicos de operações de dados.