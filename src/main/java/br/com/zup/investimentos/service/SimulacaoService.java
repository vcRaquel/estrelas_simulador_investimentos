package br.com.zup.investimentos.service;

import br.com.zup.investimentos.TipodeRisco;
import br.com.zup.investimentos.dto.RespostaDTO;
import br.com.zup.investimentos.dto.SimulacaoDTO;
import br.com.zup.investimentos.exceptionPersonalizada.ValorBaixoParaTipoDeRiscoException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulacaoService {
    List<SimulacaoDTO> simulacoes = new ArrayList<>();


    // adicionar investimento
    public void adicionarSimulacaoALista(SimulacaoDTO simulacaoDTO){
        simulacoes.add(simulacaoDTO);
    }

    public List<SimulacaoDTO> retornarSimulacoes(){
        return simulacoes;
    }

    public double calcularMultiplicadorDeCapital(SimulacaoDTO simulacaoDTO){
        //TipodeRisco tipoDeRisco, int quantidadeMeses
       double multiplicadorDeCapital =
               Math.pow((1 + simulacaoDTO.getRisco().getTaxaDeRetorno()), simulacaoDTO.getPeriodoDeAplicacaoMeses());
       return multiplicadorDeCapital;
   }

    public double calcularMontante(SimulacaoDTO simulacaoDTO){
        //double valorInvestido, int quantidadeMeses, TipodeRisco tipodeRisco
        double montante = simulacaoDTO.getValorInvestido() * calcularMultiplicadorDeCapital(simulacaoDTO);
        return montante;
    }

    public double calcularLucro(SimulacaoDTO simulacaoDTO  ){
        //*double valorInvestido, int quantidadedeMeses, TipodeRisco tipodeRisco *
        double montante = calcularMontante(simulacaoDTO);
        double lucro = montante - simulacaoDTO.getValorInvestido();
        return lucro;
    }

    public RespostaDTO simularInvestimento(SimulacaoDTO simulacaoDTO){
        if (simulacaoDTO.getValorInvestido() < 5000 && simulacaoDTO.getRisco().equals(TipodeRisco.ALTO)){
            throw new ValorBaixoParaTipoDeRiscoException("R$ 5000 é o valor mínimo para investimento de Alto risco");
        }

        double valorTotalDoLucro = calcularLucro(simulacaoDTO);
        double valorTotal = calcularMontante(simulacaoDTO);

        RespostaDTO respostaDTO = new RespostaDTO(simulacaoDTO.getValorInvestido(), valorTotalDoLucro, valorTotal);
        adicionarSimulacaoALista(simulacaoDTO);
        return respostaDTO;
    }

}
