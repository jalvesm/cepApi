package testTradeArena.cep_api.serviceTest;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.web.client.RestTemplate;
import testTradeArena.cep_api.model.Endereco;
import testTradeArena.cep_api.service.CepService;

class CepServiceTest {

    @Mock
    private RestTemplate restTemplate;

    private CepService cepService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cepService = new CepService(restTemplate);
    }

    @Test
    void getEnderecoByCep_ReturnsNullWhenCepNotFound() {

        String cep = "99999999";
        when(restTemplate.getForObject(anyString(), eq(Endereco.class), eq(cep))).thenReturn(null);

        Endereco actualEndereco = cepService.getEnderecoByCep(cep);

        assertNull(actualEndereco);
    }

    @Test
    void getEnderecoByCep_ShouldThrowRuntimeException_WhenApiCallFails() {
        String cep = "01001000";
        when(restTemplate.getForObject(anyString(), eq(Endereco.class), eq(cep))).thenThrow(new RuntimeException("API error"));

        assertThrows(RuntimeException.class, () -> cepService.getEnderecoByCep(cep));
    }
}
