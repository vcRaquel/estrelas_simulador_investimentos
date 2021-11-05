package br.com.zup.investimentos.exceptionPersonalizada;

public class ValorBaixoParaTipoDeRiscoException extends RuntimeException{

    public ValorBaixoParaTipoDeRiscoException(String message){
        super(message);
    }
}
