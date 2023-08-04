package az.rock.flyjob.model.entity.statics;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.EducationEstablishmentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "education_establishments", schema = "js")
@Entity(name = "EducationEstablishmentEntity")
public class EducationEstablishmentEntity extends BaseEntity {

    @Column(name = "establishment_name", nullable = false)
    private String establishmentName;

    @Enumerated(EnumType.STRING)
    private EducationEstablishmentType type;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;
}
