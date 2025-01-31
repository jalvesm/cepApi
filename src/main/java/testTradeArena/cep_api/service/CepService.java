package testTradeArena.cep_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import testTradeArena.cep_api.model.Endereco;

@Service
public class CepService {

    private static final String VIA_CEP_URL = "https://viacep.com.br/ws/{cep}/json";
    private final RestTemplate restTemplate;

    public CepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Endereco getEnderecoByCep(String cep) {
        return restTemplate.getForObject(VIA_CEP_URL, Endereco.class, cep);
    }
}