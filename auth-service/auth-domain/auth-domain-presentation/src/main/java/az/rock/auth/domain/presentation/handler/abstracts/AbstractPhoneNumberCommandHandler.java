package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.lib.valueObject.SwitchCase;
import com.intellibukcet.lib.payload.event.create.number.PhoneNumberCreatedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberDeletedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberUpdatedEvent;

import java.util.UUID;

public interface AbstractPhoneNumberCommandHandler {
    PhoneNumberCreatedEvent add(PhoneNumberCommandRequest request);

    PhoneNumberUpdatedEvent change(PhoneNumberChangeRequest request);

    PhoneNumberDeletedEvent delete(UUID uuid);

    PhoneNumberUpdatedEvent enableSmsNotification(SwitchCase switchCase);

    PhoneNumberUpdatedEvent enableWhatsappNotification(SwitchCase switchCase);

    PhoneNumberUpdatedEvent setPrimary(SwitchCase switchCase);
}
