package br.com.zup.investimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimento")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public RespostaDTO realizarSimulacao(@RequestBody SimulacaoDTO simulacaoDTO) {
        RespostaDTO respostaDTO = simulacaoService.simularInvestimento(simulacaoDTO.getValorInvestido(),
                simulacaoDTO.getMeses(), simulacaoDTO.getRisco());
        return respostaDTO;
    }

    @GetMapping
    public List<RespostaDTO> exibirRespostas() {
        return simulacaoService.retornarSimulacoes();
    }
}
