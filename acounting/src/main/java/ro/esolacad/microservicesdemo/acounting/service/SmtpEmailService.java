package ro.esolacad.microservicesdemo.acounting.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class SmtpEmailService implements EmailService{

    @StreamListener("emailInChannel")
    public void sendEmail(String info) {
        System.out.println("This is my email info: " + info);
        // send email
    }
}
