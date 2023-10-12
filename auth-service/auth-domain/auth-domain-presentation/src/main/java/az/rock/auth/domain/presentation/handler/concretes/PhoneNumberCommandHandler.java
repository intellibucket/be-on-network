package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractPhoneNumberCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPhoneNumberDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPhoneNumberCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPhoneNumberQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.number.PhoneNumberAlreadyUsedException;
import az.rock.flyjob.auth.service.abstracts.AbstractPhoneNumberDomainService;
import az.rock.lib.valueObject.SwitchCase;
import com.intellibukcet.lib.payload.event.create.number.PhoneNumberCreatedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberDeletedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberUpdatedEvent;
import com.intellibukcet.lib.payload.payload.PhoneNumberPayload;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PhoneNumberCommandHandler implements AbstractPhoneNumberCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractPhoneNumberDomainService phoneNumberDomainService;
    private final AbstractPhoneNumberQueryRepositoryAdapter phoneNumberQueryRepositoryAdapter;
    private final AbstractPhoneNumberCommandRepositoryAdapter phoneNumberCommandRepositoryAdapter;
    private final AbstractPhoneNumberDomainMapper phoneNumberDomainMapper;

    public PhoneNumberCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                     AbstractPhoneNumberDomainService phoneNumberDomainService,
                                     AbstractPhoneNumberQueryRepositoryAdapter phoneNumberQueryRepositoryAdapter,
                                     AbstractPhoneNumberCommandRepositoryAdapter phoneNumberCommandRepositoryAdapter,
                                     AbstractPhoneNumberDomainMapper phoneNumberDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.phoneNumberDomainService = phoneNumberDomainService;
        this.phoneNumberQueryRepositoryAdapter = phoneNumberQueryRepositoryAdapter;
        this.phoneNumberCommandRepositoryAdapter = phoneNumberCommandRepositoryAdapter;
        this.phoneNumberDomainMapper = phoneNumberDomainMapper;
    }


    @Override
    public PhoneNumberCreatedEvent add(PhoneNumberCommandRequest request) {
        var currentUser = this.securityContextHolder.availableUser();
        var savedPhoneNumbers = this.phoneNumberQueryRepositoryAdapter.findAllByPID(currentUser);
        var phoneNumberRoot = this.phoneNumberDomainMapper.toRoot(currentUser, request);
        var validatedPhoneNumber = this.phoneNumberDomainService.validateNewPhoneNumber(savedPhoneNumbers, phoneNumberRoot);
        var isExistVerifiedPhoneNumber = this.phoneNumberQueryRepositoryAdapter.isExistVerifiedPhoneNumber(validatedPhoneNumber);
        if (isExistVerifiedPhoneNumber) throw new PhoneNumberAlreadyUsedException();
        var savedNewPhoneNumber = this.phoneNumberCommandRepositoryAdapter.create(validatedPhoneNumber);
        var payload = PhoneNumberPayload.Builder
                .builder()
                .build();
        return PhoneNumberCreatedEvent.of(payload);
    }

    @Override
    public PhoneNumberUpdatedEvent change(PhoneNumberChangeRequest request) {
        return null;
    }

    @Override
    public PhoneNumberDeletedEvent delete(UUID uuid) {
        return null;
    }

    @Override
    public PhoneNumberUpdatedEvent enableSmsNotification(SwitchCase switchCase) {
        return null;
    }

    @Override
    public PhoneNumberUpdatedEvent enableWhatsappNotification(SwitchCase switchCase) {
        return null;
    }

    @Override
    public PhoneNumberUpdatedEvent setPrimary(SwitchCase switchCase) {
        return null;
    }
}
