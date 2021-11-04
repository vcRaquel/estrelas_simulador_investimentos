package br.com.zup.investimentos;

public class SimulacaoDoInvestimentoDTO {
    private double valorInvestido;
    private int meses;

    public SimulacaoDoInvestimentoDTO() {

    }

    public SimulacaoDoInvestimentoDTO(double valorInvestido, int meses) {
        this.valorInvestido = valorInvestido;
        this.meses = meses;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}
