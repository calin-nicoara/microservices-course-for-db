package ro.esolacad.microservicesdemo.acounting;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.esolacad.microservicesdemo.acounting.service.AccountService;

@RestController
@RequiredArgsConstructor
public class AccoutingResource {

    private final AccountService accountService;

    @PostMapping("/client")
    public void createClient(@RequestBody String info) {
        accountService.createAccount(info);
    }
}
