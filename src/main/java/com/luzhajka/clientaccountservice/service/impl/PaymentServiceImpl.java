package com.luzhajka.clientaccountservice.service.impl;

import com.luzhajka.clientaccountservice.controller.dto.DebtDto;
import com.luzhajka.clientaccountservice.controller.dto.PaymentDto;
import com.luzhajka.clientaccountservice.controller.dto.ReplenishDto;
import com.luzhajka.clientaccountservice.exceptions.ClientAccountNotFoundException;
import com.luzhajka.clientaccountservice.repository.AccountRepository;
import com.luzhajka.clientaccountservice.repository.PaymentRepository;
import com.luzhajka.clientaccountservice.repository.entity.AccountEntity;
import com.luzhajka.clientaccountservice.repository.entity.PaymentEntity;
import com.luzhajka.clientaccountservice.service.PaymentService;
import com.luzhajka.clientaccountservice.utils.PaymentDtoEntityMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.luzhajka.clientaccountservice.service.TypeOperation.DEBT;
import static com.luzhajka.clientaccountservice.service.TypeOperation.REPLENISH;
import static java.util.stream.Collectors.toList;

@Service
public class PaymentServiceImpl implements PaymentService {
    AccountRepository accountRepository;
    PaymentRepository paymentRepository;
    PaymentDtoEntityMapper paymentMapper;

    public PaymentServiceImpl(AccountRepository accountRepository, PaymentRepository paymentRepository, PaymentDtoEntityMapper paymentMapper) {
        this.accountRepository = accountRepository;
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    @Transactional
    public void replenishAccount(ReplenishDto replenishDto) {

        AccountEntity accountEntity = accountRepository
                .findById(replenishDto.getAccountNumber())
                .orElseThrow(() -> new ClientAccountNotFoundException("Клиентский счет не найден"));

        accountEntity.getOperations()
                .add(new PaymentEntity.PaymentEntityBuilder()
                        .dateTime(LocalDateTime.now())
                        .accountEntity(accountEntity)
                        .operationAmount(replenishDto.getAmount())
                        .typeOperation(REPLENISH.name())
                        .build());

        accountEntity.setAccountBalance(accountEntity.getAccountBalance().add(replenishDto.getAmount()));

        accountRepository.saveAndFlush(accountEntity);
    }

    @Override
    @Transactional
    public void payProject(DebtDto debtDto) {


        AccountEntity accountEntity = accountRepository
                .findById(debtDto.getAccountNumber())
                .orElseThrow(() -> new ClientAccountNotFoundException("Клиентский счет не найден"));

        accountEntity.getOperations()
                .add(new PaymentEntity.PaymentEntityBuilder()
                        .dateTime(LocalDateTime.now())
                        .accountEntity(accountEntity)
                        .operationAmount(debtDto.getAmount())
                        .typeOperation(DEBT.name())
                        .projectId(debtDto.getProjectId())
                        .build());
        accountEntity.setAccountBalance(accountEntity.getAccountBalance().subtract(debtDto.getAmount()));

        accountRepository.saveAndFlush(accountEntity);
    }

    @Override
    public List<PaymentDto> getOperations(UUID clientAccountId) {
        return accountRepository.findById(clientAccountId)
                .orElseThrow(() -> new ClientAccountNotFoundException("Клиентский счет не найден"))
                .getOperations()
                .stream()
                .map(paymentMapper::entityToDto)
                .collect(toList());
    }

    @Override
    public BigInteger getBalance(UUID clientAccountId) {
        return accountRepository.findById(clientAccountId)
                .orElseThrow(() -> new ClientAccountNotFoundException("Клиентский счет не найден"))
                .getAccountBalance();
    }

    @Override
    public List<PaymentDto> getProjectPayment(Long projectId) {
        return paymentRepository.findAllByProjectId(projectId)
                .stream()
                .map(paymentMapper::entityToDto)
                .collect(toList());
    }
}
