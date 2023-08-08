package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.CourseID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;


public class CourseRoot extends AggregateRoot<CourseID> {
    private ResumeID resume;

    private String courseTitle;

    private String institution;

    private Boolean isOnline;

    private String city;

    private String country;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private String description;

    private String certificateFilePath;

    private String verificationAddress;

    private CourseRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        setResume(builder.resume);
        setCourseTitle(builder.courseTitle);
        setInstitution(builder.institution);
        isOnline = builder.isOnline;
        setCity(builder.city);
        setCountry(builder.country);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
        setDescription(builder.description);
        setCertificateFilePath(builder.certificateFilePath);
        setVerificationAddress(builder.verificationAddress);
    }


    public ResumeID getResume() {
        return resume;
    }

    public void setResume(ResumeID resume) {
        this.resume = resume;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath;
    }

    public String getVerificationAddress() {
        return verificationAddress;
    }

    public void setVerificationAddress(String verificationAddress) {
        this.verificationAddress = verificationAddress;
    }

    public static final class Builder {
        private CourseID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
        private String courseTitle;
        private String institution;
        private Boolean isOnline;
        private String city;
        private String country;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private String description;
        private String certificateFilePath;
        private String verificationAddress;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(CourseID val) {
            id = val;
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



        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder courseTitle(String val) {
            courseTitle = val;
            return this;
        }

        public Builder institution(String val) {
            institution = val;
            return this;
        }

        public Builder isOnline(Boolean val) {
            isOnline = val;
            return this;
        }

        public Builder city(String val) {
            city = val;
            return this;
        }

        public Builder country(String val) {
            country = val;
            return this;
        }

        public Builder startDate(ZonedDateTime val) {
            startDate = val;
            return this;
        }

        public Builder endDate(ZonedDateTime val) {
            endDate = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public Builder certificateFilePath(String val) {
            certificateFilePath = val;
            return this;
        }

        public Builder verificationAddress(String val) {
            verificationAddress = val;
            return this;
        }

        public CourseRoot build() {
            return new CourseRoot(this);
        }
    }
}