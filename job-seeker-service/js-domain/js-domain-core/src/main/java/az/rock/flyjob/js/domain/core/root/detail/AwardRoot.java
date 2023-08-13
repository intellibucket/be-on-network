package az.rock.flyjob.js.domain.core.root.detail;


import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.AwardID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;


public class AwardRoot extends AggregateRoot<AwardID> {
    private ResumeID resume;
    private AccessModifier accessModifier;
    private Integer orderNumber;
    private String award;
    private String link;
    private String issuer;
    private ZonedDateTime date;
    private String description;

    private AwardRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier = builder.accessModifier;
        this.resume = builder.resume;
        this.award = builder.award;
        this.link = builder.link;
        this.issuer = builder.issuer;
        this.date = builder.date;
        this.description = builder.description;
        this.orderNumber = builder.orderNumber;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public String getAward() {
        return award;
    }

    public String getLink() {
        return link;
    }

    public String getIssuer() {
        return issuer;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private AwardID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;


        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
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

        public Builder accessModifier(AccessModifier accessModifier){
            this.accessModifier = accessModifier;
            return this;
        }

        public Builder orderNumber(Integer val) {
            orderNumber = val;
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
