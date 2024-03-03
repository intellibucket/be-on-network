package az.rock.flyjob.js.dataaccess.model.entity.statics;

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
@Table(name = "cities", schema = "replica")
@Entity(name = "CityEntity")
public class CityEntity extends BaseEntity {
    @ManyToOne
    private CountryEntity country;

    @Column(name = "name")
    private String name;

    @Column(name = "region")
    private String region;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "city_state_code")
    private String stateCode;

    @Column(name = "city_timezone")
    private String timezone;

    @Column(name = "city_flag")
    private byte[] flag;

    @Column(name = "city_wiki_data_id")
    private String wikiDataId;
}
