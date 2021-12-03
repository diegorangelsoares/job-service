package br.com.diego.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    public static String emailDestino = "diegorangeljpa@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    public void enviar(String assunto, String data, String texto) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(MailService.emailDestino);
        email.setSubject(assunto);
        email.setText(texto);
        mailSender.send(email);

    }

}
