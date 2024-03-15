package az.rock.flyjob.js.dataaccess.model.compose;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;
import com.intellibucket.lib.fj.dataaccess.annotations.Compose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Compose
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationCompose extends BaseCompose {

    private ResumeEntity resume;

    private AccessModifier accessModifier;

    private Integer orderNumber;

    private EducationDegree degree;

    private EducationState state;

    private String link;

    private UUID establishmentUUID;

    private String establishmentName;

    private UUID cityId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;
}
