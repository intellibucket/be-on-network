package az.rock.flyjob.model.entity.resume.template;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.js.LayoutColumnAlignmentType;
import az.rock.lib.valueObject.js.LayoutType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "template_layouts", schema = "resume")
@Entity(name = "LayoutEntity")
public class LayoutEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private LayoutType layoutType;

    @Enumerated(EnumType.STRING)
    private LayoutColumnAlignmentType layoutColumnAlignmentType;
}
