package az.rock.flyjob.js.domain.core.root;

import az.rock.flyjob.js.domain.core.root.detail.*;
import az.rock.flyjob.js.domain.core.root.main.InformationRoot;
import az.rock.flyjob.js.domain.core.root.main.ResumePictureRoot;
import az.rock.flyjob.js.domain.core.root.template.ResumeTemplateRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ResumeRoot extends AggregateRoot<ResumeID> {
    private UUID userId;

    private AccessModifier accessModifier;

    private ResumeTemplateRoot template;

    private ResumePictureRoot picture;

    private InformationRoot information;

    private PersonalSummaryRoot personalSummary;

    private SignatureDeclarationRoot signatureDeclaration;

    private List<AwardRoot> awards;

    private List<ContactRoot> contacts;

    private List<CourseRoot> courses;

    private List<CustomPaneRoot> customPanes;

    private List<EducationRoot> educations;

    private List<ExperienceRoot> experiences;

    private List<InterestRoot> interests;

    private List<ResumeLanguageRoot> languages;

    private List<OrganizationRoot> organizations;

    private List<ProjectRoot> projects;

    private List<PublicationRoot> publications;

    private List<ReferenceRoot> references;

    private List<SkillRoot> skills;

    private ResumeRoot(Builder builder) {
        super(builder.resumeID, builder.version, builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        userId = builder.userId;
        accessModifier = builder.accessModifier;
        template = builder.template;
        picture = builder.picture;
        information = builder.information;
        personalSummary = builder.personalSummary;
        signatureDeclaration = builder.signatureDeclaration;
        awards = builder.awards;
        contacts = builder.contacts;
        courses = builder.courses;
        customPanes = builder.customPanes;
        educations = builder.educations;
        experiences = builder.experiences;
        interests = builder.interests;
        languages = builder.languages;
        organizations = builder.organizations;
        projects = builder.projects;
        publications = builder.publications;
        references = builder.references;
        skills = builder.skills;
    }


    public UUID getUserId() {
        return userId;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public ResumeTemplateRoot getTemplate() {
        return template;
    }

    public ResumePictureRoot getPicture() {
        return picture;
    }

    public InformationRoot getInformation() {
        return information;
    }

    public PersonalSummaryRoot getPersonalSummary() {
        return personalSummary;
    }

    public SignatureDeclarationRoot getSignatureDeclaration() {
        return signatureDeclaration;
    }

    public List<AwardRoot> getAwards() {
        return awards;
    }

    public List<ContactRoot> getContacts() {
        return contacts;
    }

    public List<CourseRoot> getCourses() {
        return courses;
    }

    public List<CustomPaneRoot> getCustomPanes() {
        return customPanes;
    }

    public List<EducationRoot> getEducations() {
        return educations;
    }

    public List<ExperienceRoot> getExperiences() {
        return experiences;
    }

    public List<InterestRoot> getInterests() {
        return interests;
    }

    public List<ResumeLanguageRoot> getLanguages() {
        return languages;
    }

    public List<OrganizationRoot> getOrganizations() {
        return organizations;
    }

    public List<ProjectRoot> getProjects() {
        return projects;
    }

    public List<PublicationRoot> getPublications() {
        return publications;
    }

    public List<ReferenceRoot> getReferences() {
        return references;
    }

    public List<SkillRoot> getSkills() {
        return skills;
    }

    public static final class Builder {
        private ResumeID resumeID;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private UUID userId;
        private AccessModifier accessModifier;
        private ResumeTemplateRoot template;
        private ResumePictureRoot picture;
        private InformationRoot information;
        private PersonalSummaryRoot personalSummary;
        private SignatureDeclarationRoot signatureDeclaration;
        private List<AwardRoot> awards;
        private List<ContactRoot> contacts;
        private List<CourseRoot> courses;
        private List<CustomPaneRoot> customPanes;
        private List<EducationRoot> educations;
        private List<ExperienceRoot> experiences;
        private List<InterestRoot> interests;
        private List<ResumeLanguageRoot> languages;
        private List<OrganizationRoot> organizations;
        private List<ProjectRoot> projects;
        private List<PublicationRoot> publications;
        private List<ReferenceRoot> references;
        private List<SkillRoot> skills;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder resumeID(ResumeID val) {
            resumeID = val;
            return this;
        }

        public Builder version(Version val) {
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

        public Builder createdDate(ZonedDateTime val) {
            createdDate = val;
            return this;
        }

        public Builder lastModifiedDate(ZonedDateTime val) {
            lastModifiedDate = val;
            return this;
        }

        public Builder userId(UUID val) {
            userId = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder template(ResumeTemplateRoot val) {
            template = val;
            return this;
        }

        public Builder picture(ResumePictureRoot val) {
            picture = val;
            return this;
        }

        public Builder information(InformationRoot val) {
            information = val;
            return this;
        }

        public Builder personalSummary(PersonalSummaryRoot val) {
            personalSummary = val;
            return this;
        }

        public Builder signatureDeclaration(SignatureDeclarationRoot val) {
            signatureDeclaration = val;
            return this;
        }

        public Builder awards(List<AwardRoot> val) {
            awards = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder contacts(List<ContactRoot> val) {
            contacts = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder courses(List<CourseRoot> val) {
            courses = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder customPanes(List<CustomPaneRoot> val) {
            customPanes = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder educations(List<EducationRoot> val) {
            educations = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder experiences(List<ExperienceRoot> val) {
            experiences = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder interests(List<InterestRoot> val) {
            interests = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder languages(List<ResumeLanguageRoot> val) {
            languages = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder organizations(List<OrganizationRoot> val) {
            organizations = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder projects(List<ProjectRoot> val) {
            projects = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder publications(List<PublicationRoot> val) {
            publications = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder references(List<ReferenceRoot> val) {
            references = Builder.this.getNonNullList(val);
            return this;
        }

        public Builder skills(List<SkillRoot> val) {
            skills = Builder.this.getNonNullList(val);
            return this;
        }

        private <T extends AggregateRoot<?>> List<T> getNonNullList(List<T> list) {
            return list == null ? Collections.emptyList() : list;
        }


        public ResumeRoot build() {
            return new ResumeRoot(this);
        }
    }
}
