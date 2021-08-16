package com.luzhajka.clientaccountservice.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public class AccountDto {
    @Schema(description = "номер клиентского")
    public UUID personalAccount;

    @Schema(description = "ID клиента")
    public Long clientId;

    @Schema(description = "список операций клиента")
    public List<PaymentDto> operations;

    @Schema(description = "Текущий баланс счета клиента")
    public BigInteger accountBalance;


    public AccountDto() {
    }

    public AccountDto(UUID personalAccount, Long clientId, List<PaymentDto> operations, BigInteger accountBalance) {
        this.personalAccount = personalAccount;
        this.clientId = clientId;
        this.operations = operations;
        this.accountBalance = accountBalance;
    }

    public UUID getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(UUID personalAccount) {
        this.personalAccount = personalAccount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<PaymentDto> getOperations() {
        return operations;
    }

    public void setOperations(List<PaymentDto> operations) {
        this.operations = operations;
    }

    public BigInteger getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigInteger accountBalance) {
        this.accountBalance = accountBalance;
    }
}
