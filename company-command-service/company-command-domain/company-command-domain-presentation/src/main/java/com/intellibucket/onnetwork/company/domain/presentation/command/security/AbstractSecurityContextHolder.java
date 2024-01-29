package com.intellibucket.onnetwork.company.domain.presentation.command.security;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.valueObject.Language;
import az.rock.lib.valueObject.Role;
import az.rock.lib.valueObject.UserIdTypePair;
import az.rock.lib.valueObject.UserType;

import java.util.UUID;

public interface AbstractSecurityContextHolder {


    UserID currentUser();

    UserID availableUser();

    CompanyID currentCompany();

    UUID currentUserTypeId();

    default UserIdTypePair currentUserTypePair() {
        return new UserIdTypePair(this.currentUser(), this.currentUserType());
    }

    Language currentLanguage();

    Boolean accountIsNotLocked();

    Role currentRoleName();

    String currentUsername();

    Boolean isAnonymous();

    Boolean isAuthenticated();

    UserType currentUserType();

}
