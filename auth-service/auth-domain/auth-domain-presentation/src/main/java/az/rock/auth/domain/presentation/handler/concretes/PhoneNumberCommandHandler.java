package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.exception.UnknownSystemException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractPhoneNumberCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPhoneNumberDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPhoneNumberCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractPhoneNumberQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.number.PhoneNumberAlreadyUsedException;
import az.rock.flyjob.auth.exception.number.PhoneNumberNotFoundException;
import az.rock.flyjob.auth.root.user.PhoneNumberRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractPhoneNumberDomainService;
import az.rock.lib.domain.id.auth.PhoneNumberID;
import az.rock.lib.valueObject.SwitchCase;
import com.intellibucket.lib.payload.event.create.number.PhoneNumberCreatedEvent;
import com.intellibucket.lib.payload.event.update.number.PhoneNumberDeletedEvent;
import com.intellibucket.lib.payload.event.update.number.PhoneNumberUpdatedEvent;
import com.intellibucket.lib.payload.payload.PhoneNumberPayload;
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

    private PhoneNumberPayload toPayload(PhoneNumberRoot phoneNumberRoot) {
        return PhoneNumberPayload.Builder
                .builder()
                .userID(phoneNumberRoot.getUserID().getAbsoluteID())
                .id(phoneNumberRoot.getRootID().getAbsoluteID())
                .countryCode(phoneNumberRoot.getCountryCode())
                .phoneNumber(phoneNumberRoot.getPhoneNumber())
                .isVerified(phoneNumberRoot.getVerified())
                .isPrimary(phoneNumberRoot.getPrimary())
                .isEnableSmsNotification(phoneNumberRoot.getEnableSmsNotification())
                .isEnableWhatsappNotification(phoneNumberRoot.getEnableWhatsappNotification())
                .type(phoneNumberRoot.getType())
                .accessModifier(phoneNumberRoot.getAccessModifier())
                .build();
    }

    @Override
    public PhoneNumberCreatedEvent add(PhoneNumberCommandRequest request) {
        var currentUser = this.securityContextHolder.availableUser();
        var savedPhoneNumbers = this.phoneNumberQueryRepositoryAdapter.findAllByPID(currentUser);
        var phoneNumberRoot = this.phoneNumberDomainMapper.toNewRoot(currentUser, request);
        var validatedPhoneNumber = this.phoneNumberDomainService.validatePhoneNumber(savedPhoneNumbers, phoneNumberRoot);
        var isExistVerifiedPhoneNumber = this.phoneNumberQueryRepositoryAdapter.isExistVerifiedPhoneNumber(validatedPhoneNumber);
        if (isExistVerifiedPhoneNumber) throw new PhoneNumberAlreadyUsedException();
        var optionalPhoneNumberRoot = this.phoneNumberCommandRepositoryAdapter.create(validatedPhoneNumber);
        if (optionalPhoneNumberRoot.isEmpty()) throw new UnknownSystemException();
        var phoneNumberPayload = this.toPayload(optionalPhoneNumberRoot.get());
        return PhoneNumberCreatedEvent.of(phoneNumberPayload);
    }

    @Override
    public PhoneNumberUpdatedEvent change(PhoneNumberChangeRequest request) {
        var currentUser = this.securityContextHolder.availableUser();
        var savedPhoneNumbers = this.phoneNumberQueryRepositoryAdapter.findAllByPID(currentUser);
        var optionalPhoneNumberRoot = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUser, PhoneNumberID.of(request.getPhoneNumberUUID()));
        if (optionalPhoneNumberRoot.isPresent()) {
            var phoneNumberRoot = optionalPhoneNumberRoot.get();
            var changedRoot = phoneNumberRoot
                    .changePhoneNumber(request.getPhoneNumber())
                    .changeCountryCode(request.getCountryCode())
                    .changeType(request.getType());
            var validatedPhoneNumber = this.phoneNumberDomainService.validatePhoneNumber(savedPhoneNumbers, changedRoot);
            var isExistVerifiedPhoneNumber = this.phoneNumberQueryRepositoryAdapter.isExistVerifiedPhoneNumber(validatedPhoneNumber);
            if (isExistVerifiedPhoneNumber) throw new PhoneNumberAlreadyUsedException();
            this.phoneNumberCommandRepositoryAdapter.update(validatedPhoneNumber);
            var payload = this.toPayload(validatedPhoneNumber);
            return PhoneNumberUpdatedEvent.of(payload);
        } else throw new UnknownSystemException();
    }

    @Override
    public PhoneNumberDeletedEvent delete(UUID uuid) {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalPhoneNumber = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUser,PhoneNumberID.of(uuid));
        if (optionalPhoneNumber.isPresent()){
            var phoneNumber = optionalPhoneNumber.get();
            this.phoneNumberCommandRepositoryAdapter.delete(phoneNumber);
            return PhoneNumberDeletedEvent.of(phoneNumber.getRootID().getAbsoluteID());
        }else throw new PhoneNumberNotFoundException();
    }

    @Override
    public PhoneNumberUpdatedEvent enableSmsNotification(SwitchCase switchCase) {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalPhoneNumber = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUser,PhoneNumberID.of(switchCase.getUuid()));
        if (optionalPhoneNumber.isPresent()){
            var phoneNumber = optionalPhoneNumber.get();
            if (switchCase.isActive()) phoneNumber.enableSmsNotification();
            else phoneNumber.disableSmsNotification();
            var payload = this.toPayload(phoneNumber);
            return PhoneNumberUpdatedEvent.of(payload);
        }else throw new PhoneNumberNotFoundException();
    }

    @Override
    public PhoneNumberUpdatedEvent enableWhatsappNotification(SwitchCase switchCase) {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalPhoneNumber = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUser,PhoneNumberID.of(switchCase.getUuid()));
        if (optionalPhoneNumber.isPresent()){
            var phoneNumber = optionalPhoneNumber.get();
            if (switchCase.isActive()) phoneNumber.enableWhatsappNotification();
            else phoneNumber.disableWhatsappNotification();
            var payload = this.toPayload(phoneNumber);
            return PhoneNumberUpdatedEvent.of(payload);
        }else throw new PhoneNumberNotFoundException();
    }

    @Override
    public PhoneNumberUpdatedEvent setPrimary(SwitchCase switchCase) {
        var currentUser = this.securityContextHolder.availableUser();
        var optionalPhoneNumber = this.phoneNumberQueryRepositoryAdapter.findOwnByID(currentUser,PhoneNumberID.of(switchCase.getUuid()));
        if (optionalPhoneNumber.isPresent()){
            var phoneNumber = optionalPhoneNumber.get();
            var savedPhoneNumbers = this.phoneNumberQueryRepositoryAdapter.findAllByPID(currentUser);
            var map = PhoneNumberRoot.groupByPhoneNumberID(savedPhoneNumbers);
            map.forEach((k,v)->{
                if (k.equals(phoneNumber.getRootID())) v.enablePrimary();
                else v.disablePrimary();
            });
            var updatedValues  = map.values().stream().toList();
            this.phoneNumberCommandRepositoryAdapter.updateAll(updatedValues);
            var payload = this.toPayload(phoneNumber);
            return PhoneNumberUpdatedEvent.of(payload);
        }else throw new PhoneNumberNotFoundException();
    }
}
