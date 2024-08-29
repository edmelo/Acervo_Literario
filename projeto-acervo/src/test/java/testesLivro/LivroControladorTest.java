package testesLivro;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import dados.ExcecaoDados;
import dados.InterfaceLivroDados;
import modelos.LivroModelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LivroControladorTest {

    @Mock
    private InterfaceLivroDados dados;

    @InjectMocks
    private LivroControlador livroControlador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarLivro() throws ExcecaoControlador, ExcecaoDados {
        String isbn = "1234567890";
        String titulo = "Test Book";
        String autor = "Author";
        String editora = "Publisher";
        String dataPublicacao = "01/01/2020";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        doNothing().when(dados).cadastrarLivro(any(LivroModelo.class));

        livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);

        verify(dados, times(1)).cadastrarLivro(any(LivroModelo.class));
    }

    @Test
    public void testCadastrarLivroComIsbnInvalido() {
        String isbn = "12345";
        String titulo = "Test Book";
        String autor = "Author";
        String editora = "Publisher";
        String dataPublicacao = "01/01/2020";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo ISBN deve ter 10 ou 13 números.", exception.getMessage());
    }

    @Test
    public void testCadastrarLivroComTituloVazio() {
        String isbn = "1234567890";
        String titulo = "";
        String autor = "Author";
        String editora = "Publisher";
        String dataPublicacao = "01/01/2020";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo Título é obrigatório.", exception.getMessage());
    }

    @Test
    public void testCadastrarLivroComAutorVazio() {
        String isbn = "1234567890";
        String titulo = "Test Book";
        String autor = "";
        String editora = "Publisher";
        String dataPublicacao = "01/01/2020";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo Autor é obrigatório.", exception.getMessage());
    }

    @Test
    public void testCadastrarLivroComEditoraVazia() {
        String isbn = "1234567890";
        String titulo = "Test Book";
        String autor = "Author";
        String editora = "";
        String dataPublicacao = "01/01/2020";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo Editora é obrigatório.", exception.getMessage());
    }

    @Test
    public void testCadastrarLivroComDataPublicacaoVazia() {
        String isbn = "1234567890";
        String titulo = "Test Book";
        String autor = "Author";
        String editora = "Publisher";
        String dataPublicacao = "";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo Data de Publicação é obrigatório.", exception.getMessage());
    }

    @Test
    public void testCadastrarLivroComDataPublicacaoInvalida() {
        String isbn = "1234567890";
        String titulo = "Test Book";
        String autor = "Author";
        String editora = "Publisher";
        String dataPublicacao = "01/01/20";
        String img = "image.jpg";
        String descricao = "Description";
        String exemplares = "5";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            livroControlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, img, descricao, exemplares);
        });

        assertEquals("O campo Data de Publicação deve estar no formato dd/mm/aaaa.", exception.getMessage());
    }

}