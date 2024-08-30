### `Constantes.java`
Esta classe define constantes usadas em todo o sistema. As constantes são:
- `PASTA_APP`: Nome da pasta principal da aplicação.
- `PASTA_LIVROS`: Nome da pasta onde os livros são armazenados.

### `EmprestimoControlador.java`
Esta classe gerencia as operações relacionadas aos empréstimos de livros. Suas principais responsabilidades incluem:
- **realizarEmprestimo**: Verifica se o livro e o leitor existem, se o leitor não excedeu o limite de empréstimos e se o livro está disponível. Se todas as condições forem atendidas, realiza o empréstimo e envia um e-mail de confirmação.
- **fazerDevolucao**: Verifica se o empréstimo existe, atualiza o status do empréstimo para devolvido, ajusta os contadores de empréstimos do leitor e do livro, e envia um e-mail de confirmação de devolução.
- **buscarEmprestimo**: Busca um empréstimo específico pelo CPF do leitor e ISBN do livro.
- **atraso**: Verifica se o empréstimo está atrasado e, se estiver, envia um e-mail de notificação.
- **atualizarAtraso**: Atualiza o número de dias de atraso de um empréstimo.
- **enviarEmailAviso**: Envia um e-mail de aviso quando o empréstimo está próximo do fim.
- **verificarEmprestimosIncial**: Verifica todos os empréstimos no início do sistema para enviar avisos e notificações de atraso.

### `ExcecaoControlador.java`
Esta classe define uma exceção personalizada para o controlador. É usada para encapsular mensagens de erro e a causa original da exceção.

### `LeitorControlador.java`
Esta classe gerencia as operações relacionadas aos leitores. Suas principais responsabilidades incluem:
- **cadastrarLeitor**: Valida os dados do leitor e o cadastra no sistema. Envia um e-mail de confirmação de cadastro.
- **buscarLeitorPorCpf**: Busca um leitor pelo CPF.
- **atualizarNomeLeitor**: Atualiza o nome do leitor.
- **atualizarEmailLeitor**: Atualiza o e-mail do leitor e envia um e-mail de confirmação da atualização.
- **buscarTodosLeitores**: Busca todos os leitores cadastrados no sistema.

### `LivroControlador.java`
Esta classe gerencia as operações relacionadas aos livros. Suas principais responsabilidades incluem:
- **cadastrarLivroPorISBN**: Busca informações do livro por ISBN de uma API externa e cadastra o livro no sistema.
- **cadastrarLivro**: Cadastra um livro com informações fornecidas manualmente.
- **AdicionarExemplares**: Adiciona exemplares de um livro existente.
- **ExcluirExemplares**: Exclui exemplares de um livro existente.
- **buscarTodosOsLivros**: Busca todos os livros cadastrados no sistema.
- **buscarLivroPorIsbn**: Busca um livro pelo ISBN.
- **buscarLivroPorTitulo**: Busca um livro pelo título.
- **buscarLivroApi**: Busca informações de um livro por ISBN de uma API externa.

### Relações entre as classes
- **EmprestimoControlador** interage com **LeitorControlador** e **LivroControlador** para buscar informações sobre leitores e livros.
- **EmprestimoControlador** e **LeitorControlador** utilizam **AplicacaoEmail** para enviar e-mails de notificação.
- **ExcecaoControlador** é usada em todas as classes para tratar exceções específicas do controlador.
- **Constantes** é usada em **LivroControlador** para definir caminhos de pastas.

### Diagrama de Relações
```plaintext
+-------------------+       +-------------------+
| EmprestimoControlador |<----->| LeitorControlador |
+-------------------+       +-------------------+
        |                          |
        |                          |
        v                          v
+-------------------+       +-------------------+
| LivroControlador  |<----->| AplicacaoEmail    |
+-------------------+       +-------------------+
        |
        v
+-------------------+
| Constantes        |
+-------------------+
```

Este diagrama mostra as interações principais entre as classes do pacote `controladores`.