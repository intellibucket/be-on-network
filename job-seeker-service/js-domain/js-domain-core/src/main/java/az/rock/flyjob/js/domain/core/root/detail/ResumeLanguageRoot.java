package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.LanguageID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.*;

import java.time.ZonedDateTime;
import java.util.UUID;

public class ResumeLanguageRoot extends AggregateRoot<LanguageID> {
    private ResumeID resume;

    private AccessModifier accessModifier;
    private Integer orderNumber;

    private UUID languageUUID;

    private String additionalInfo;

    private LanguageLevel level;

    private ResumeLanguageRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        this.accessModifier  =builder.accessModifier;
        this.resume = builder.resume;
        this.orderNumber = builder.orderNumber;
        this.languageUUID = builder.languageUUID;
        this.additionalInfo = builder.additionalInfo;
        this.level = builder.level;
    }

    public ResumeID getResume() {
        return resume;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public UUID getLanguageUUID() {
        return languageUUID;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public LanguageLevel getLevel() {
        return level;
    }

    public AccessModifier getAccessModifier() {
        return accessModifier;
    }

    public static final class Builder {
        private LanguageID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private AccessModifier accessModifier;
        private Integer orderNumber;
        private UUID languageUUID;
        private String additionalInfo;
        private LanguageLevel level;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(LanguageID val) {
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

        public Builder languageUUID(UUID val) {
            languageUUID = val;
            return this;
        }

        public Builder additionalInfo(String val) {
            additionalInfo = val;
            return this;
        }

        public Builder level(LanguageLevel val) {
            level = val;
            return this;
        }


        public ResumeLanguageRoot build() {
            return new ResumeLanguageRoot(this);
        }
    }
}
