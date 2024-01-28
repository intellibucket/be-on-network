package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ExperienceID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.UUID;


public class ExperienceRoot extends AggregateRoot<ExperienceID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String employer;
    private String link;
    private String jobTitle;
    private UUID cityId;
    private WorkingType workingType;
    private WorkingTimeLineType workingTimeLine;
    private String description;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;

    private ExperienceRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.employer = builder.employer;
        this.link = builder.link;
        this.jobTitle = builder.jobTitle;
        this.cityId = builder.cityId;
        this.workingType = builder.workingType;
        this.workingTimeLine = builder.workingTimeLine;
        this.description = builder.description;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
    }




    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getEmployer() {
        return employer;
    }

    public String getLink() {
        return link;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public UUID getCityId() {
        return cityId;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public WorkingTimeLineType getWorkingTimeType() {
        return workingTimeLine;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private ExperienceID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private String employer;
        private String link;
        private String jobTitle;
        private UUID cityId;
        private WorkingType workingType;
        private WorkingTimeLineType workingTimeLine;
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

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
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

        public Builder workingTimeType(WorkingTimeLineType val) {
            workingTimeLine = val;
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
