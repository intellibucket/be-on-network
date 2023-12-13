/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Auth;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.Keys;
import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records.PhoneNumbersRecord;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row19;
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
public class PhoneNumbers extends TableImpl<PhoneNumbersRecord> {

    private static final long serialVersionUID = -1713101146;

    /**
     * The reference instance of <code>auth.phone_numbers</code>
     */
    public static final PhoneNumbers PHONE_NUMBERS = new PhoneNumbers();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PhoneNumbersRecord> getRecordType() {
        return PhoneNumbersRecord.class;
    }

    /**
     * The column <code>auth.phone_numbers.uuid</code>.
     */
    public final TableField<PhoneNumbersRecord, UUID> UUİD = createField(DSL.name("uuid"), org.jooq.impl.SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.version</code>.
     */
    public final TableField<PhoneNumbersRecord, Long> VERSİON = createField(DSL.name("version"), org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>auth.phone_numbers.process_status</code>.
     */
    public final TableField<PhoneNumbersRecord, String> PROCESS_STATUS = createField(DSL.name("process_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.row_status</code>.
     */
    public final TableField<PhoneNumbersRecord, String> ROW_STATUS = createField(DSL.name("row_status"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.created_date</code>.
     */
    public final TableField<PhoneNumbersRecord, LocalDateTime> CREATED_DATE = createField(DSL.name("created_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.modification_date</code>.
     */
    public final TableField<PhoneNumbersRecord, LocalDateTime> MODİFİCATİON_DATE = createField(DSL.name("modification_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.phone_numbers.access_modifier</code>.
     */
    public final TableField<PhoneNumbersRecord, String> ACCESS_MODİFİER = createField(DSL.name("access_modifier"), org.jooq.impl.SQLDataType.VARCHAR(32).defaultValue(org.jooq.impl.DSL.field("'ONLY_AUTHENTICATED'::character varying", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>auth.phone_numbers.user_uuid</code>.
     */
    public final TableField<PhoneNumbersRecord, UUID> USER_UUİD = createField(DSL.name("user_uuid"), org.jooq.impl.SQLDataType.UUID, this, "");

    /**
     * The column <code>auth.phone_numbers.country_code</code>.
     */
    public final TableField<PhoneNumbersRecord, String> COUNTRY_CODE = createField(DSL.name("country_code"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.phone_number</code>.
     */
    public final TableField<PhoneNumbersRecord, String> PHONE_NUMBER = createField(DSL.name("phone_number"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>auth.phone_numbers.type</code>.
     */
    public final TableField<PhoneNumbersRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>auth.phone_numbers.is_enable_sms_notification</code>.
     */
    public final TableField<PhoneNumbersRecord, Boolean> İS_ENABLE_SMS_NOTİFİCATİON = createField(DSL.name("is_enable_sms_notification"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>auth.phone_numbers.is_enable_whatsapp_notification</code>.
     */
    public final TableField<PhoneNumbersRecord, Boolean> İS_ENABLE_WHATSAPP_NOTİFİCATİON = createField(DSL.name("is_enable_whatsapp_notification"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>auth.phone_numbers.is_primary</code>.
     */
    public final TableField<PhoneNumbersRecord, Boolean> İS_PRİMARY = createField(DSL.name("is_primary"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>auth.phone_numbers.is_verified</code>.
     */
    public final TableField<PhoneNumbersRecord, Boolean> İS_VERİFİED = createField(DSL.name("is_verified"), org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>auth.phone_numbers.verification_code</code>.
     */
    public final TableField<PhoneNumbersRecord, String> VERİFİCATİON_CODE = createField(DSL.name("verification_code"), org.jooq.impl.SQLDataType.VARCHAR(6), this, "");

    /**
     * The column <code>auth.phone_numbers.verification_code_expire_date</code>.
     */
    public final TableField<PhoneNumbersRecord, LocalDateTime> VERİFİCATİON_CODE_EXPİRE_DATE = createField(DSL.name("verification_code_expire_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.phone_numbers.verification_code_send_date</code>.
     */
    public final TableField<PhoneNumbersRecord, LocalDateTime> VERİFİCATİON_CODE_SEND_DATE = createField(DSL.name("verification_code_send_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * The column <code>auth.phone_numbers.verification_code_send_count</code>.
     */
    public final TableField<PhoneNumbersRecord, BigDecimal> VERİFİCATİON_CODE_SEND_COUNT = createField(DSL.name("verification_code_send_count"), org.jooq.impl.SQLDataType.NUMERIC, this, "");

    /**
     * Create a <code>auth.phone_numbers</code> table reference
     */
    public PhoneNumbers() {
        this(DSL.name("phone_numbers"), null);
    }

    /**
     * Create an aliased <code>auth.phone_numbers</code> table reference
     */
    public PhoneNumbers(String alias) {
        this(DSL.name(alias), PHONE_NUMBERS);
    }

    /**
     * Create an aliased <code>auth.phone_numbers</code> table reference
     */
    public PhoneNumbers(Name alias) {
        this(alias, PHONE_NUMBERS);
    }

    private PhoneNumbers(Name alias, Table<PhoneNumbersRecord> aliased) {
        this(alias, aliased, null);
    }

    private PhoneNumbers(Name alias, Table<PhoneNumbersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> PhoneNumbers(Table<O> child, ForeignKey<O, PhoneNumbersRecord> key) {
        super(child, key, PHONE_NUMBERS);
    }

    @Override
    public Schema getSchema() {
        return Auth.AUTH;
    }

    @Override
    public UniqueKey<PhoneNumbersRecord> getPrimaryKey() {
        return Keys.PK_PHONE_NUMBERS;
    }

    @Override
    public List<UniqueKey<PhoneNumbersRecord>> getKeys() {
        return Arrays.<UniqueKey<PhoneNumbersRecord>>asList(Keys.PK_PHONE_NUMBERS);
    }

    @Override
    public List<ForeignKey<PhoneNumbersRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PhoneNumbersRecord, ?>>asList(Keys.PHONE_NUMBERS__FK_PHONE_NUMBERS_ON_USER_UUİD);
    }

    public Users users() {
        return new Users(this, Keys.PHONE_NUMBERS__FK_PHONE_NUMBERS_ON_USER_UUİD);
    }

    @Override
    public PhoneNumbers as(String alias) {
        return new PhoneNumbers(DSL.name(alias), this);
    }

    @Override
    public PhoneNumbers as(Name alias) {
        return new PhoneNumbers(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PhoneNumbers rename(String name) {
        return new PhoneNumbers(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PhoneNumbers rename(Name name) {
        return new PhoneNumbers(name, null);
    }

    // -------------------------------------------------------------------------
    // Row19 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row19<UUID, Long, String, String, LocalDateTime, LocalDateTime, String, UUID, String, String, String, Boolean, Boolean, Boolean, Boolean, String, LocalDateTime, LocalDateTime, BigDecimal> fieldsRow() {
        return (Row19) super.fieldsRow();
    }
}