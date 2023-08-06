package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.EducationID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;
import az.rock.lib.valueObject.js.EducationDegree;
import az.rock.lib.valueObject.js.EducationState;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.UUID;


public class EducationRoot extends AggregateRoot<EducationID> {
    private ResumeID resume;

    private EducationDegree degree;

    private EducationState state;

    private String link;

    private UUID establishmentUUID;

    private String establishmentName;

    private UUID cityId;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private String description;

    private EducationRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        setResume(builder.resume);
        setDegree(builder.degree);
        setState(builder.state);
        setLink(builder.link);
        setEstablishmentUUID(builder.establishmentUUID);
        setEstablishmentName(builder.establishmentName);
        setCityId(builder.cityId);
        setStartDate(builder.startDate);
        setEndDate(builder.endDate);
        setDescription(builder.description);
    }


    public ResumeID getResume() {
        return resume;
    }

    public void setResume(ResumeID resume) {
        this.resume = resume;
    }

    public EducationDegree getDegree() {
        return degree;
    }

    public void setDegree(EducationDegree degree) {
        this.degree = degree;
    }

    public EducationState getState() {
        return state;
    }

    public void setState(EducationState state) {
        this.state = state;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public UUID getEstablishmentUUID() {
        return establishmentUUID;
    }

    public void setEstablishmentUUID(UUID establishmentUUID) {
        this.establishmentUUID = establishmentUUID;
    }

    public String getEstablishmentName() {
        return establishmentName;
    }

    public void setEstablishmentName(String establishmentName) {
        this.establishmentName = establishmentName;
    }

    public UUID getCityId() {
        return cityId;
    }

    public void setCityId(UUID cityId) {
        this.cityId = cityId;
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

    public static final class Builder {
        private EducationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;

        private ResumeID resume;
        private EducationDegree degree;
        private EducationState state;
        private String link;
        private UUID establishmentUUID;
        private String establishmentName;
        private UUID cityId;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(EducationID val) {
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

        public Builder degree(EducationDegree val) {
            degree = val;
            return this;
        }

        public Builder state(EducationState val) {
            state = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder establishmentUUID(UUID val) {
            establishmentUUID = val;
            return this;
        }

        public Builder establishmentName(String val) {
            establishmentName = val;
            return this;
        }

        public Builder cityId(UUID val) {
            cityId = val;
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

        public EducationRoot build() {
            return new EducationRoot(this);
        }
    }
}
