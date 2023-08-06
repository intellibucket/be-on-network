package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.LinkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "links", schema = "resume")
@Entity(name = "LinkEntity")
public class LinkEntity  extends BaseEntity {
    @ManyToOne
    private InformationEntity information;

    @Enumerated(EnumType.STRING)
    private LinkType type;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "link",nullable = false)
    private String link;
}
