package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
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
@Table(name = "signature_declaration", schema = "resume")
@Entity(name = "SignatureDeclarationEntity")
public class SignatureDeclarationEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

    @Column(name = "signature")
    private byte[] signature;
}
