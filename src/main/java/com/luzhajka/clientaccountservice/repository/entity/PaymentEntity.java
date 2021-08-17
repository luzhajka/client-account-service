package com.luzhajka.clientaccountservice.repository.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@DynamicUpdate
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JsonBackReference
    AccountEntity accountEntity;

    @Column(name = "date-time")
    LocalDateTime dateTime;

    @Column(name = "type-operation")
    String operation;

    @Column(name = "amount")
    BigInteger operationAmount;

    @Column(name = "project-id")
    Long projectId;


    public PaymentEntity() {
    }

    public PaymentEntity(AccountEntity accountEntity, LocalDateTime dateTime, String operation, BigInteger operationAmount, Long projectId) {
        this.accountEntity = accountEntity;
        this.dateTime = dateTime;
        this.operation = operation;
        this.operationAmount = operationAmount;
        this.projectId= projectId;
    }

    public static class PaymentEntityBuilder {
        private AccountEntity accountEntity;
        private LocalDateTime dateTime;
        private String operation;
        private BigInteger operationAmount;
        private Long projectId;

        public PaymentEntityBuilder accountEntity(AccountEntity accountEntity) {
            this.accountEntity = accountEntity;
            return this;
        }

        public PaymentEntityBuilder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public PaymentEntityBuilder typeOperation(String operation) {
            this.operation = operation;
            return this;
        }
        public PaymentEntityBuilder projectId(Long projectId) {
            this.projectId = projectId;
            return this;
        }

        public PaymentEntityBuilder operationAmount(BigInteger operationAmount) {
            this.operationAmount = operationAmount;
            return this;
        }

        public PaymentEntity build() {
            return new PaymentEntity(accountEntity, dateTime, operation, operationAmount, projectId);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountEntity getAccountEntity() {
        return accountEntity;
    }

    public void setAccountEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public BigInteger getOperationAmount() {
        return operationAmount;
    }

    public void setAmount(BigInteger operationAmount) {
        this.operationAmount = operationAmount;
    }

    public void setOperationAmount(BigInteger operationAmount) {
        this.operationAmount = operationAmount;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
