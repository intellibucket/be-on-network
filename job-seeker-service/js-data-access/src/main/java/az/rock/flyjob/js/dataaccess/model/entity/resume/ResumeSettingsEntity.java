package az.rock.flyjob.js.dataaccess.model.entity.resume;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_settings", schema = "resume", indexes = {
        @Index(name = "idx_resumesettingsentity", columnList = "user_id")
})
@Entity(name = "ResumeSettingsEntity")
public class ResumeSettingsEntity extends BaseEntity {
    @Column(name = "user_id",nullable = false,updatable = false)
    private UUID userID;
    @Column(name = "active_resume_id",nullable = false)
    private UUID activeResumeID;
    @Column(name = "access_for_download")
    private Boolean accessForDownload;
    @Column(name = "access_for_recommendation")
    private Boolean accessForRecommendation;
}
