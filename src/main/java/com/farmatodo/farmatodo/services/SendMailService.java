package com.farmatodo.farmatodo.services;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String from;

    public void sendEmail(String to, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true); // true = HTML habilitado

            mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException("Error enviando correo", e);
        }
    }
}