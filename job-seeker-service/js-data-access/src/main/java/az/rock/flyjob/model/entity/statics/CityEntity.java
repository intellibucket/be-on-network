package az.rock.flyjob.model.entity.statics;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities", schema = "replica")
@Entity(name = "CityEntity")
public class CityEntity extends BaseEntity {
    @ManyToOne
    private CountryEntity country;

    @Column(name = "city_name")
    private String name;

    @Column(name = "city_region")
    private String region;

    @Column(name = "city_latitude")
    private String latitude;

    @Column(name = "city_longitude")
    private String longitude;

    @Column(name = "city_state_code")
    private String stateCode;

    @Column(name = "city_timezone")
    private String timezone;

    @Column(name = "city_flag")
    private byte[] flag;

    @Column(name = "city_wiki_data_id")
    private String wikiDataId;
}