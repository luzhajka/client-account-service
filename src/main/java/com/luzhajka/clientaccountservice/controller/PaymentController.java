package com.luzhajka.clientaccountservice.controller;

import com.luzhajka.clientaccountservice.controller.dto.DebtDto;
import com.luzhajka.clientaccountservice.controller.dto.PaymentDto;
import com.luzhajka.clientaccountservice.controller.dto.ReplenishDto;
import com.luzhajka.clientaccountservice.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;


@Tag(name = "Управление")
@RestController("${server.api-base-url}")
public class PaymentController {
    PaymentService paymentService;


    @Operation(summary = "пополнить счет")
    @PutMapping(value = "/account/deposit")
    public void replenishAccount(@RequestBody ReplenishDto replenishDto) {
        paymentService.replenishAccount(replenishDto);
    }

    @Operation(summary = "оплатить проект со счета")
    @PutMapping(value = "/account/pay")
    public void payProject(@RequestBody DebtDto debtDto) {
        paymentService.payProject(debtDto);
    }

    @Operation(summary = "получить все операции по счету")
    @GetMapping(value = "/account/operations")
    public List<PaymentDto> getOperations(@RequestParam UUID clientAccountId) {
        return paymentService.getOperations(clientAccountId);
    }

    @Operation(summary = "найти оплату проекта")
    @GetMapping(value = "/account/operations/project")
    public List<PaymentDto> getProjectPayment(@RequestParam Long projectId) {
        return paymentService.getProjectPayment(projectId);
    }

    @Operation(summary = "получить текущий баланс")
    @GetMapping(value = "/account/balance")
    public BigInteger getBalance(@RequestParam UUID clientAccountId) {
        return paymentService.getBalance(clientAccountId);
    }

}
