package testesLeitor;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import controladores.AplicacaoEmail;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import dados.ExcecaoDados;
import dados.InterfaceLeitorDados;
import modelos.LeitorModelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

public class LeitorControladorTest {

    @Mock
    private InterfaceLeitorDados dados;

    @Mock
    private AplicacaoEmail emailControlador;

    @InjectMocks
    private LeitorControlador leitorControlador;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarLeitorComEmailInvalido() {
        String nome = "Adonai Silva";
        String cpf = "12345678901";
        String email = "adonai.silva@example.com";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            leitorControlador.cadastrarLeitor(nome, cpf, email);
        });

        assertEquals("O campo Email não pode ter espaço em branco", exception.getMessage());
    }

    @Test
    public void testCadastrarLeitorComCpfInvalido() {
        String nome = "Adonai Silva";
        String cpf = "12345678901";
        String email = "adonai.silva@example.com";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            leitorControlador.cadastrarLeitor(nome, cpf, email);
        });

        assertEquals("O campo CPF não pode ter espaço em branco", exception.getMessage());
    }

    @Test
    public void testBuscarLeitorNaoExistentePorCpf() throws ExcecaoDados {
        String cpf = "12345678901";

        when(dados.verificarLeitor(cpf)).thenReturn(false);

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            leitorControlador.buscarLeitorPorCpf(cpf);
        });

        assertEquals("Leitor não encontrado", exception.getMessage());
    }

    @Test
    public void testPreencherOCampoDeCpfIncorretamenteNoCadastro() throws ExcecaoDados {
        String cpf = "aaaaaaaaaaa";

        when(dados.verificarLeitor(cpf)).thenReturn(false);

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            leitorControlador.buscarLeitorPorCpf(cpf);
        });

        assertEquals("CPF inválido", exception.getMessage());
    }

    @Test
    public void testBuscarLeitorPorCpfComCpfVazio() {
        String cpf = "";

        Exception exception = assertThrows(ExcecaoControlador.class, () -> {
            leitorControlador.buscarLeitorPorCpf(cpf);
        });

        assertEquals("O campo CPF é obrigatório.", exception.getMessage());
    }

}
