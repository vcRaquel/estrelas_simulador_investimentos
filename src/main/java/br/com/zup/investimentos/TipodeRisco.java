package br.com.zup.investimentos;

public enum TipodeRisco {
    ALTO(0.025), MEDIO(0.015), BAIXO(0.005);

    private double taxaDeRetorno;

    TipodeRisco(double taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }
}
