package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.auth.domain.presentation.dto.response.EmailClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.EmailPrivateModelResponse;

import java.util.List;
import java.util.UUID;

public interface AbstractEmailQueryDomainPresentationService {
    EmailPrivateModelResponse queryMyEmailById(UUID uuid);

    EmailClientModelResponse queryAnyEmailByID(UUID uuid);

    List<EmailPrivateModelResponse> queryMyAllEmails();

    List<UUID> queryMyAllEmailsID();
}
