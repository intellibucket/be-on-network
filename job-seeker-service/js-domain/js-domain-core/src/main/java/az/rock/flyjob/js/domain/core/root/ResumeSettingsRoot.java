package az.rock.flyjob.js.domain.core.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.ResumeSettingsID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.ProcessStatus;
import az.rock.lib.valueObject.RowStatus;
import az.rock.lib.valueObject.Version;

import java.time.ZonedDateTime;

/**
 * Istifadəçinin birdən çox resumesi ola bilər lakin bunlardan yalnız
 * biri nümayiş olunur. Aktiv olan resume bu cədvəldə saxlanılır.
 * Hər bir istifadəçi üçün resume_settings də bir sətr tutulur.
 * 3 cü tərəf tərəfindən resume nin yüklənə bilməsi və sistem tərəfindən resumenin
 * analiz olunub recommend olunması ilə bağlı icazələrdə saxlanılır.
 */
public class ResumeSettingsRoot extends AggregateRoot<ResumeSettingsID> {
    private UserID userID;
    private ResumeID activeResumeID;
    private Boolean accessForDownload;
    private Boolean accessForRecommendation;

    private ResumeSettingsRoot(Builder builder) {
        userID = builder.userID;
        activeResumeID = builder.activeResumeID;
        accessForDownload = builder.accessForDownload;
        accessForRecommendation = builder.accessForRecommendation;
    }

    public UserID getUserID() {
        return userID;
    }

    public Boolean getAccessForDownload() {
        return accessForDownload;
    }

    public Boolean getAccessForRecommendation() {
        return accessForRecommendation;
    }

    public ResumeID getActiveResumeID() {
        return activeResumeID;
    }


    public static final class Builder {
        private ResumeSettingsID resumeSettingsID;
        private Version version;
        private ProcessStatus processStatus;
        private RowStatus rowStatus;
        private ZonedDateTime createdDate;
        private ZonedDateTime modificationDate;
        private UserID userID;
        private ResumeID activeResumeID;
        private Boolean accessForDownload;
        private Boolean accessForRecommendation;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder resumeSettingsID(ResumeSettingsID resumeSettingsID){
            this.resumeSettingsID = resumeSettingsID;
            return this;
        }

        public Builder version(Version version){
            this.version = version;
            return this;
        }

        public Builder processStatus(ProcessStatus processStatus){
            this.processStatus  = processStatus;
            return this;
        }

        public Builder rowStatus(RowStatus rowStatus){
            this.rowStatus = rowStatus;
            return this;
        }

        public Builder createdDate(ZonedDateTime createdDate){
            this.createdDate = createdDate;
            return this;
        }

        public Builder modificationDate(ZonedDateTime modificationDate){
            this.modificationDate = modificationDate;
            return this;
        }

        public Builder userID(UserID val) {
            userID = val;
            return this;
        }

        public Builder activeResumeID(ResumeID val) {
            activeResumeID = val;
            return this;
        }

        public Builder accessForDownload(Boolean val) {
            accessForDownload = val;
            return this;
        }

        public Builder accessForRecommendation(Boolean val) {
            accessForRecommendation = val;
            return this;
        }

        public ResumeSettingsRoot build() {
            return new ResumeSettingsRoot(this);
        }
    }
}
