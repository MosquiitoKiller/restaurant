package ru.orangemaks.restaurant.Services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import ru.orangemaks.restaurant.Domain.Order.MailOrderSender;

public class MailService implements MailOrderSender {
    private final JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    @Override
    public void sendOrderInfo(String mail, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail);
        mailMessage.setSubject("Ресторан \"еда тута\"");
        mailMessage.setText(message);
        javaMailSender.send(mailMessage);
    }
}
