package az.rock.flyjob.auth.dataAccess.model.entity.user;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.common.HashtagColor;
import az.rock.lib.valueObject.common.National;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "profile_hashtags", schema = "auth")
@Entity(name = "ProfileHashtag")
public class ProfileHashtag extends BaseEntity {

    @Column(name = "user_uuid", nullable = false, updatable = false)
    private UUID userUuid;

    @Column(name = "hashtag", nullable = false, updatable = false)
    private String hashtag;

    @Column(name = "description")
    private String description;

    @Column(name = "color", columnDefinition = "varchar(64) default 'BLACK'")
    private HashtagColor color;

    @Column(name = "order", columnDefinition = "int default 0")
    private Integer order;

    @Column(name = "national", columnDefinition = "varchar(64) default 'EN'")
    private National national;
}
