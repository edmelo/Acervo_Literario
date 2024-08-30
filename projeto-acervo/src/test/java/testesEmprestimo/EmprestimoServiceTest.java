package testesEmprestimo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import controladores.AplicacaoEmail;
import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import controladores.LivroControlador;
import dados.EmprestimoDados;
import dados.ExcecaoDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

@ExtendWith(MockitoExtension.class)
public class EmprestimoServiceTest {
    @Mock
    LeitorModelo leitor;

    @Mock
    LivroModelo livro;

    @Mock
    private LivroDados livroDados;

    @Mock
    private LeitorControlador leitorControlador;

    @Mock
    private LivroControlador livroControlador;

    @Mock
    private EmprestimoDados dadosEmprestimo;

    @Mock
    private LeitorDados leitorDados;

    @Mock
    private AplicacaoEmail emailControlador;

    @InjectMocks
    private EmprestimoControlador emprestimoControlador;


    @Test
    public void BuscarEmprestimoComSucesso(@Mock EmprestimoDados dadosEmprestimoMock) throws ExcecaoDados, ExcecaoControlador {
        EmprestimoModelo emprestimo = new EmprestimoModelo("11111111111", "0000000000");
        emprestimoControlador.setDados(dadosEmprestimoMock);


        when(dadosEmprestimoMock.buscarEmprestimo("11111111111", "0000000000")).thenReturn(emprestimo);
        emprestimoControlador.buscarEmprestimo("11111111111", "0000000000");

    }


}
