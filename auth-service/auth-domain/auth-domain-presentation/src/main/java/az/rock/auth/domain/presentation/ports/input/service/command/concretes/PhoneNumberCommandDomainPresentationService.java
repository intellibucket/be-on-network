package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractPhoneNumberCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractPhoneNumberCommandDomainPresentationService;
import az.rock.lib.annotation.InputPort;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@InputPort
@Service
public class PhoneNumberCommandDomainPresentationService implements AbstractPhoneNumberCommandDomainPresentationService {
    private final AbstractPhoneNumberCommandHandler phoneNumberCommandHandler;

    public PhoneNumberCommandDomainPresentationService(AbstractPhoneNumberCommandHandler phoneNumberCommandHandler) {
        this.phoneNumberCommandHandler = phoneNumberCommandHandler;
    }

    @Override
    public void add(PhoneNumberCommandRequest request) {
        var event = this.phoneNumberCommandHandler.add(request);
    }

    @Override
    public void change(PhoneNumberChangeRequest request) {
        var event = this.phoneNumberCommandHandler.change(request);
    }

    @Override
    public void delete(UUID uuid) {
        var event = this.phoneNumberCommandHandler.delete(uuid);
    }

    @Override
    public void enableSmsNotification(SwitchCase switchCase) {
        var event = this.phoneNumberCommandHandler.enableSmsNotification(switchCase);
    }

    @Override
    public void enableWhatsappNotification(SwitchCase switchCase) {
        var event = this.phoneNumberCommandHandler.enableWhatsappNotification(switchCase);
    }

    @Override
    public void setPrimary(SwitchCase switchCase) {
        var event = this.phoneNumberCommandHandler.setPrimary(switchCase);
    }
}
