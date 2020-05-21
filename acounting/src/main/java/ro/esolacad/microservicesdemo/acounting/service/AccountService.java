package ro.esolacad.microservicesdemo.acounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final EmailService emailService;

    public void createAccount(String clientInfo) {
        // Account code (create client, create billing, etc)


        // Send email
        emailService.sendEmail(clientInfo);
    }
}
