package com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts;

import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;
import com.intellibucket.onnetwork.company.dataAccess.command.model.entity.company.CompanyEntity;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

public interface AbstractCompanyDataAccessMapper  extends AbstractDataAccessMapper<CompanyEntity,CompanyRoot>{
}
