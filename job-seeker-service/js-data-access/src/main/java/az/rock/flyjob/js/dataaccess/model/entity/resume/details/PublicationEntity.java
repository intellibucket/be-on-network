package az.rock.flyjob.js.dataaccess.model.entity.resume.details;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publications", schema = "resume", indexes = {
        @Index(name = "idx_publicationentity_resume_uuid", columnList = "resume_uuid, accessModifier")
})
@Entity(name = "PublicationEntity")
public class PublicationEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "link")
    private String link;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

    @Column(name = "description")
    private String description;
}
