/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.PasswordsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
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
public class Passwords extends TableImpl<PasswordsRecord> {

    private static final long serialVersionUID = 1285171169;

    /**
     * The reference instance of <code>auth.passwords</code>
     */
    public static final Passwords PASSWORDS = new Passwords();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PasswordsRecord> getRecordType() {
        return PasswordsRecord.class;
    }

    /**
     * The column <code>auth.passwords.uuid</code>.
     */
    public final TableField<PasswordsRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.passwords.version</code>.
     */
    public final TableField<PasswordsRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.passwords.process_status</code>.
     */
    public final TableField<PasswordsRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.passwords.row_status</code>.
     */
    public final TableField<PasswordsRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.passwords.created_date</code>.
     */
    public final TableField<PasswordsRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.passwords.modification_date</code>.
     */
    public final TableField<PasswordsRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.passwords.user_uuid</code>.
     */
    public final TableField<PasswordsRecord, UUID> USER_UUİD = createField(DSL.name("user_uuid"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>auth.passwords.salt</code>.
     */
    public final TableField<PasswordsRecord, String> SALT = createField(DSL.name("salt"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.passwords.hash</code>.
     */
    public final TableField<PasswordsRecord, String> HASH = createField(DSL.name("hash"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>auth.passwords</code> table reference
     */
    public Passwords() {
        this(DSL.name("passwords"), null);
    }

    /**
     * Create an aliased <code>auth.passwords</code> table reference
     */
    public Passwords(String alias) {
        this(DSL.name(alias), PASSWORDS);
    }

    /**
     * Create an aliased <code>auth.passwords</code> table reference
     */
    public Passwords(Name alias) {
        this(alias, PASSWORDS);
    }

    private Passwords(Name alias, Table<PasswordsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Passwords(Name alias, Table<PasswordsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Passwords(Table<O> child, ForeignKey<O, PasswordsRecord> key) {
        super(child, key, PASSWORDS);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<PasswordsRecord> getPrimaryKey() {
        return Keys.PK_PASSWORDS;
    }

    @Override
    public List<UniqueKey<PasswordsRecord>> getKeys() {
        return Arrays.<UniqueKey<PasswordsRecord>>asList(Keys.PK_PASSWORDS);
    }

    @Override
    public List<ForeignKey<PasswordsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PasswordsRecord, ?>>asList(Keys.PASSWORDS__FK_PASSWORDS_ON_USER_UUİD);
    }

    public Users users() {
        return new Users(this, Keys.PASSWORDS__FK_PASSWORDS_ON_USER_UUİD);
    }

    @Override
    public Passwords as(String alias) {
        return new Passwords(DSL.name(alias), this);
    }

    @Override
    public Passwords as(Name alias) {
        return new Passwords(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Passwords rename(String name) {
        return new Passwords(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Passwords rename(Name name) {
        return new Passwords(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, String, String> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
