package com.luzhajka.clientaccountservice.service;

import com.luzhajka.clientaccountservice.controller.dto.DebtDto;
import com.luzhajka.clientaccountservice.controller.dto.PaymentDto;
import com.luzhajka.clientaccountservice.controller.dto.ReplenishDto;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface PaymentService {

    void replenishAccount(ReplenishDto replenishDto);

    void payProject(DebtDto debtDto);

    List<PaymentDto> getOperations(UUID clientId);

    BigInteger getBalance(UUID clientId);

    List<PaymentDto> getProjectPayment(Long projectId);
}
