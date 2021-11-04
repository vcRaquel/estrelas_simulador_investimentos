package br.com.zup.investimentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investimento")
public class SimulacaoController {
    @Autowired
    private SimulacaoService simulacaoDoInvestimentoService;

    //@PostMapping

    //@GetMapping
    // public RespostaDTO realizarSimulacao(@RequestBody SimulacaoDTO simulacaoDTO){
    //return simulacaoService.calcularESalvarSimulacao(simulacaoDTO)
    //}
    //new RespostaDTO(23, 344, 54)
}
