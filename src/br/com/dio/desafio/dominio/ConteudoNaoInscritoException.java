package br.com.dio.desafio.dominio;

/**
 * Exceção personalizada lançada quando o desenvolvedor tenta progredir
 * em um conteúdo no qual não está inscrito.
 */
public class ConteudoNaoInscritoException extends RuntimeException {

    // Construtor principal que aceita uma mensagem personalizada
    public ConteudoNaoInscritoException(String mensagem) {
        super(mensagem);
    }

    // Construtor adicional que aceita uma mensagem e uma causa
    public ConteudoNaoInscritoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
