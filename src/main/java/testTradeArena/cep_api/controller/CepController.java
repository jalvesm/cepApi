package testTradeArena.cep_api.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testTradeArena.cep_api.model.Endereco;
import testTradeArena.cep_api.service.CepService;
import testTradeArena.cep_api.utils.Utils;
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
        Utils.validateCepFormat(cep);
        Utils.validateCepLength(cep);

        return cepService.getEnderecoByCep(cep);
    }
}