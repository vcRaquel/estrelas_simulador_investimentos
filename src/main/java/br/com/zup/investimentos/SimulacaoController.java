package br.com.zup.investimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/investimento")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoService;

    @PutMapping
    public RespostaDTO realizarSimulacao(@Valid @RequestBody SimulacaoDTO simulacaoDTO) {
        RespostaDTO respostaDTO = simulacaoService.simularInvestimento(simulacaoDTO);
        return respostaDTO;
    }

//    @GetMapping
//    public List<RespostaDTO> exibirRespostas() {
//        return simulacaoService.retornarSimulacoes();
//    }
}
