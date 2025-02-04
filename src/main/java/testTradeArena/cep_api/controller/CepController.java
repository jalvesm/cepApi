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

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        if (!cep.matches("\\d+")) {
            throw new IllegalArgumentException("CEP inválido! Informe apenas números, sem traços ou letras.");
        }

        if (cep.length() != 8) {
            throw new IllegalArgumentException("CEP inválido! Você deve informar exatamente 8 números.");
        }

        return cepService.getEnderecoByCep(cep);
    }
}
