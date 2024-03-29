package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;

public interface AbstractUserDomainService {
    JobSeekerCreatedEvent validateAndInitializeUser(UserRoot userRoot);

    CompanyCreatedEvent validateAndInitializeCompany(UserRoot userRoot);

    UserRoot changeFirstName(UserRoot currentUserRoot, String firstName);

    UserRoot changeLastName(UserRoot currentUserRoot, String lastName);

    UserRoot changeUsername(UserRoot currentUserRoot, String username);

    UserRoot changeGender(UserRoot currentUserRoot, Gender gender);

    UserRoot changeTimezone(UserRoot currentUserRoot, TimeZoneID timezone);

    UserRoot changeTitle(UserRoot currentUserRoot, String title);

    UserRoot changeBiography(UserRoot currentUserRoot, String biography);
}
