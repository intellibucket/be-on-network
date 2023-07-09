package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.response.EmailClientModelResponse;
import az.rock.auth.domain.presentation.dto.response.EmailPrivateModelResponse;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractEmailQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractNetworkQueryRepositoryAdapter;
import az.rock.lib.domain.id.EmailID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmailQueryDomainPresentationService implements AbstractEmailQueryDomainPresentationService {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEmailQueryRepositoryAdapter queryEmailRepositoryAdapter;

    private final AbstractNetworkQueryRepositoryAdapter queryNetworkRepositoryAdapter;

    public EmailQueryDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                               AbstractEmailQueryRepositoryAdapter queryEmailRepositoryAdapter,
                                               AbstractNetworkQueryRepositoryAdapter queryNetworkRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.queryEmailRepositoryAdapter = queryEmailRepositoryAdapter;
        this.queryNetworkRepositoryAdapter = queryNetworkRepositoryAdapter;
    }

    @Override
    public EmailPrivateModelResponse queryMyEmailById(UUID uuid) {
        var currentUserId = this.securityContextHolder.availableUser();
        var optionalEmail = this.queryEmailRepositoryAdapter
                .findMyEmailByID(currentUserId, EmailID.of(uuid));
        return optionalEmail.map(EmailPrivateModelResponse::of)
                .orElseThrow(()->new AuthDomainPresentationException("F0000000011"));
    }

    @Override
    public EmailClientModelResponse queryAnyEmailByID(UUID uuid) {
        var optionalEmail = this.queryEmailRepositoryAdapter
                .findAnyByByID(EmailID.of(uuid));
        if (optionalEmail.isEmpty()) throw new AuthDomainPresentationException("F0000000011");
        var emailRoot = optionalEmail.get();
        var response = EmailClientModelResponse.of(emailRoot);
        var currentUserId = this.securityContextHolder.availableUser();
        var targetUserId = emailRoot.getUserId();
        var optionalNetwork =
                this.queryNetworkRepositoryAdapter.findNetworkRelationByBothOfUserIDs(currentUserId, targetUserId);
        if (emailRoot.isPublic()) return response;
        else {
            if (optionalNetwork.isPresent() && optionalNetwork.get().hasValidRelation()) return response;
            else throw new AuthDomainPresentationException("F0000000015");
        }
    }

    @Override
    public List<EmailPrivateModelResponse> queryMyAllEmails() {
        var currentUserId = this.securityContextHolder.availableUser();
        var optionalEmails = this.queryEmailRepositoryAdapter
                .findAllMyEmails(currentUserId);
        var responseList =  optionalEmails.stream()
                .map(EmailPrivateModelResponse::of)
                .toList();
        if (responseList.isEmpty()) throw new AuthDomainPresentationException("F0000000011");
        return responseList;
    }

    @Override
    public List<UUID> queryMyAllEmailsID() {
        var currentUserId = this.securityContextHolder.availableUser();
        var optionalEmails = this.queryEmailRepositoryAdapter
                .findAllMyEmailsID(currentUserId);
        var responseList =  optionalEmails.stream()
                .map(EmailID::getAbsoluteID)
                .toList();
        if (responseList.isEmpty()) throw new AuthDomainPresentationException("F0000000011");
        return responseList;
    }
}
