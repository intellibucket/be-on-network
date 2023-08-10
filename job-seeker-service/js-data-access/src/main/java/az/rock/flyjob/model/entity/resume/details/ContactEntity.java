package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ContactFormatType;
import az.rock.lib.valueObject.ContactLiveType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contacts", schema = "resume")
@Entity(name = "ContactEntity")
public class ContactEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Enumerated(EnumType.STRING)
    private ContactFormatType formatType;

    @Enumerated(EnumType.STRING)
    private ContactLiveType liveType;

    @Column(name = "data", nullable = false)
    private String data;
}
