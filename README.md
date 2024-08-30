# Projeto da disciplina de LPOO de Analise e Desenvolvimento de Sistema do IFPe - Paulista

# Acervo_Literario
Aplicação Desktop em Java para acervo literário pessoal

### Descrição Geral do Projeto

#### Estrutura do Projeto
O projeto é uma aplicação desktop em Java para gerenciar um acervo literário pessoal. A estrutura do projeto é organizada da seguinte forma:

- `src/main/java`: Contém o código-fonte principal.
    - `interfaces`: Contém as classes de interface gráfica.
    - `dados`: Contém as classes relacionadas ao acesso e manipulação de dados.
- `src/main/resources`: Contém recursos como arquivos SQL.
- `src/test/java`: Contém os testes unitários.

#### Classes Principais

1. **`ConexaoDados`** (`dados.ConexaoDados`)
    - Responsável por gerenciar a conexão com o banco de dados MySQL.
    - Métodos principais:
        - `getConnection()`: Estabelece a conexão com o banco de dados.
        - `criarBancoDados()`: Cria o banco de dados e as tabelas necessárias.
        - `inserirDadosNoSistema()`: Insere dados iniciais no banco de dados.

2. **`LivroEdicao`** (`interfaces.LivroEdicao`)
    - Classe de interface gráfica para edição de informações de livros.
    - Utiliza `GridBagLayout` para organizar os componentes na interface.

3. **`TelaInicial`** (`interfaces.TelaInicial`)
    - Classe principal que inicializa a aplicação.
    - Definida como a classe principal no `pom.xml`.

#### Funcionamento
- **Banco de Dados**: A classe `ConexaoDados` gerencia a criação e conexão com o banco de dados MySQL. Scripts SQL são utilizados para criar a estrutura do banco e inserir dados iniciais.
- **Interface Gráfica**: As classes em `interfaces` gerenciam a interface gráfica da aplicação, permitindo ao usuário interagir com o acervo literário.
- **Execução**: A aplicação é empacotada como um JAR executável, com todas as dependências incluídas, utilizando plugins do Maven.
- **API do Google Books**: O sistema utiliza a API do Google Books para buscar informações adicionais sobre os livros cadastrados.

#### Dependências
O projeto utiliza Maven para gerenciar suas dependências, que incluem:

- **JSON Manipulation**:
    - `org.json:json`
    - `com.google.code.gson:gson`
- **Banco de Dados**:
    - `mysql:mysql-connector-java`
- **Testes**:
    - `junit:junit`
    - `org.junit.jupiter:junit-jupiter-engine`
    - `org.mockito:mockito-core`
    - `org.mockito:mockito-junit-jupiter`
- **Email**:
    - `org.apache.commons:commons-email`
    - `javax.mail:javax.mail-api`
    - `com.sun.mail:jakarta.mail`
- **HTTP Client**:
    - `org.apache.httpcomponents:httpclient`
- **Google Books API**:
    - `com.google.apis:google-api-services-books`

### Execução da Aplicação
Para executar a aplicação, siga os passos abaixo:

1. **Clone o repositório**:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    cd <NOME_DO_REPOSITORIO>
    ```

2. **Configure o banco de dados**:
    - Certifique-se de que o MySQL está instalado e em execução.
    - Atualize as configurações de conexão com o banco de dados no arquivo `src/main/resources/database.properties`.

3. **Compile e empacote a aplicação**:
    ```sh
    mvn clean package
    ```

4. **Execute o JAR gerado**:
    ```sh
    java -jar target/Acervo_Literario-1.0-SNAPSHOT.jar
    ```

5. **Utilize a aplicação**:
    - A interface gráfica será exibida, permitindo a interação com o acervo literário pessoal.

### Conclusão
O projeto é uma aplicação desktop em Java para gerenciar um acervo literário, utilizando MySQL para armazenamento de dados e Maven para gerenciamento de dependências. A interface gráfica é construída com `Swing` e organizada com `GridBagLayout`. O sistema também integra a API do Google Books para enriquecer as informações dos livros cadastrados.

<h2>Autor</h2>
| [<img src="https://avatars.githubusercontent.com/u/10143322?v=4" width="115"><br><sub>Ednaldo B Melo</sub>](https://github.com/edmelo) |
| :---: |
