package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.EmailClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.EmailPrivateModelResponse;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractEmailQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.lib.domain.id.EmailID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmailQueryDomainPresentationService implements AbstractEmailQueryDomainPresentationService {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEmailQueryRepositoryAdapter queryEmailRepositoryAdapter;

    public EmailQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                               AbstractEmailQueryRepositoryAdapter queryEmailRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.queryEmailRepositoryAdapter = queryEmailRepositoryAdapter;
    }

    @Override
    public EmailPrivateModelResponse queryMyEmailById(UUID uuid) {
        var currentUserId = this.securityContextHolder.currentUser();
        var optionalEmail = this.queryEmailRepositoryAdapter
                .findMyEmailByID(currentUserId, EmailID.of(uuid));
        return optionalEmail.map(EmailPrivateModelResponse::of)
                .orElseThrow(()->new AuthDomainException("F0000000011"));
    }

    @Override
    public EmailClientModelResponse queryAnyEmailByID(UUID uuid) {
        var optionalEmail = this.queryEmailRepositoryAdapter
                .findAnyByByID(EmailID.of(uuid));
        if (optionalEmail.isEmpty()) throw new AuthDomainException("F0000000011");
        var emailRoot = optionalEmail.get();
        if (!emailRoot.isPublic()) throw new AuthDomainException("F0000000015");
        return EmailClientModelResponse.of(emailRoot);
    }

    @Override
    public List<EmailPrivateModelResponse> queryMyAllEmails() {
        var currentUserId = this.securityContextHolder.currentUser();
        var optionalEmails = this.queryEmailRepositoryAdapter
                .findAllMyEmails(currentUserId);
        var responseList =  optionalEmails.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(EmailPrivateModelResponse::of)
                .toList();
        if (responseList.isEmpty()) throw new AuthDomainException("F0000000011");
        return responseList;
    }

    @Override
    public List<UUID> queryMyAllEmailsID() {
        var currentUserId = this.securityContextHolder.currentUser();
        var optionalEmails = this.queryEmailRepositoryAdapter
                .findAllMyEmailsID(currentUserId);
        var responseList =  optionalEmails.stream()
                .map(EmailID::getAbsoluteID)
                .toList();
        if (responseList.isEmpty()) throw new AuthDomainException("F0000000011");
        return responseList;
    }
}
