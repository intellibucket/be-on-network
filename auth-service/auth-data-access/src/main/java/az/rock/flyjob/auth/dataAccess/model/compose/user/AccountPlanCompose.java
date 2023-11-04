package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import az.rock.lib.valueObject.AccountPlanType;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountPlanCompose extends BaseCompose {
    private UUID userUUID;

    private AccountPlanType plan;

    private Timestamp startDate;

    private Timestamp expiredDate;

    private Boolean isExpired;

    private String promoCode;
}
