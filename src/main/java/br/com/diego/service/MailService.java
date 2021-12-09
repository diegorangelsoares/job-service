package br.com.diego.service;

import br.com.diego.model.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
public class MailService {

    public static String emailDestino = "diegorangeljpa@gmail.com";

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    FileService fileService;

    @Autowired
    ConfigService configService;

    public void enviarSimples(String assunto, String data, String texto) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(MailService.emailDestino);
        email.setSubject(assunto);
        email.setText(texto);
        mailSender.send(email);

    }

    public void sendMail(String assunto, String data, String texto, String textoAnexo, boolean isCobranca) throws IOException {

        String emailDestino = "";

        if (isCobranca){
            emailDestino = configService.returnValue(Config.CONFIG_NAME_EMAIL_COBRANCA);
        }else{
            emailDestino = configService.returnValue(Config.CONFIG_NAME_EMAIL_CORE);
        }

        if (emailDestino.equals("")){
            emailDestino = MailService.emailDestino;
        }

        String nomeArquivo = "";

        if (!"".equals(textoAnexo)){
            nomeArquivo = fileService.gerarArquivo(textoAnexo);
        }

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(MailService.emailDestino, "Monitoria Job");
            helper.setTo(emailDestino);
            helper.setSentDate(new Date());
            helper.setText(texto, false);
            helper.setSubject(assunto);

            if (!nomeArquivo.equals("")) {

                File attach = new File(nomeArquivo);
                helper.addAttachment(nomeArquivo, attach);

            }

            mailSender.send(mimeMessage);

            log.info("Envio com Sucesso!");
        } catch (MailException e) {
            log.error("Email não pode ser eviado!\n" + e.getMessage());
        } catch (MessagingException e) {
            log.error("Email não pode ser eviado.\n" + e.getMessage());
        } catch (IOException e) {
            log.error("Anexo não encontrado\n" + e.getMessage());
        }
    }

}
