package az.rock.flyjob.auth.dataAccess.entity.detail;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geo_positions", schema = "auth")
@Entity(name = "GeoPositionEntity")
public class GeoPositionEntity extends BaseEntity {

    @ManyToOne
    private UserEntity userEntity;

    @Column(name = "country_code", length = 2, nullable = false)
    private String countryCode;

    @Column(name = "latitude", precision = 10, scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 11, scale = 8)
    private BigDecimal longitude;

    @Column(name = "timezone", length = 100)
    private String timezone;

    @Column(name = "gmt", length = 10)
    private String gmt;

}
