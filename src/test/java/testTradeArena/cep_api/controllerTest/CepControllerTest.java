package testTradeArena.cep_api.controllerTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testTradeArena.cep_api.controller.CepController;
import testTradeArena.cep_api.model.Endereco;
import testTradeArena.cep_api.service.CepService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CepControllerTest {

    @Mock
    private CepService cepService;

    @InjectMocks
    private CepController cepController;

    @Test
    void getEndereco_ValidCep_ReturnsEndereco() {
        String cep = "01001000";
        Endereco endereco = new Endereco();
        endereco.setCep(cep);

        when(cepService.getEnderecoByCep(cep)).thenReturn(endereco);

        Endereco result = cepController.getEndereco(cep);
        assertEquals(cep, result.getCep());
    }
}