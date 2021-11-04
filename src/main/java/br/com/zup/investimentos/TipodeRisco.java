package br.com.zup.investimentos;

public enum TipodeRisco {
    ALTO(0.0025), MEDIO(0.0015), BAIXO(0.0005);

    private double taxaDeRetorno;

    TipodeRisco(double taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }
}
