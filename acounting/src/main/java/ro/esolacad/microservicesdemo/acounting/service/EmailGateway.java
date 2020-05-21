package ro.esolacad.microservicesdemo.acounting.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface EmailGateway extends EmailService {

    @Override
    @Gateway(requestChannel = "emailOutChannel")
    void sendEmail(String info);
}
