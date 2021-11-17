package br.com.diego.exception;

public class ExecucaoJobNotFoundException extends RuntimeException {

    public ExecucaoJobNotFoundException(String message) {
        super(message);
    }
}
