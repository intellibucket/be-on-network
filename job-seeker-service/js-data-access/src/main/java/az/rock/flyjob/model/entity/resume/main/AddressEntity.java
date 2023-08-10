package az.rock.flyjob.model.entity.resume.main;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "country",nullable = false)
    private String country;

    @Column(name = "street",nullable = false)
    private String street;

    @Column(name = "postal_code")
    private String postalCode;
}
