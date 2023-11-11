package az.rock.auth.domain.presentation.dto.response.user;

import az.rock.flyjob.auth.model.query.UserProfileQueryRecord;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.UserType;
import lombok.Getter;

import java.math.BigInteger;

@Getter
public class MyUserProfileResponse {
    private String firstName;
    private String lastName;
    private String username;
    private String title;
    private String biography;
    private Gender gender;
    private UserType userType;
    private String timezone;
    private BigInteger followCount;
    private BigInteger networkCount;

    public static MyUserProfileResponse of(UserProfileQueryRecord record) {
        return Builder
                .builder()
                .firstName(record.getFirstName())
                .lastName(record.getLastName())
                .username(record.getUsername())
                .title(record.getTitle())
                .biography(record.getBiography())
                .gender(record.getGender())
                .userType(record.getUserType())
                .timezone(record.getTimezone())
                .followCount(record.getFollowCount())
                .networkCount(record.getNetworkCount())
                .build();
    }


    public static final class Builder {
        private String firstName;
        private String lastName;
        private String username;
        private String title;
        private String biography;
        private Gender gender;
        private UserType userType;
        private String timezone;
        private BigInteger followCount;
        private BigInteger networkCount;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder biography(String biography) {
            this.biography = biography;
            return this;
        }

        public Builder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder userType(UserType userType) {
            this.userType = userType;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder followCount(BigInteger followCount) {
            this.followCount = followCount;
            return this;
        }

        public Builder networkCount(BigInteger networkCount) {
            this.networkCount = networkCount;
            return this;
        }

        public MyUserProfileResponse build() {
            MyUserProfileResponse myUserProfileResponse = new MyUserProfileResponse();
            myUserProfileResponse.title = this.title;
            myUserProfileResponse.biography = this.biography;
            myUserProfileResponse.firstName = this.firstName;
            myUserProfileResponse.followCount = this.followCount;
            myUserProfileResponse.gender = this.gender;
            myUserProfileResponse.networkCount = this.networkCount;
            myUserProfileResponse.userType = this.userType;
            myUserProfileResponse.lastName = this.lastName;
            myUserProfileResponse.timezone = this.timezone;
            myUserProfileResponse.username = this.username;
            return myUserProfileResponse;
        }
    }
}
