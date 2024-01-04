package com.intellibucket.onnetwork.company.dataAccess.command.mapper.concretes;

import com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts.AbstractWebsiteDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.WebsiteEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WebsiteDataAccessMapper implements AbstractWebsiteDataAccessMapper {
    @Override
    public Optional<WebsiteRoot> toRoot(WebsiteEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<WebsiteEntity> toEntity(WebsiteRoot root) {
        return Optional.empty();
    }
}
