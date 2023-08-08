package az.rock.flyjob.js.domain.presentation.dto.request;

import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class ContactUpdateRequest {
    private UUID contactId;
    private ContactFormatType formatType;
    private ContactLiveType liveType;
    private String data;
}
