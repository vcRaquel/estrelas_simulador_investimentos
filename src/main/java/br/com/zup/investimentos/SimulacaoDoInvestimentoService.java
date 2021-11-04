package br.com.zup.investimentos;

import org.springframework.stereotype.Service;

@Service
public class SimulacaoDoInvestimentoService {

   public double calcularMultiplicadorDeCapital(TipodeRisco tipoDeRisco, int quantidadeMeses){
       double multiplicadorDeCapital = Math.pow((1 + tipoDeRisco.getTaxaDeRetorno()), quantidadeMeses);
       return multiplicadorDeCapital;
   }

    public double calcularMontante(double valorInvestido, int quantidadeMeses, TipodeRisco tipodeRisco){
        double montante = valorInvestido * calcularMultiplicadorDeCapital(tipodeRisco, quantidadeMeses);
        return montante;
    }

    public double calcularLucro(double valorInvestido, double motante){
        double lucro = motante - valorInvestido;
        return lucro;
    }

}
