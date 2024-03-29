/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Roles;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesRecord extends UpdatableRecordImpl<RolesRecord> implements Record8<UUID, Long, String, String, LocalDateTime, LocalDateTime, String, String> {

    private static final long serialVersionUID = 1177119714;

    /**
     * Setter for <code>auth.roles.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>auth.roles.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>auth.roles.version</code>.
     */
    public void setVersion(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>auth.roles.version</code>.
     */
    public Long getVersion() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>auth.roles.process_status</code>.
     */
    public void setProcessStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>auth.roles.process_status</code>.
     */
    public String getProcessStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>auth.roles.row_status</code>.
     */
    public void setRowStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>auth.roles.row_status</code>.
     */
    public String getRowStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>auth.roles.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>auth.roles.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>auth.roles.modification_date</code>.
     */
    public void setModificationDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>auth.roles.modification_date</code>.
     */
    public LocalDateTime getModificationDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>auth.roles.name</code>.
     */
    public void setName(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>auth.roles.name</code>.
     */
    public String getName() {
        return (String) get(6);
    }

    /**
     * Setter for <code>auth.roles.description</code>.
     */
    public void setDescription(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>auth.roles.description</code>.
     */
    public String getDescription() {
        return (String) get(7);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record8 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row8<UUID, Long, String, String, LocalDateTime, LocalDateTime, String, String> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    @Override
    public Row8<UUID, Long, String, String, LocalDateTime, LocalDateTime, String, String> valuesRow() {
        return (Row8) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Roles.ROLES.UUİD;
    }

    @Override
    public Field<Long> field2() {
        return Roles.ROLES.VERSİON;
    }

    @Override
    public Field<String> field3() {
        return Roles.ROLES.PROCESS_STATUS;
    }

    @Override
    public Field<String> field4() {
        return Roles.ROLES.ROW_STATUS;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Roles.ROLES.CREATED_DATE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Roles.ROLES.MODİFİCATİON_DATE;
    }

    @Override
    public Field<String> field7() {
        return Roles.ROLES.NAME;
    }

    @Override
    public Field<String> field8() {
        return Roles.ROLES.DESCRİPTİON;
    }

    @Override
    public UUID component1() {
        return getUuid();
    }

    @Override
    public Long component2() {
        return getVersion();
    }

    @Override
    public String component3() {
        return getProcessStatus();
    }

    @Override
    public String component4() {
        return getRowStatus();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedDate();
    }

    @Override
    public LocalDateTime component6() {
        return getModificationDate();
    }

    @Override
    public String component7() {
        return getName();
    }

    @Override
    public String component8() {
        return getDescription();
    }

    @Override
    public UUID value1() {
        return getUuid();
    }

    @Override
    public Long value2() {
        return getVersion();
    }

    @Override
    public String value3() {
        return getProcessStatus();
    }

    @Override
    public String value4() {
        return getRowStatus();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedDate();
    }

    @Override
    public LocalDateTime value6() {
        return getModificationDate();
    }

    @Override
    public String value7() {
        return getName();
    }

    @Override
    public String value8() {
        return getDescription();
    }

    @Override
    public RolesRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public RolesRecord value2(Long value) {
        setVersion(value);
        return this;
    }

    @Override
    public RolesRecord value3(String value) {
        setProcessStatus(value);
        return this;
    }

    @Override
    public RolesRecord value4(String value) {
        setRowStatus(value);
        return this;
    }

    @Override
    public RolesRecord value5(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public RolesRecord value6(LocalDateTime value) {
        setModificationDate(value);
        return this;
    }

    @Override
    public RolesRecord value7(String value) {
        setName(value);
        return this;
    }

    @Override
    public RolesRecord value8(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public RolesRecord values(UUID value1, Long value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6, String value7, String value8) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RolesRecord
     */
    public RolesRecord() {
        super(Roles.ROLES);
    }

    /**
     * Create a detached, initialised RolesRecord
     */
    public RolesRecord(UUID uuid, Long version, String processStatus, String rowStatus, LocalDateTime createdDate, LocalDateTime modificationDate, String name, String description) {
        super(Roles.ROLES);

        set(0, uuid);
        set(1, version);
        set(2, processStatus);
        set(3, rowStatus);
        set(4, createdDate);
        set(5, modificationDate);
        set(6, name);
        set(7, description);
    }
}
