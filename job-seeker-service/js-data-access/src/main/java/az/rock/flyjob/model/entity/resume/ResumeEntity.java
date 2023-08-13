package az.rock.flyjob.model.entity.resume;

import az.rock.flyjob.model.entity.resume.details.*;
import az.rock.flyjob.model.entity.resume.main.InformationEntity;
import az.rock.flyjob.model.entity.resume.main.ResumePictureEntity;
import az.rock.flyjob.model.entity.resume.template.ResumeTemplateEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumes", schema = "resume", indexes = {
        @Index(name = "idx_resumeentity_user_id", columnList = "user_id")
})
@Entity(name = "ResumeEntity")
public class ResumeEntity extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private UUID userId;

    @Column(length = 32, columnDefinition = "varchar(32) default 'ONLY_AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

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

    @OneToMany(mappedBy = "resume")
    private List<CustomPaneEntity> customPanes;

    @OneToMany(mappedBy = "resume")
    private List<EducationEntity> educations;

    @OneToMany(mappedBy = "resume")
    private List<ExperienceEntity> experiences;

    @OneToMany(mappedBy = "resume")
    private List<InterestEntity> interests;

    @OneToMany(mappedBy = "resume")
    private List<ResumeLanguageEntity> languages;

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

    private ResumeEntity(Builder builder) {
        setUserId(builder.userId);
        setAccessModifier(builder.accessModifier);
        setTemplate(builder.template);
        setPicture(builder.picture);
        setInformation(builder.information);
        setPersonalSummary(builder.personalSummary);
        setSignatureDeclaration(builder.signatureDeclaration);
        setAwards(builder.awards);
        setContacts(builder.contacts);
        setCourses(builder.courses);
        setCustomPanes(builder.customPanes);
        setEducations(builder.educations);
        setExperiences(builder.experiences);
        setInterests(builder.interests);
        setLanguages(builder.languages);
        setOrganizations(builder.organizations);
        setProjects(builder.projects);
        setPublications(builder.publications);
        setReferences(builder.references);
        setSkills(builder.skills);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }



    public static final class Builder {
        private UUID userId;
        private AccessModifier accessModifier;
        private ResumeTemplateEntity template;
        private ResumePictureEntity picture;
        private InformationEntity information;
        private PersonalSummaryEntity personalSummary;
        private SignatureDeclarationEntity signatureDeclaration;
        private List<AwardEntity> awards;
        private List<ContactEntity> contacts;
        private List<CourseEntity> courses;
        private List<CustomPaneEntity> customPanes;
        private List<EducationEntity> educations;
        private List<ExperienceEntity> experiences;
        private List<InterestEntity> interests;
        private List<ResumeLanguageEntity> languages;
        private List<OrganizationEntity> organizations;
        private List<ProjectEntity> projects;
        private List<PublicationEntity> publications;
        private List<ReferenceEntity> references;
        private List<SkillEntity> skills;
        private UUID uuid;
        private Long version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private Timestamp createdDate;
        private Timestamp lastModifiedDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder template(ResumeTemplateEntity val) {
            template = val;
            return this;
        }

        public Builder picture(ResumePictureEntity val) {
            picture = val;
            return this;
        }

        public Builder information(InformationEntity val) {
            information = val;
            return this;
        }

        public Builder personalSummary(PersonalSummaryEntity val) {
            personalSummary = val;
            return this;
        }

        public Builder signatureDeclaration(SignatureDeclarationEntity val) {
            signatureDeclaration = val;
            return this;
        }

        public Builder awards(List<AwardEntity> val) {
            awards = val;
            return this;
        }

        public Builder contacts(List<ContactEntity> val) {
            contacts = val;
            return this;
        }

        public Builder courses(List<CourseEntity> val) {
            courses = val;
            return this;
        }

        public Builder customPanes(List<CustomPaneEntity> val) {
            customPanes = val;
            return this;
        }

        public Builder educations(List<EducationEntity> val) {
            educations = val;
            return this;
        }

        public Builder experiences(List<ExperienceEntity> val) {
            experiences = val;
            return this;
        }

        public Builder interests(List<InterestEntity> val) {
            interests = val;
            return this;
        }

        public Builder languages(List<ResumeLanguageEntity> val) {
            languages = val;
            return this;
        }

        public Builder organizations(List<OrganizationEntity> val) {
            organizations = val;
            return this;
        }

        public Builder projects(List<ProjectEntity> val) {
            projects = val;
            return this;
        }

        public Builder publications(List<PublicationEntity> val) {
            publications = val;
            return this;
        }

        public Builder references(List<ReferenceEntity> val) {
            references = val;
            return this;
        }

        public Builder skills(List<SkillEntity> val) {
            skills = val;
            return this;
        }

        public Builder uuid(UUID val) {
            uuid = val;
            return this;
        }

        public Builder version(Long val) {
            version = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder createdDate(Timestamp val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(Timestamp val) {
            lastModifiedDate = val;
            return this;
        }

        public ResumeEntity build() {
            return new ResumeEntity(this);
        }
    }
}
