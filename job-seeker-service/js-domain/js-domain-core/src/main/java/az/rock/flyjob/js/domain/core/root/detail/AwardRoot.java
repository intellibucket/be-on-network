package az.rock.flyjob.js.domain.core.root.detail;


import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;


public class AwardRoot extends AggregateRoot<AwardID> {
    private ResumeID resume;

    private String award;

    private String link;

    private String issuer;

    private ZonedDateTime date;

    private String description;

    private AwardRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        setResume(builder.resume);
        setAward(builder.award);
        setLink(builder.link);
        setIssuer(builder.issuer);
        setDate(builder.date);
        setDescription(builder.description);
    }


    public ResumeID getResume() {
        return resume;
    }

    public void setResume(ResumeID resume) {
        this.resume = resume;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static final class Builder {
        private AwardID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;
        private String award;
        private String link;
        private String issuer;
        private ZonedDateTime date;
        private String description;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(AwardID val) {
            id = val;
            return this;
        }

        public Builder rowStatus(RowStatus val) {
            rowStatus = val;
            return this;
        }

        public Builder processStatus(ProcessStatus val) {
            processStatus = val;
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

        public Builder version(Version val) {
            version = val;
            return this;
        }

        public Builder resume(ResumeID val) {
            resume = val;
            return this;
        }

        public Builder award(String val) {
            award = val;
            return this;
        }

        public Builder link(String val) {
            link = val;
            return this;
        }

        public Builder issuer(String val) {
            issuer = val;
            return this;
        }

        public Builder date(ZonedDateTime val) {
            date = val;
            return this;
        }

        public Builder description(String val) {
            description = val;
            return this;
        }

        public AwardRoot build() {
            return new AwardRoot(this);
        }
    }
}
