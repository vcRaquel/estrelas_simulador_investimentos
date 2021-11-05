package br.com.zup.investimentos.controller;

import br.com.zup.investimentos.dto.RespostaDTO;
import br.com.zup.investimentos.dto.SimulacaoDTO;
import br.com.zup.investimentos.service.SimulacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
