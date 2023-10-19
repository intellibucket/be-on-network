package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.PhoneNumberChangeRequest;
import az.rock.auth.domain.presentation.dto.request.PhoneNumberCommandRequest;
import az.rock.lib.valueObject.SwitchCase;
import com.intellibukcet.lib.payload.event.create.number.PhoneNumberCreatedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberDeletedEvent;
import com.intellibukcet.lib.payload.event.update.number.PhoneNumberUpdatedEvent;

import java.util.UUID;

/**
 * Yalniz maksimum 3 nomresi ola biler aktiv olan.
 */
public interface AbstractPhoneNumberCommandHandler {
    PhoneNumberCreatedEvent add(PhoneNumberCommandRequest request);

    PhoneNumberUpdatedEvent change(PhoneNumberChangeRequest request);

    //RowStatus Delete olunur
    PhoneNumberDeletedEvent delete(UUID uuid);

    //Yalniz bir nomre ucun ola biler
    PhoneNumberUpdatedEvent enableSmsNotification(SwitchCase switchCase);

    PhoneNumberUpdatedEvent enableWhatsappNotification(SwitchCase switchCase);

    //Yalniz bir primary ola biler
    PhoneNumberUpdatedEvent setPrimary(SwitchCase switchCase);
}
