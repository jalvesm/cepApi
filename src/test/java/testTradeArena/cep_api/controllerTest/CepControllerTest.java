package testTradeArena.cep_api.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testTradeArena.cep_api.controller.CepController;
import testTradeArena.cep_api.model.Endereco;
import testTradeArena.cep_api.service.CepService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CepControllerTest {

    @Mock
    private CepService cepService;

    @InjectMocks
    private CepController cepController;

    private Endereco enderecoMock;

    @BeforeEach
    void setUp() {
        enderecoMock = new Endereco();
        enderecoMock.setCep("01001000");
        enderecoMock.setLogradouro("Praça da Sé");
        enderecoMock.setBairro("Sé");
        enderecoMock.setLocalidade("São Paulo");
        enderecoMock.setUf("SP");
    }

    @Test
    void getEndereco_WithValidCep_ShouldReturnEndereco() {

        String cep = "01001000";
        when(cepService.getEnderecoByCep(cep)).thenReturn(enderecoMock);

        Endereco resultado = cepController.getEndereco(cep);

        assertNotNull(resultado);
        assertEquals("01001000", resultado.getCep());
        assertEquals("Praça da Sé", resultado.getLogradouro());
        verify(cepService, times(1)).getEnderecoByCep(cep);
    }

    @Test
    void getEndereco_CepWithLetters_ShouldThrowIllegalArgumentException() {

        String cepInvalido = "ABC12345";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> cepController.getEndereco(cepInvalido));

        assertEquals("CEP inválido! Informe apenas números, sem traços ou letras.", exception.getMessage());
        verify(cepService, never()).getEnderecoByCep(anyString());
    }

    @Test
    void testGetEndereco_WithCepSmallerThan8Characters_ShouldThrowIllegalArgumentException() {
        String shortCep = "12345";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> cepController.getEndereco(shortCep));

        assertEquals("CEP inválido! Você deve informar exatamente 8 números.", exception.getMessage());
        verify(cepService, never()).getEnderecoByCep(anyString());
    }
}
