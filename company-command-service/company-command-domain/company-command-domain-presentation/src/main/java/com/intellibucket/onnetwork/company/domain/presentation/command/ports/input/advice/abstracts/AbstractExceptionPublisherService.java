package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.advice.abstracts;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional
public interface AbstractExceptionPublisherService {
    void publish(UserID userID,Exception exception);
}
