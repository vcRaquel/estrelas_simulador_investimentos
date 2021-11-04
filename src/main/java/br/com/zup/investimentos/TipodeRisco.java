package br.com.zup.investimentos;

public enum TipodeRisco {
    ALTO, MEDIO,BAIXO,MÉDIO;

    private double taxaDeRetorno;

    TipodeRisco(double taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }
}
