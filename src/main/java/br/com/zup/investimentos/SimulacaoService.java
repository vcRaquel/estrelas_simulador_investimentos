package br.com.zup.investimentos;

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
       double multiplicadorDeCapital = Math.pow((1 + simulacaoDTO.getRisco().getTaxaDeRetorno()), simulacaoDTO.getMeses());
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
        double valorTotalDoLucro = calcularLucro(simulacaoDTO);
        double valorTotal = calcularMontante(simulacaoDTO);

        RespostaDTO respostaDTO = new RespostaDTO(simulacaoDTO.getValorInvestido(), valorTotalDoLucro, valorTotal);
        adicionarSimulacaoALista(simulacaoDTO);
        return respostaDTO;
    }

}
