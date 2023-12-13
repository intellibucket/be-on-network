/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Indexes;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.UsersRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row14;
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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = 1810187074;

    /**
     * The reference instance of <code>auth.users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>auth.users.uuid</code>.
     */
    public final TableField<UsersRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.users.version</code>.
     */
    public final TableField<UsersRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.users.process_status</code>.
     */
    public final TableField<UsersRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.row_status</code>.
     */
    public final TableField<UsersRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.created_date</code>.
     */
    public final TableField<UsersRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.users.modification_date</code>.
     */
    public final TableField<UsersRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.users.access_modifier</code>.
     */
    public final TableField<UsersRecord, String> ACCESS_MODİFİER = createField(DSL.name("access_modifier"), org.jooq.impl.SQLDataType.VARCHAR(32).defaultValue(org.jooq.impl.DSL.field("'PUBLIC'::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>auth.users.user_type</code>.
     */
    public final TableField<UsersRecord, String> USER_TYPE = createField(DSL.name("user_type"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.key</code>.
     */
    public final TableField<UsersRecord, UUID> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.users.first_name</code>.
     */
    public final TableField<UsersRecord, String> FİRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.last_name</code>.
     */
    public final TableField<UsersRecord, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.username</code>.
     */
    public final TableField<UsersRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.timezone</code>.
     */
    public final TableField<UsersRecord, String> TİMEZONE = createField(DSL.name("timezone"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.users.gender</code>.
     */
    public final TableField<UsersRecord, String> GENDER = createField(DSL.name("gender"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>auth.users</code> table reference
     */
    public Users() {
        this(DSL.name("users"), null);
    }

    /**
     * Create an aliased <code>auth.users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>auth.users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Users(Table<O> child, ForeignKey<O, UsersRecord> key) {
        super(child, key, USERS);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes._3fDX_USERS_ROW_STATUS, Indexes._3fDX_USERS_USERTYPE, Indexes.İDX_USERS_USERNAME);
    }

    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.PK_USERS;
    }

    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(Keys.PK_USERS, Keys.UC_USERS_KEY, Keys.UC_USERS_USERNAME);
    }

    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }

    // -------------------------------------------------------------------------
    // Row14 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row14<UUID, Long, String, String, LocalDateTime, LocalDateTime, String, String, UUID, String, String, String, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }
}