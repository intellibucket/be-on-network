package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.AuthDomainException;
import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.util.GObjects;
import az.rock.lib.util.StringUtils;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.lib.payload.payload.reg.JobSeekerRegistrationPayload;

import java.util.Objects;

public class UserDomainService implements AbstractUserDomainService {

    @Override
    public JobSeekerCreatedEvent validateAndInitializeUser(UserRoot userRoot) {
        return JobSeekerCreatedEvent.of(
                JobSeekerRegistrationPayload.Builder
                        .builder()
                        .userId(userRoot.getRootID().getAbsoluteID())
                        .type(userRoot.getUserType())
                        .firstName(userRoot.getFirstName())
                        .lastName(userRoot.getLastName())
                        .build()
        );
    }

    @Override
    public CompanyCreatedEvent validateAndInitializeCompany(UserRoot userRoot) {
        return CompanyCreatedEvent.of(
                new CompanyRegistrationPayload(
                        userRoot.getRootID().getAbsoluteID(),
                        userRoot.getUserType()) {
                }
        );
    }

    @Override
    public UserRoot changeFirstName(UserRoot currentUserRoot, String firstName) {
        if (StringUtils.isNullOrEmpty(firstName) || firstName.length() < 3)
            throw new AuthDomainException("F0000000024");
        if (currentUserRoot.getFirstName().equalsIgnoreCase(firstName))
            throw new AuthDomainException("F0000000025");
        currentUserRoot.changeFirstName(firstName);
        return currentUserRoot;
    }

    @Override
    public UserRoot changeLastName(UserRoot currentUserRoot, String lastName) {
        if (StringUtils.isNullOrEmpty(lastName) || lastName.length() < 3)
            throw new AuthDomainException("F0000000024");
        if (currentUserRoot.getLastName().equalsIgnoreCase(lastName))
            throw new AuthDomainException("F0000000025");
        currentUserRoot.changeLastName(lastName);
        return currentUserRoot;
    }

    @Override
    public UserRoot changeUsername(UserRoot currentUserRoot, String username) {
        if (StringUtils.isNullOrEmpty(username) || username.length() < 3)
            throw new AuthDomainException("F0000000023");
        if (currentUserRoot.getUsername().equalsIgnoreCase(username))
            throw new AuthDomainException("F0000000022");
        currentUserRoot.changeUsername(username);
        return currentUserRoot;
    }

    @Override
    public UserRoot changeGender(UserRoot currentUserRoot, Gender gender) {
        if (GObjects.isNull(gender)) throw new AuthDomainException("F0000000026");
        if (!Objects.isNull(currentUserRoot.getGender()) && currentUserRoot.getGender().isEquals(gender))
            throw new AuthDomainException("F0000000027");
        currentUserRoot.changeGender(gender);
        return currentUserRoot;
    }

    @Override
    public UserRoot changeTimezone(UserRoot currentUserRoot, TimeZoneID timezone) {
        return currentUserRoot.changeTimezone(timezone);
    }

    @Override
    public UserRoot changeTitle(UserRoot currentUserRoot, String title) {
        return currentUserRoot.changeTitle(title);
    }

    @Override
    public UserRoot changeBiography(UserRoot currentUserRoot, String biography) {
        return currentUserRoot.changeBiography(biography);
    }
}
