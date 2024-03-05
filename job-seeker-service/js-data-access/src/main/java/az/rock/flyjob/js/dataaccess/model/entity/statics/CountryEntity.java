package az.rock.flyjob.js.dataaccess.model.entity.statics;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


//TODO ISLESIN DIE COMMENTE ALINIB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries", schema = "replica")
@Entity(name = "CountryEntity")
public class CountryEntity extends BaseEntity {
//    @Column(name = "country_code")
//    private String code;
//
//    @Column(name = "country_phone_code")
//    private String phoneCode;
//
//    @Column(name = "country_name")
//    private String name;
//
//    @Column(name = "country_capital")
//    private String currency;
//
//    @OneToMany(mappedBy = "country")
//   private List<LanguageEntity> languages;

    @OneToMany(mappedBy = "country")
    private List<CityEntity> cities;
}
