package br.com.zup.investimentos;

import org.springframework.stereotype.Service;

@Service
public class SimulacaoDoInvestimentoService {

    public double calcularMontante(double valorInvestido, int quantidadeMeses, TipodeRisco tipodeRisco){
        double montante = valorInvestido * Math.pow((1 + tipodeRisco.getTaxaDeRetorno()), quantidadeMeses);
        return montante;
    }



}
