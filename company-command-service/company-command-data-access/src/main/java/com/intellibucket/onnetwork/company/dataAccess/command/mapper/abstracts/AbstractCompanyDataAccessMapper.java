package com.intellibucket.onnetwork.company.dataAccess.command.mapper.abstracts;

import az.rock.lib.domain.AggregateRoot;
import com.intellibucket.lib.fj.dataaccess.AbstractDataAccessMapper;

public interface AbstractCompanyDataAccessMapper <E,R extends AggregateRoot<?>> extends AbstractDataAccessMapper<E,R> {
}
