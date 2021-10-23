package com.it.cinemabackend.notification;

import com.it.cinemabackend.auth.domain.model.User;
import com.it.cinemabackend.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    private static final String EMAIL_FROM = "default";
    private static final long ADVERT_DELAY = 1000 * 60 * 60 * 24 * 7; // week
    // TODO REMOVE THAT TEMPORARY SOLUTION github #60
    private static final String ACTIVATION_ADDRESS = "http://localhost:8080/activate/";

    private final UserService userService;
    private final JavaMailSender javaMailSender;

    public NotificationService(UserService userService, JavaMailSender javaMailSender) {
        this.userService = userService;
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

    @Scheduled(initialDelay = ADVERT_DELAY, fixedDelay = ADVERT_DELAY)
    public void sendAdvertEmail() {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(EMAIL_FROM);
        mail.setSubject("Activate your account!");
        mail.setText("Scheduled email is here.");

        for (User user : userService.loadUsers()) {
            mail.setTo(user.getEmail());
            try {
                javaMailSender.send(mail);
            }
            catch (MailException e) {
                log.error("Could not send advert mails due to mail exception: {}", e.toString());
                return;
            }
        }
        log.info("Sent advertisement email to every user.");
    }
}
