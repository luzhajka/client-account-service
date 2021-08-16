package com.luzhajka.clientaccountservice.controller.dto;

import java.math.BigInteger;
import java.util.UUID;

public class ReplenishDto {
    /**
     * сумма (amount) в копейках (учитывать при отображении)
     */
    BigInteger amount;
    UUID accountNumber;

    public ReplenishDto(BigInteger amount, UUID accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public ReplenishDto() {
    }


    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID accountNumber) {
        this.accountNumber = accountNumber;
    }
}
