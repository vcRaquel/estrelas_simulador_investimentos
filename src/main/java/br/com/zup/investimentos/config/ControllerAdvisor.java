package br.com.zup.investimentos.config;

import br.com.zup.investimentos.MensagemDeErro;
import br.com.zup.investimentos.exceptionPersonalizada.ValorBaixoParaTipoDeRiscoException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    // como se fosse um observador que vai tomar conta quando aquela exeption ocorre e
    // vai capturar e entregar pro método que vai trabalhar com ela
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    //vai definir o tipo de resposta quando o erro ocorrer (422)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception) {
        //MethodArgumentNotValidException pq foi a que apareceu no log quando estorou uma exception
        List<MensagemDeErro> mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()) {
            //o for vai percorrer a lista de erros que está dentro do MethodArgumentNotValidException
            mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage(), fieldError.getField()));
            //e vai adicionar a mensagem de erro toda vez que este ocorrer
            // dentro da lista de mensagens de erro instanciada no início do método
        }

        return mensagens;
        //vai retornar o conjunto de todas as mensagens de erro
    }

    @ExceptionHandler(ValorBaixoParaTipoDeRiscoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro valorBaixoParaTipoDeRiscoException(ValorBaixoParaTipoDeRiscoException exception){
        return new MensagemDeErro(exception.getMessage(),"valorInvestido");
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MensagemDeErro runtimeException(RuntimeException exception){
        return new MensagemDeErro("Risco não reconhecido");
    }
}
