/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.AccountPlanRecord;

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
public class AccountPlan extends TableImpl<AccountPlanRecord> {

    private static final long serialVersionUID = 1206580749;

    /**
     * The reference instance of <code>auth.account_plan</code>
     */
    public static final AccountPlan ACCOUNT_PLAN = new AccountPlan();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountPlanRecord> getRecordType() {
        return AccountPlanRecord.class;
    }

    /**
     * The column <code>auth.account_plan.uuid</code>.
     */
    public final TableField<AccountPlanRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.version</code>.
     */
    public final TableField<AccountPlanRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.account_plan.process_status</code>.
     */
    public final TableField<AccountPlanRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.row_status</code>.
     */
    public final TableField<AccountPlanRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.created_date</code>.
     */
    public final TableField<AccountPlanRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.modification_date</code>.
     */
    public final TableField<AccountPlanRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.account_plan.user_uuid</code>.
     */
    public final TableField<AccountPlanRecord, UUID> USER_UUİD = createField(DSL.name("user_uuid"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>auth.account_plan.plan</code>.
     */
    public final TableField<AccountPlanRecord, String> PLAN = createField(DSL.name("plan"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>auth.account_plan.start_date</code>.
     */
    public final TableField<AccountPlanRecord, LocalDateTime> START_DATE = createField(DSL.name("start_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.expired_date</code>.
     */
    public final TableField<AccountPlanRecord, LocalDateTime> EXPİRED_DATE = createField(DSL.name("expired_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.account_plan.is_expired</code>.
     */
    public final TableField<AccountPlanRecord, Boolean> İS_EXPİRED = createField(DSL.name("is_expired"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>auth.account_plan.promo_code</code>.
     */
    public final TableField<AccountPlanRecord, String> PROMO_CODE = createField(DSL.name("promo_code"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * Create a <code>auth.account_plan</code> table reference
     */
    public AccountPlan() {
        this(DSL.name("account_plan"), null);
    }

    /**
     * Create an aliased <code>auth.account_plan</code> table reference
     */
    public AccountPlan(String alias) {
        this(DSL.name(alias), ACCOUNT_PLAN);
    }

    /**
     * Create an aliased <code>auth.account_plan</code> table reference
     */
    public AccountPlan(Name alias) {
        this(alias, ACCOUNT_PLAN);
    }

    private AccountPlan(Name alias, Table<AccountPlanRecord> aliased) {
        this(alias, aliased, null);
    }

    private AccountPlan(Name alias, Table<AccountPlanRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> AccountPlan(Table<O> child, ForeignKey<O, AccountPlanRecord> key) {
        super(child, key, ACCOUNT_PLAN);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<AccountPlanRecord> getPrimaryKey() {
        return Keys.PK_ACCOUNT_PLAN;
    }

    @Override
    public List<UniqueKey<AccountPlanRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountPlanRecord>>asList(Keys.PK_ACCOUNT_PLAN);
    }

    @Override
    public List<ForeignKey<AccountPlanRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<AccountPlanRecord, ?>>asList(Keys.ACCOUNT_PLAN__FK_ACCOUNT_PLAN_ON_USER_UUİD);
    }

    public Users users() {
        return new Users(this, Keys.ACCOUNT_PLAN__FK_ACCOUNT_PLAN_ON_USER_UUİD);
    }

    @Override
    public AccountPlan as(String alias) {
        return new AccountPlan(DSL.name(alias), this);
    }

    @Override
    public AccountPlan as(Name alias) {
        return new AccountPlan(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountPlan rename(String name) {
        return new AccountPlan(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountPlan rename(Name name) {
        return new AccountPlan(name, null);
    }

    // -------------------------------------------------------------------------
    // Row12 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row12<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, String, LocalDateTime, LocalDateTime, Boolean, String> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}