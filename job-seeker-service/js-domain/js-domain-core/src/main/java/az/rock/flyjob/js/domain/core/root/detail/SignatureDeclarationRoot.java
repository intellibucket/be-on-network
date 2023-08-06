package az.rock.flyjob.js.domain.core.root.detail;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.SignatureDeclarationID;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

public class SignatureDeclarationRoot extends AggregateRoot<SignatureDeclarationID> {
    private ResumeID resume;

    private byte[] signature;

    private SignatureDeclarationRoot(Builder builder) {
        super(builder.id,builder.version,  builder.processStatus, builder.rowStatus, builder.createdDate, builder.lastModifiedDate);
        resume = builder.resume;
        signature = builder.signature;
    }


    public ResumeID getResume() {
        return resume;
    }

    public byte[] getSignature() {
        return signature;
    }


    public static final class Builder {
        private SignatureDeclarationID id;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime lastModifiedDate;
        private ResumeID resume;
        private byte[] signature;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(SignatureDeclarationID val) {
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

        public Builder signature(byte[] val) {
            signature = val;
            return this;
        }

        public SignatureDeclarationRoot build() {
            return new SignatureDeclarationRoot(this);
        }
    }
}
