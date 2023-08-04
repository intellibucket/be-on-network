package az.rock.flyjob.model.entity.resume;

import az.rock.flyjob.model.entity.resume.details.*;
import az.rock.flyjob.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.model.entity.resume.main.ResumePictureEntity;
import az.rock.flyjob.model.entity.resume.template.ResumeTemplateEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes", schema = "resume")
@Entity(name = "ResumeEntity")
public class ResumeEntity extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private UUID userId;

    @OneToOne(mappedBy = "resume")
    private ResumeTemplateEntity template;

    @OneToOne(mappedBy = "resume")
    private ResumePictureEntity picture;

    @OneToOne(mappedBy = "resume")
    private InformationEntity information;

    @OneToOne(mappedBy = "resume")
    private PersonalSummaryEntity personalSummary;

    @OneToOne(mappedBy = "resume")
    private SignatureDeclarationEntity signatureDeclaration;

    @OneToMany(mappedBy = "resume")
    private List<AwardEntity> awards;

    @OneToMany(mappedBy = "resume")
    private List<ContactEntity> contacts;

    @OneToMany(mappedBy = "resume")
    private List<CourseEntity> courses;

    // FIXME: 04.08.23
    @OneToMany(mappedBy = "resume")
    private List<CustomPaneEntity> customPanes;

    @OneToMany(mappedBy = "resume")
    private List<EducationEntity> educations;

    @OneToMany(mappedBy = "resume")
    private List<ExperienceEntity> experiences;

    @OneToMany(mappedBy = "resume")
    private List<InterestEntity> interests;

    @OneToMany(mappedBy = "resume")
    private List<LanguageEntity> languages;

    @OneToMany(mappedBy = "resume")
    private List<OrganizationEntity> organizations;

    @OneToMany(mappedBy = "resume")
    private List<ProjectEntity> projects;

    @OneToMany(mappedBy = "resume")
    private List<PublicationEntity> publications;

    @OneToMany(mappedBy = "resume")
    private List<ReferenceEntity> references;

    @OneToMany(mappedBy = "resume")
    private List<SkillEntity> skills;

}
