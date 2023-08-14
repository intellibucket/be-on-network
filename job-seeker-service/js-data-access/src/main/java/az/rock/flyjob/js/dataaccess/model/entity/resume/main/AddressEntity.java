package az.rock.flyjob.js.dataaccess.model.entity.resume.main;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses", schema = "resume")
@Entity(name = "AddressEntity")
public class AddressEntity extends BaseEntity {
    @OneToOne
    private InformationEntity information;

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "postal_code")
    private String postalCode;
}
