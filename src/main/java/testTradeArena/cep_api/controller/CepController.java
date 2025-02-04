package testTradeArena.cep_api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testTradeArena.cep_api.model.Endereco;
import testTradeArena.cep_api.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cep")
public class CepController {
    private final int CEP_LENGTH = 8;
    private static final String CEP_REGEX = "\\d+";
    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        validateCepFormat(cep);
        validateCepLength(cep);

        return cepService.getEnderecoByCep(cep);
    }

    private void validateCepFormat(String cep) {
        if (!cep.matches(CEP_REGEX)) {
            throw new IllegalArgumentException("CEP inválido! Informe apenas números, sem traços ou letras.");
        }
    }

    private void validateCepLength(String cep) {
        if (cep.length() != CEP_LENGTH) {
            throw new IllegalArgumentException("CEP inválido! Você deve informar exatamente 8 números.");
        }
    }
}
