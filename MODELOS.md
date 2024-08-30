### `EmprestimoModelo.java`

**Descrição:**
- Representa um empréstimo de um livro.

**Detalhes do Código:**
- **Atributos:**
    - `devolvido`: Indica se o livro foi devolvido.
    - `diasAtraso`: Dias de atraso na devolução.
    - `id`: Identificador do empréstimo.
    - `isbn`: ISBN do livro emprestado.
    - `cpf`: CPF do leitor que fez o empréstimo.
    - `dataAtual`: Data atual.
    - `dataEmprestimo`: Data em que o empréstimo foi realizado.
    - `dataAviso`: Data para avisar o leitor sobre a devolução.
    - `dataDevolucao`: Data prevista para devolução.
    - `padraoHora`: Formato de data.

- **Métodos:**
    - Construtores para inicializar o empréstimo.
    - Getters e setters para os atributos.
    - `setDataAgora`: Atualiza `dataAtual` para a data atual.
    - `setDataAvisarLeitor`: Define `dataAviso` para 3 dias antes da `dataDevolucao`.
    - `duracaoDiasAtraso`: Calcula os dias de atraso na devolução.
    - `toString`: Retorna uma representação textual do empréstimo.

**Relação com Outras Classes:**
- Utilizado por `VisualizarEmprestimos` para exibir detalhes dos empréstimos.
- Interage com `LeitorModelo` e `LivroModelo` para obter informações do leitor e do livro.

### `LeitorModelo.java`

**Descrição:**
- Representa um leitor que pode realizar empréstimos.

**Detalhes do Código:**
- **Atributos:**
    - `nome`: Nome do leitor.
    - `cpf`: CPF do leitor.
    - `email`: Email do leitor.
    - `emprestimosAtivos`: Número de empréstimos ativos do leitor.

- **Métodos:**
    - Construtores para inicializar o leitor.
    - Getters e setters para os atributos.
    - Métodos para adicionar e remover empréstimos ativos (`adicionarEmprestimo` e `removerEmprestimo`).

**Relação com Outras Classes:**
- Utilizado por `VisualizarAmigo` para exibir e editar dados dos leitores.
- Interage com `EmprestimoModelo` para gerenciar os empréstimos do leitor.

### `LivroModelo.java`

**Descrição:**
- Representa um livro disponível para empréstimo.

**Detalhes do Código:**
- **Atributos:**
    - `isbn`: ISBN do livro.
    - `titulo`: Título do livro.
    - `autor`: Autor do livro.
    - `editora`: Editora do livro.
    - `dataPublicacao`: Data de publicação do livro.
    - `descricao`: Descrição do livro.
    - `img`: Imagem da capa do livro.
    - `controleExemplar`: Controle de exemplares do livro.
    - `disponivel`: Número de exemplares disponíveis.
    - `emprestado`: Número de exemplares emprestados.
    - `total`: Total de exemplares (disponíveis + emprestados).

- **Métodos:**
    - Construtores para inicializar o livro.
    - Getters e setters para os atributos.
    - Métodos para adicionar e remover exemplares disponíveis e emprestados (`setAdicionarDisponivel`, `setRemoverDisponivel`, `setAdicionarEmprestado`, `setRemoverEmprestado`).
    - `setValorTotal`: Atualiza o total de exemplares.
    - `toString`: Retorna o título do livro.

**Relação com Outras Classes:**
- Utilizado por `VisualizarEmprestimos` para exibir detalhes dos livros emprestados.
- Interage com `EmprestimoModelo` para gerenciar os empréstimos dos livros.