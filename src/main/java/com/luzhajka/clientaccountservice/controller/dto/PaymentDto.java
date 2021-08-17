package com.luzhajka.clientaccountservice.controller.dto;

import com.luzhajka.clientaccountservice.service.TypeOperation;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDto {
    @Schema(description = "id операции")
    Long id;

    @Schema(description = "номер клиентского счета")
    UUID personalAccount;

    @Schema(description = "дата и время операции")
    LocalDateTime dateTime;

    @Schema(description = "тип операции")
    TypeOperation typeOperation;

    @Schema(description = "сумма средств, участвующих в операции")
    BigInteger operationAmount;


    public PaymentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPersonalAccount() {
        return personalAccount;
    }

    public void setPersonalAccount(UUID personalAccount) {
        this.personalAccount = personalAccount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    public BigInteger getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(BigInteger operationAmount) {
        this.operationAmount = operationAmount;
    }
}
