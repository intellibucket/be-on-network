package az.rock.flyjob.js.domain.core.root.template;

import az.rock.flyjob.model.entity.resume.ResumeEntity;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.js.ResumeTemplateType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_templates", schema = "resume")
@Entity(name = "ResumeTemplateEntity")
public class ResumeTemplateEntity extends BaseEntity {
    @OneToOne
    private ResumeEntity resume;

    @Enumerated(EnumType.STRING)
    private ResumeTemplateType resumeTemplateType;

    private ResumeTemplateEntity(Builder builder) {
        setResume(builder.resume);
        setResumeTemplateType(builder.resumeTemplateType);
        setUuid(builder.uuid);
        setVersion(builder.version);
        setProcessStatus(builder.processStatus);
        setRowStatus(builder.rowStatus);
        setCreatedDate(builder.createdDate);
        setLastModifiedDate(builder.lastModifiedDate);
    }

    public static class Prototype{

        public static ResumeTemplateEntity defaultTemplate(ResumeEntity resume){
            return Builder.builder()
                    .uuid(UUID.randomUUID())
                    .processStatus(ProcessStatus.COMPLETED)
                    .rowStatus(RowStatus.ACTIVE)
                    .version(1L)
                    .resume(resume)
                    .resumeTemplateType(ResumeTemplateType.CLASSIC)
                    .build();
        }

    }


    public static final class Builder {
        private ResumeEntity resume;
        private ResumeTemplateType resumeTemplateType;
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

        public Builder resumeTemplateType(ResumeTemplateType val) {
            resumeTemplateType = val;
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

        public ResumeTemplateEntity build() {
            return new ResumeTemplateEntity(this);
        }
    }
}
