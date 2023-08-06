package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.UUID;


public class ExperienceRoot extends AggregateRoot<ExperienceID> {
    private ResumeID resume;

    private String employer;

    private String link;

    private String jobTitle;

    private UUID cityId;

    private WorkingType workingType;

    private WorkingTimeType workingTimeType;

    private String description;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private ExperienceRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        setResume(builder.resume);
        setEmployer(builder.employer);
        setLink(builder.link);
        setJobTitle(builder.jobTitle);
        setCityId(builder.cityId);
        setWorkingType(builder.workingType);
        setWorkingTimeType(builder.workingTimeType);
        setDescription(builder.description);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
    }


    public ResumeID getResume() {
        return resume;
    }

    public void setResume(ResumeID resume) {
        this.resume = resume;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public UUID getCityId() {
        return cityId;
    }

    public void setCityId(UUID cityId) {
        this.cityId = cityId;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }

    public WorkingTimeType getWorkingTimeType() {
        return workingTimeType;
    }

    public void setWorkingTimeType(WorkingTimeType workingTimeType) {
        this.workingTimeType = workingTimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public static final class Builder {
        private ExperienceID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
        private String employer;
        private String link;
        private String jobTitle;
        private UUID cityId;
        private WorkingType workingType;
        private WorkingTimeType workingTimeType;
        private String description;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(ExperienceID val) {
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

        public Builder employer(String val) {
            employer = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder jobTitle(String val) {
            jobTitle = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
            return this;
        }

        public Builder workingType(WorkingType val) {
            workingType = val;
            return this;
        }

        public Builder workingTimeType(WorkingTimeType val) {
            workingTimeType = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
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

        public ExperienceRoot build() {
            return new ExperienceRoot(this);
        }
    }
}
