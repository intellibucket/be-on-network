package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractVerificationDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.VerificationEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.VerificationRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VerificationDataAccessMapper implements AbstractVerificationDataAccessMapper {

    @Override
    public Optional<VerificationRoot> toRoot(VerificationEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<VerificationEntity> toEntity(VerificationRoot root) {
        return Optional.empty();
    }
}
