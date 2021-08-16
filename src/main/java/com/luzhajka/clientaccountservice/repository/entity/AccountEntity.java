package com.luzhajka.clientaccountservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Entity
@DynamicUpdate
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID accountNumber;

    @Column(name = "client-id")
    Long clientId;

    @Column(name = "operations")
    @OneToMany(mappedBy = "operations", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonManagedReference
    List<PaymentEntity> operations;

    @Column(name = "balance")
    BigInteger accountBalance;


    public AccountEntity(Long clientId, List<PaymentEntity> operations, BigInteger accountBalance) {
        this.clientId = clientId;
        this.operations = operations;
        this.accountBalance = accountBalance;
    }

    public AccountEntity(Long clientId) {
        this.clientId = clientId;
        this.operations = new ArrayList<>();
        this.accountBalance = BigInteger.ZERO;
    }

    public AccountEntity() {
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(UUID personalAccount) {
        this.accountNumber = personalAccount;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<PaymentEntity> getOperations() {
        return operations;
    }

    public void setOperations(List<PaymentEntity> operations) {
        this.operations = operations;
    }

    public BigInteger getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigInteger accountBalance) {
        this.accountBalance = accountBalance;
    }
}
