/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.AccountSettingsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row12;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountSettings extends TableImpl<AccountSettingsRecord> {

    private static final long serialVersionUID = -458535788;

    /**
     * The reference instance of <code>auth.account_settings</code>
     */
    public static final AccountSettings ACCOUNT_SETTİNGS = new AccountSettings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountSettingsRecord> getRecordType() {
        return AccountSettingsRecord.class;
    }

    /**
     * The column <code>auth.account_settings.uuid</code>.
     */
    public final TableField<AccountSettingsRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.version</code>.
     */
    public final TableField<AccountSettingsRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.account_settings.process_status</code>.
     */
    public final TableField<AccountSettingsRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.row_status</code>.
     */
    public final TableField<AccountSettingsRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.created_date</code>.
     */
    public final TableField<AccountSettingsRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.modification_date</code>.
     */
    public final TableField<AccountSettingsRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.account_settings.user_uuid</code>.
     */
    public final TableField<AccountSettingsRecord, UUID> USER_UUİD = createField(DSL.name("user_uuid"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>auth.account_settings.is_possible_to_find_me_by_email</code>.
     */
    public final TableField<AccountSettingsRecord, Boolean> İS_POSSİBLE_TO_FİND_ME_BY_EMAİL = createField(DSL.name("is_possible_to_find_me_by_email"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.is_possible_to_find_me_by_phone_number</code>.
     */
    public final TableField<AccountSettingsRecord, Boolean> İS_POSSİBLE_TO_FİND_ME_BY_PHONE_NUMBER = createField(DSL.name("is_possible_to_find_me_by_phone_number"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.is_possible_to_find_me_by_user_name</code>.
     */
    public final TableField<AccountSettingsRecord, Boolean> İS_POSSİBLE_TO_FİND_ME_BY_USER_NAME = createField(DSL.name("is_possible_to_find_me_by_user_name"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.is_possible_to_find_me_by_full_name</code>.
     */
    public final TableField<AccountSettingsRecord, Boolean> İS_POSSİBLE_TO_FİND_ME_BY_FULL_NAME = createField(DSL.name("is_possible_to_find_me_by_full_name"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>auth.account_settings.is_possible_to_find_me_by_location</code>.
     */
    public final TableField<AccountSettingsRecord, Boolean> İS_POSSİBLE_TO_FİND_ME_BY_LOCATİON = createField(DSL.name("is_possible_to_find_me_by_location"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>auth.account_settings</code> table reference
     */
    public AccountSettings() {
        this(DSL.name("account_settings"), null);
    }

    /**
     * Create an aliased <code>auth.account_settings</code> table reference
     */
    public AccountSettings(String alias) {
        this(DSL.name(alias), ACCOUNT_SETTİNGS);
    }

    /**
     * Create an aliased <code>auth.account_settings</code> table reference
     */
    public AccountSettings(Name alias) {
        this(alias, ACCOUNT_SETTİNGS);
    }

    private AccountSettings(Name alias, Table<AccountSettingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private AccountSettings(Name alias, Table<AccountSettingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> AccountSettings(Table<O> child, ForeignKey<O, AccountSettingsRecord> key) {
        super(child, key, ACCOUNT_SETTİNGS);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<AccountSettingsRecord> getPrimaryKey() {
        return Keys.PK_ACCOUNT_SETTİNGS;
    }

    @Override
    public List<UniqueKey<AccountSettingsRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountSettingsRecord>>asList(Keys.PK_ACCOUNT_SETTİNGS);
    }

    @Override
    public List<ForeignKey<AccountSettingsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AccountSettingsRecord, ?>>asList(Keys.ACCOUNT_SETTİNGS__FK_ACCOUNT_SETTİNGS_ON_USER_UUİD);
    }

    public Users users() {
        return new Users(this, Keys.ACCOUNT_SETTİNGS__FK_ACCOUNT_SETTİNGS_ON_USER_UUİD);
    }

    @Override
    public AccountSettings as(String alias) {
        return new AccountSettings(DSL.name(alias), this);
    }

    @Override
    public AccountSettings as(Name alias) {
        return new AccountSettings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountSettings rename(String name) {
        return new AccountSettings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountSettings rename(Name name) {
        return new AccountSettings(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, Boolean, Boolean, Boolean, Boolean, Boolean> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}