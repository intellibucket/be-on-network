/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.AuthenticationLogsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
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
public class AuthenticationLogs extends TableImpl<AuthenticationLogsRecord> {

    private static final long serialVersionUID = -583674953;

    /**
     * The reference instance of <code>auth.authentication_logs</code>
     */
    public static final AuthenticationLogs AUTHENTİCATİON_LOGS = new AuthenticationLogs();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthenticationLogsRecord> getRecordType() {
        return AuthenticationLogsRecord.class;
    }

    /**
     * The column <code>auth.authentication_logs.uuid</code>.
     */
    public final TableField<AuthenticationLogsRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.authentication_logs.version</code>.
     */
    public final TableField<AuthenticationLogsRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.authentication_logs.process_status</code>.
     */
    public final TableField<AuthenticationLogsRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.authentication_logs.row_status</code>.
     */
    public final TableField<AuthenticationLogsRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.authentication_logs.created_date</code>.
     */
    public final TableField<AuthenticationLogsRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.authentication_logs.modification_date</code>.
     */
    public final TableField<AuthenticationLogsRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.authentication_logs.device_uuid</code>.
     */
    public final TableField<AuthenticationLogsRecord, UUID> DEVİCE_UUİD = createField(DSL.name("device_uuid"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>auth.authentication_logs.device_token</code>.
     */
    public final TableField<AuthenticationLogsRecord, UUID> DEVİCE_TOKEN = createField(DSL.name("device_token"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * Create a <code>auth.authentication_logs</code> table reference
     */
    public AuthenticationLogs() {
        this(DSL.name("authentication_logs"), null);
    }

    /**
     * Create an aliased <code>auth.authentication_logs</code> table reference
     */
    public AuthenticationLogs(String alias) {
        this(DSL.name(alias), AUTHENTİCATİON_LOGS);
    }

    /**
     * Create an aliased <code>auth.authentication_logs</code> table reference
     */
    public AuthenticationLogs(Name alias) {
        this(alias, AUTHENTİCATİON_LOGS);
    }

    private AuthenticationLogs(Name alias, Table<AuthenticationLogsRecord> aliased) {
        this(alias, aliased, null);
    }

    private AuthenticationLogs(Name alias, Table<AuthenticationLogsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> AuthenticationLogs(Table<O> child, ForeignKey<O, AuthenticationLogsRecord> key) {
        super(child, key, AUTHENTİCATİON_LOGS);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<AuthenticationLogsRecord> getPrimaryKey() {
        return Keys.PK_AUTHENTİCATİON_LOGS;
    }

    @Override
    public List<UniqueKey<AuthenticationLogsRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthenticationLogsRecord>>asList(Keys.PK_AUTHENTİCATİON_LOGS);
    }

    @Override
    public List<ForeignKey<AuthenticationLogsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AuthenticationLogsRecord, ?>>asList(Keys.AUTHENTİCATİON_LOGS__FK_AUTHENTİCATİON_LOGS_ON_DEVİCE_UUİD);
    }

    public Devices devices() {
        return new Devices(this, Keys.AUTHENTİCATİON_LOGS__FK_AUTHENTİCATİON_LOGS_ON_DEVİCE_UUİD);
    }

    @Override
    public AuthenticationLogs as(String alias) {
        return new AuthenticationLogs(DSL.name(alias), this);
    }

    @Override
    public AuthenticationLogs as(Name alias) {
        return new AuthenticationLogs(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthenticationLogs rename(String name) {
        return new AuthenticationLogs(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AuthenticationLogs rename(Name name) {
        return new AuthenticationLogs(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, UUID> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}