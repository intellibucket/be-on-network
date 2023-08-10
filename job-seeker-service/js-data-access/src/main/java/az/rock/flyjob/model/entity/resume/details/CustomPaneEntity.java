package az.rock.flyjob.model.entity.resume.details;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.PaneType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "custom_pane", schema = "resume")
@Entity(name = "CustomPaneEntity")
public class CustomPaneEntity extends BaseEntity {
    @ManyToOne
    private ResumeEntity resume;

    @Column(name = "order_number",nullable = false)
    private Integer orderNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PaneType type;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "city_id")
    private UUID cityId;

    @Temporal(value = TemporalType.DATE)
    private Timestamp startDate;

    @Temporal(value = TemporalType.DATE)
    private Timestamp endDate;

    @Column(name = "description")
    private String description;

}
