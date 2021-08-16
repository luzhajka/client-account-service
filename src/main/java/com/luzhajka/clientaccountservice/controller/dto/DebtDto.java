package com.luzhajka.clientaccountservice.controller.dto;

import java.math.BigInteger;
import java.util.UUID;

public class DebtDto {
    /**
     * сумма (amount) в копейках (учитывать при отображении)
     */
    BigInteger amount;
    UUID accountNumber;
    Long projectId;


    public DebtDto() {
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectID) {
        this.projectId = projectID;
    }
}
