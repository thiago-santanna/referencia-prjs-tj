package com.webapps.tss.samplejobrunr;

import org.springframework.stereotype.Service;

@Service
public class ServiceEnviaEmail {
    public void enviaEmail(String email, String mensagem) {
        System.out.println("Enviando email para " + email + " com a mensagem: " + mensagem);
    }

    public ServiceEnviaEmail() {
        System.out.println("ServiceEnviaEmail instanciado");
    }
}
