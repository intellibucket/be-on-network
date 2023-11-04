package az.rock.flyjob.auth.dataAccess.model.compose.user;

import az.rock.flyjob.auth.dataAccess.model.compose.BaseCompose;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GeoPositionCompose  extends BaseCompose {
    private UUID deviceUUID;

    private String countryCode;

    private BigDecimal latitude;

    private BigDecimal longitude;

    private String timezone;

    private String gmt;
}
