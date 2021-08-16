package com.luzhajka.clientaccountservice.utils;

import com.luzhajka.clientaccountservice.controller.dto.PaymentDto;
import com.luzhajka.clientaccountservice.repository.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface PaymentDtoEntityMapper {
    @Mappings({@Mapping(target = "personalAccount", expression = "java(entity.getAccountEntity().getAccountNumber())"),
            @Mapping(target = "id", source = "entity.id"),
            @Mapping(target = "typeOperation", source = "entity.operation"),
            @Mapping(target = "operationAmount", source = "entity.operationAmount"),
            @Mapping(target = "dateTime", source = "entity.dateTime")})
    PaymentDto entityToDto(PaymentEntity entity);
}
