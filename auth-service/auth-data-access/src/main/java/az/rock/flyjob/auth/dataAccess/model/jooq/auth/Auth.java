/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.AccountPlan;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.AccountSettings;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.ActionSettings;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.AuthenticationLogs;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Authorities;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.CoverPictures;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.DetailRole;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Details;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Devices;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Emails;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.GeoPositions;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.NotificationSettings;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Passwords;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.PhoneNumbers;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.ProfilePictures;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.RoleAuthority;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Roles;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.UserSettings;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Users;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Auth extends SchemaImpl {

    private static final long serialVersionUID = -710640680;

    /**
     * The reference instance of <code>auth</code>
     */
    public static final Auth AUTH = new Auth();

    /**
     * The table <code>auth.account_plan</code>.
     */
    public final AccountPlan ACCOUNT_PLAN = AccountPlan.ACCOUNT_PLAN;

    /**
     * The table <code>auth.account_settings</code>.
     */
    public final AccountSettings ACCOUNT_SETTİNGS = AccountSettings.ACCOUNT_SETTİNGS;

    /**
     * The table <code>auth.action_settings</code>.
     */
    public final ActionSettings ACTİON_SETTİNGS = ActionSettings.ACTİON_SETTİNGS;

    /**
     * The table <code>auth.authentication_logs</code>.
     */
    public final AuthenticationLogs AUTHENTİCATİON_LOGS = AuthenticationLogs.AUTHENTİCATİON_LOGS;

    /**
     * The table <code>auth.authorities</code>.
     */
    public final Authorities AUTHORİTİES = Authorities.AUTHORİTİES;

    /**
     * The table <code>auth.cover_pictures</code>.
     */
    public final CoverPictures COVER_PİCTURES = CoverPictures.COVER_PİCTURES;

    /**
     * The table <code>auth.detail_role</code>.
     */
    public final DetailRole DETAİL_ROLE = DetailRole.DETAİL_ROLE;

    /**
     * The table <code>auth.details</code>.
     */
    public final Details DETAİLS = Details.DETAİLS;

    /**
     * The table <code>auth.devices</code>.
     */
    public final Devices DEVİCES = Devices.DEVİCES;

    /**
     * The table <code>auth.emails</code>.
     */
    public final Emails EMAİLS = Emails.EMAİLS;

    /**
     * The table <code>auth.geo_positions</code>.
     */
    public final GeoPositions GEO_POSİTİONS = GeoPositions.GEO_POSİTİONS;

    /**
     * The table <code>auth.notification_settings</code>.
     */
    public final NotificationSettings NOTİFİCATİON_SETTİNGS = NotificationSettings.NOTİFİCATİON_SETTİNGS;

    /**
     * The table <code>auth.passwords</code>.
     */
    public final Passwords PASSWORDS = Passwords.PASSWORDS;

    /**
     * The table <code>auth.phone_numbers</code>.
     */
    public final PhoneNumbers PHONE_NUMBERS = PhoneNumbers.PHONE_NUMBERS;

    /**
     * The table <code>auth.profile_pictures</code>.
     */
    public final ProfilePictures PROFİLE_PİCTURES = ProfilePictures.PROFİLE_PİCTURES;

    /**
     * The table <code>auth.role_authority</code>.
     */
    public final RoleAuthority ROLE_AUTHORİTY = RoleAuthority.ROLE_AUTHORİTY;

    /**
     * The table <code>auth.roles</code>.
     */
    public final Roles ROLES = Roles.ROLES;

    /**
     * The table <code>auth.user_settings</code>.
     */
    public final UserSettings USER_SETTİNGS = UserSettings.USER_SETTİNGS;

    /**
     * The table <code>auth.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Auth() {
        super("auth", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            AccountPlan.ACCOUNT_PLAN,
            AccountSettings.ACCOUNT_SETTİNGS,
            ActionSettings.ACTİON_SETTİNGS,
            AuthenticationLogs.AUTHENTİCATİON_LOGS,
            Authorities.AUTHORİTİES,
            CoverPictures.COVER_PİCTURES,
            DetailRole.DETAİL_ROLE,
            Details.DETAİLS,
            Devices.DEVİCES,
            Emails.EMAİLS,
            GeoPositions.GEO_POSİTİONS,
            NotificationSettings.NOTİFİCATİON_SETTİNGS,
            Passwords.PASSWORDS,
            PhoneNumbers.PHONE_NUMBERS,
            ProfilePictures.PROFİLE_PİCTURES,
            RoleAuthority.ROLE_AUTHORİTY,
            Roles.ROLES,
            UserSettings.USER_SETTİNGS,
            Users.USERS);
    }
}
