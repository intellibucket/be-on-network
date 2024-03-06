package az.rock.flyjob.js.dataaccess.model.entity.resume.main;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "informations", schema = "resume")
@Entity(name = "InformationEntity")
public class InformationEntity extends BaseEntity {

    @OneToOne
    private ResumeEntity resume;

    @Column(length = 32, columnDefinition = "varchar(32) default 'AUTHENTICATED'")
    @Enumerated(EnumType.STRING)
    private AccessModifier accessModifier;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToOne(mappedBy = "information")
    private JobTitleInformationEntity jobTitleInformation;

    @Temporal(value = TemporalType.DATE)
    private Timestamp birthDate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "passport")
    private String passport;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "military_service")
    private String militaryService;

    @Column(name = "driving_license")
    private String drivingLicense;

    @OneToMany(mappedBy = "information")
    private List<LinkEntity> links;

    @OneToOne(mappedBy = "information")
    private AddressEntity address;

    public static InformationEntity referenceOf(UUID informationId,UUID resumeId){
        return InformationEntity.Builder
                .builder()
                .accessModifier(AccessModifier.PUBLIC)
                .uuid(informationId)
                .resume(ResumeEntity.referenceOf(resumeId))
                .build();
    }

    private InformationEntity(Builder builder) {
        setResume(builder.resume);
        setAccessModifier(builder.accessModifier);
        setName(builder.name);
        setSurname(builder.surname);
        setGender(builder.gender);
        setJobTitleInformation(builder.jobTitleInformation);
        setBirthDate(builder.birthDate);
        setNationality(builder.nationality);
        setPassport(builder.passport);
        setMaritalStatus(builder.maritalStatus);
        setMilitaryService(builder.militaryService);
        setDrivingLicense(builder.drivingLicense);
        setLinks(builder.links);
        setAddress(builder.address);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }


    public static final class Builder {
        private ResumeEntity resume;
        private AccessModifier accessModifier;
        private String name;
        private String surname;
        private Gender gender;
        private JobTitleInformationEntity jobTitleInformation;
        private Timestamp birthDate;
        private String nationality;
        private String passport;
        private String maritalStatus;
        private String militaryService;
        private String drivingLicense;
        private List<LinkEntity> links;
        private AddressEntity address;
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

        public Builder resume(ResumeEntity val) {
            resume = val;
            return this;
        }

        public Builder accessModifier(AccessModifier val) {
            accessModifier = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder surname(String val) {
            surname = val;
            return this;
        }

        public Builder gender(Gender val) {
            gender = val;
            return this;
        }

        public Builder jobTitleInformation(JobTitleInformationEntity val) {
            jobTitleInformation = val;
            return this;
        }

        public Builder birthDate(Timestamp val) {
            birthDate = val;
            return this;
        }

        public Builder nationality(String val) {
            nationality = val;
            return this;
        }

        public Builder passport(String val) {
            passport = val;
            return this;
        }

        public Builder maritalStatus(String val) {
            maritalStatus = val;
            return this;
        }

        public Builder militaryService(String val) {
            militaryService = val;
            return this;
        }

        public Builder drivingLicense(String val) {
            drivingLicense = val;
            return this;
        }

        public Builder links(List<LinkEntity> val) {
            links = val;
            return this;
        }

        public Builder address(AddressEntity val) {
            address = val;
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

        public InformationEntity build() {
            return new InformationEntity(this);
        }
    }
}
