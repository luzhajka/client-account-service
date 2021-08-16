package com.luzhajka.clientaccountservice.controller;

import com.luzhajka.clientaccountservice.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Tag(name = "Управление")
@RestController("${server.api-base-url}")
public class AccountController {
    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * @param clientId - ID заказчика
     * @return - идентификатор счета
     */
    @Operation(summary = "создать платежный счет клиента")
    @PostMapping(value = "/account/new")
    public UUID createAccount(@RequestParam Long clientId) {
        return accountService.createAccountService(clientId);
    }

}
