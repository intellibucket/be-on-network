package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.advice.concretes;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.ExceptionPublishModel;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.advice.abstracts.AbstractExceptionPublisherService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionPublisherService implements AbstractExceptionPublisherService {

    @Override
    public void publish(UserID userID,Exception exception) {
        var publishModel = ExceptionPublishModel.of(userID,exception);
    }
}
