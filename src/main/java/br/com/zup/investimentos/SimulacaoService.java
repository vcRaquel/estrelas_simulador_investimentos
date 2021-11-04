package br.com.zup.investimentos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimulacaoService {
    List<RespostaDTO> simulacoes;


    // adicionar investimento
    public void adicionarRespostaALista(RespostaDTO respostaDTO){
        simulacoes.add(respostaDTO);
    }

    public List<RespostaDTO> retornarSimulacoes(){
        return simulacoes;
    }

    public double calcularMultiplicadorDeCapital(TipodeRisco tipoDeRisco, int quantidadeMeses){
       double multiplicadorDeCapital = Math.pow((1 + tipoDeRisco.getTaxaDeRetorno()), quantidadeMeses);
       return multiplicadorDeCapital;
   }

    public double calcularMontante(double valorInvestido, int quantidadeMeses, TipodeRisco tipodeRisco){
        double montante = valorInvestido * calcularMultiplicadorDeCapital(tipodeRisco, quantidadeMeses);
        return montante;
    }

    public double calcularLucro(double valorInvestido, int quantidadedeMeses, TipodeRisco tipodeRisco){
        double montante = calcularMontante(valorInvestido, quantidadedeMeses, tipodeRisco);
        double lucro = montante - valorInvestido;
        return lucro;
    }

    public RespostaDTO simularInvestimento(double capital, int quantidadedeMeses, TipodeRisco tipodeRisco){
        double valorTotalDoLucro = calcularLucro(capital, quantidadedeMeses, tipodeRisco);
        double valorTotal = calcularMontante(capital, quantidadedeMeses,tipodeRisco);

        RespostaDTO respostaDTO = new RespostaDTO(capital, valorTotalDoLucro, valorTotal);
        adicionarRespostaALista(respostaDTO);
        return respostaDTO;
    }

}
