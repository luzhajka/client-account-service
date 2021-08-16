package com.luzhajka.clientaccountservice.exceptions;

public class ClientAccountNotFoundException extends RuntimeException {
    public ClientAccountNotFoundException(String message) {
        super(message);
    }
}
