package az.rock.flyjob.js.dataaccess.model.entity.statics;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO ISLESIN DIE COMMENTE ALINIB
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "languages", schema = "replica")
@Entity(name = "LanguageEntity")
public class LanguageEntity extends BaseEntity {
//    @ManyToOne
//    private CountryEntity country;

    private String name;
//    private String iso639_1;
//    private String iso639_2_T;
//    private String nativeName;
}
