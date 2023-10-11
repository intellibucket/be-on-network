package az.rock.flyjob.auth.dataAccess.model.entity.user.settings;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_settings", schema = "auth")
@Entity(name = "AccountSettings")
public class AccountSettings extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @Column(name = "is_possible_to_find_me_by_email", nullable = false)
    private Boolean isPossibleToFindMeByEmail;

    @Column(name = "is_possible_to_find_me_by_phone_number", nullable = false)
    private Boolean isPossibleToFindMeByPhoneNumber;

    @Column(name = "is_possible_to_find_me_by_user_name", nullable = false)
    private Boolean isPossibleToFindMeByUserName;

    @Column(name = "is_possible_to_find_me_by_full_name", nullable = false)
    private Boolean isPossibleToFindMeByFullName;

    @Column(name = "is_possible_to_find_me_by_location", nullable = false)
    private Boolean isPossibleToFindMeByLocation;

}
