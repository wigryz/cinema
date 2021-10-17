package com.it.cinemabackend.notification;

import com.it.cinemabackend.auth.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class NotificationService {

    private final JavaMailSender javaMailSender;

    // TEMPORARY SOLUTION
    private static final String ACTIVATION_ADDRESS = "http://localhost:8080/activate/";

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendActivationToken(User user, String token) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("cinema.backend.auto@gmail.com");
        mail.setSubject("Activate your account!");
        mail.setText("Activation link:\n" + ACTIVATION_ADDRESS + token);

        javaMailSender.send(mail);
        log.info("Mail has just been sent to: " + user.getEmail());
    }
}
