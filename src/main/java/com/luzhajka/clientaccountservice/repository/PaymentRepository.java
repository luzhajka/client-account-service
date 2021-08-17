package com.luzhajka.clientaccountservice.repository;

import com.luzhajka.clientaccountservice.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findAllByProjectId(Long projectId);
}
