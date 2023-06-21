package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import az.rock.flyjob.auth.exception.AuthDomainException;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.util.GObjects;
import az.rock.lib.util.StringUtils;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;

public class UserDomainService implements AbstractUserDomainService {

    @Override
    public JobSeekerCreatedEvent validateAndInitializeUser(UserRoot userRoot) {
        return JobSeekerCreatedEvent.of(userRoot);
    }

    @Override
    public CompanyCreatedEvent validateAndInitializeCompany(UserRoot userRoot) {
        return CompanyCreatedEvent.of(userRoot);
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
        if (currentUserRoot.getGender().isEquals(gender)) throw new AuthDomainException("F0000000027");
        currentUserRoot.changeGender(gender);
        return currentUserRoot;
    }

    @Override
    public UserRoot changeTimezone(UserRoot currentUserRoot, TimeZoneID timezone) {
        return null;
    }
}
