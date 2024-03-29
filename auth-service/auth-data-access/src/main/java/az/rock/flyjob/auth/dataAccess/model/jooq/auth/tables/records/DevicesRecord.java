/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.Devices;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record22;
import org.jooq.Row22;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DevicesRecord extends UpdatableRecordImpl<DevicesRecord> implements Record22<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime, BigDecimal, Boolean, Boolean> {

    private static final long serialVersionUID = -1047439311;

    /**
     * Setter for <code>auth.devices.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>auth.devices.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>auth.devices.version</code>.
     */
    public void setVersion(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>auth.devices.version</code>.
     */
    public Long getVersion() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>auth.devices.process_status</code>.
     */
    public void setProcessStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>auth.devices.process_status</code>.
     */
    public String getProcessStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>auth.devices.row_status</code>.
     */
    public void setRowStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>auth.devices.row_status</code>.
     */
    public String getRowStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>auth.devices.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>auth.devices.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>auth.devices.modification_date</code>.
     */
    public void setModificationDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>auth.devices.modification_date</code>.
     */
    public LocalDateTime getModificationDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>auth.devices.user_uuid</code>.
     */
    public void setUserUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>auth.devices.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return (UUID) get(6);
    }

    /**
     * Setter for <code>auth.devices.device_name</code>.
     */
    public void setDeviceName(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>auth.devices.device_name</code>.
     */
    public String getDeviceName() {
        return (String) get(7);
    }

    /**
     * Setter for <code>auth.devices.device_model</code>.
     */
    public void setDeviceModel(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>auth.devices.device_model</code>.
     */
    public String getDeviceModel() {
        return (String) get(8);
    }

    /**
     * Setter for <code>auth.devices.device_manufacturer</code>.
     */
    public void setDeviceManufacturer(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>auth.devices.device_manufacturer</code>.
     */
    public String getDeviceManufacturer() {
        return (String) get(9);
    }

    /**
     * Setter for <code>auth.devices.operation_system</code>.
     */
    public void setOperationSystem(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>auth.devices.operation_system</code>.
     */
    public String getOperationSystem() {
        return (String) get(10);
    }

    /**
     * Setter for <code>auth.devices.device_os_version</code>.
     */
    public void setDeviceOsVersion(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>auth.devices.device_os_version</code>.
     */
    public String getDeviceOsVersion() {
        return (String) get(11);
    }

    /**
     * Setter for <code>auth.devices.browser_name</code>.
     */
    public void setBrowserName(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>auth.devices.browser_name</code>.
     */
    public String getBrowserName() {
        return (String) get(12);
    }

    /**
     * Setter for <code>auth.devices.ip_address</code>.
     */
    public void setİpAddress(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>auth.devices.ip_address</code>.
     */
    public String getİpAddress() {
        return (String) get(13);
    }

    /**
     * Setter for <code>auth.devices.salt</code>.
     */
    public void setSalt(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>auth.devices.salt</code>.
     */
    public String getSalt() {
        return (String) get(14);
    }

    /**
     * Setter for <code>auth.devices.hash</code>.
     */
    public void setHash(String value) {
        set(15, value);
    }

    /**
     * Getter for <code>auth.devices.hash</code>.
     */
    public String getHash() {
        return (String) get(15);
    }

    /**
     * Setter for <code>auth.devices.verification_code</code>.
     */
    public void setVerificationCode(String value) {
        set(16, value);
    }

    /**
     * Getter for <code>auth.devices.verification_code</code>.
     */
    public String getVerificationCode() {
        return (String) get(16);
    }

    /**
     * Setter for <code>auth.devices.verification_code_expire_date</code>.
     */
    public void setVerificationCodeExpireDate(LocalDateTime value) {
        set(17, value);
    }

    /**
     * Getter for <code>auth.devices.verification_code_expire_date</code>.
     */
    public LocalDateTime getVerificationCodeExpireDate() {
        return (LocalDateTime) get(17);
    }

    /**
     * Setter for <code>auth.devices.verification_code_send_date</code>.
     */
    public void setVerificationCodeSendDate(LocalDateTime value) {
        set(18, value);
    }

    /**
     * Getter for <code>auth.devices.verification_code_send_date</code>.
     */
    public LocalDateTime getVerificationCodeSendDate() {
        return (LocalDateTime) get(18);
    }

    /**
     * Setter for <code>auth.devices.verification_code_send_count</code>.
     */
    public void setVerificationCodeSendCount(BigDecimal value) {
        set(19, value);
    }

    /**
     * Getter for <code>auth.devices.verification_code_send_count</code>.
     */
    public BigDecimal getVerificationCodeSendCount() {
        return (BigDecimal) get(19);
    }

    /**
     * Setter for <code>auth.devices.is_verified</code>.
     */
    public void setİsVerified(Boolean value) {
        set(20, value);
    }

    /**
     * Getter for <code>auth.devices.is_verified</code>.
     */
    public Boolean getİsVerified() {
        return (Boolean) get(20);
    }

    /**
     * Setter for <code>auth.devices.is_primary</code>.
     */
    public void setİsPrimary(Boolean value) {
        set(21, value);
    }

    /**
     * Getter for <code>auth.devices.is_primary</code>.
     */
    public Boolean getİsPrimary() {
        return (Boolean) get(21);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record22 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row22<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime, BigDecimal, Boolean, Boolean> fieldsRow() {
        return (Row22) super.fieldsRow();
    }

    @Override
    public Row22<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, String, String, String, String, String, String, String, String, String, String, LocalDateTime, LocalDateTime, BigDecimal, Boolean, Boolean> valuesRow() {
        return (Row22) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Devices.DEVİCES.UUİD;
    }

    @Override
    public Field<Long> field2() {
        return Devices.DEVİCES.VERSİON;
    }

    @Override
    public Field<String> field3() {
        return Devices.DEVİCES.PROCESS_STATUS;
    }

    @Override
    public Field<String> field4() {
        return Devices.DEVİCES.ROW_STATUS;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Devices.DEVİCES.CREATED_DATE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Devices.DEVİCES.MODİFİCATİON_DATE;
    }

    @Override
    public Field<UUID> field7() {
        return Devices.DEVİCES.USER_UUİD;
    }

    @Override
    public Field<String> field8() {
        return Devices.DEVİCES.DEVİCE_NAME;
    }

    @Override
    public Field<String> field9() {
        return Devices.DEVİCES.DEVİCE_MODEL;
    }

    @Override
    public Field<String> field10() {
        return Devices.DEVİCES.DEVİCE_MANUFACTURER;
    }

    @Override
    public Field<String> field11() {
        return Devices.DEVİCES.OPERATİON_SYSTEM;
    }

    @Override
    public Field<String> field12() {
        return Devices.DEVİCES.DEVİCE_OS_VERSİON;
    }

    @Override
    public Field<String> field13() {
        return Devices.DEVİCES.BROWSER_NAME;
    }

    @Override
    public Field<String> field14() {
        return Devices.DEVİCES.İP_ADDRESS;
    }

    @Override
    public Field<String> field15() {
        return Devices.DEVİCES.SALT;
    }

    @Override
    public Field<String> field16() {
        return Devices.DEVİCES.HASH;
    }

    @Override
    public Field<String> field17() {
        return Devices.DEVİCES.VERİFİCATİON_CODE;
    }

    @Override
    public Field<LocalDateTime> field18() {
        return Devices.DEVİCES.VERİFİCATİON_CODE_EXPİRE_DATE;
    }

    @Override
    public Field<LocalDateTime> field19() {
        return Devices.DEVİCES.VERİFİCATİON_CODE_SEND_DATE;
    }

    @Override
    public Field<BigDecimal> field20() {
        return Devices.DEVİCES.VERİFİCATİON_CODE_SEND_COUNT;
    }

    @Override
    public Field<Boolean> field21() {
        return Devices.DEVİCES.İS_VERİFİED;
    }

    @Override
    public Field<Boolean> field22() {
        return Devices.DEVİCES.İS_PRİMARY;
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
    public UUID component7() {
        return getUserUuid();
    }

    @Override
    public String component8() {
        return getDeviceName();
    }

    @Override
    public String component9() {
        return getDeviceModel();
    }

    @Override
    public String component10() {
        return getDeviceManufacturer();
    }

    @Override
    public String component11() {
        return getOperationSystem();
    }

    @Override
    public String component12() {
        return getDeviceOsVersion();
    }

    @Override
    public String component13() {
        return getBrowserName();
    }

    @Override
    public String component14() {
        return getİpAddress();
    }

    @Override
    public String component15() {
        return getSalt();
    }

    @Override
    public String component16() {
        return getHash();
    }

    @Override
    public String component17() {
        return getVerificationCode();
    }

    @Override
    public LocalDateTime component18() {
        return getVerificationCodeExpireDate();
    }

    @Override
    public LocalDateTime component19() {
        return getVerificationCodeSendDate();
    }

    @Override
    public BigDecimal component20() {
        return getVerificationCodeSendCount();
    }

    @Override
    public Boolean component21() {
        return getİsVerified();
    }

    @Override
    public Boolean component22() {
        return getİsPrimary();
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
    public UUID value7() {
        return getUserUuid();
    }

    @Override
    public String value8() {
        return getDeviceName();
    }

    @Override
    public String value9() {
        return getDeviceModel();
    }

    @Override
    public String value10() {
        return getDeviceManufacturer();
    }

    @Override
    public String value11() {
        return getOperationSystem();
    }

    @Override
    public String value12() {
        return getDeviceOsVersion();
    }

    @Override
    public String value13() {
        return getBrowserName();
    }

    @Override
    public String value14() {
        return getİpAddress();
    }

    @Override
    public String value15() {
        return getSalt();
    }

    @Override
    public String value16() {
        return getHash();
    }

    @Override
    public String value17() {
        return getVerificationCode();
    }

    @Override
    public LocalDateTime value18() {
        return getVerificationCodeExpireDate();
    }

    @Override
    public LocalDateTime value19() {
        return getVerificationCodeSendDate();
    }

    @Override
    public BigDecimal value20() {
        return getVerificationCodeSendCount();
    }

    @Override
    public Boolean value21() {
        return getİsVerified();
    }

    @Override
    public Boolean value22() {
        return getİsPrimary();
    }

    @Override
    public DevicesRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public DevicesRecord value2(Long value) {
        setVersion(value);
        return this;
    }

    @Override
    public DevicesRecord value3(String value) {
        setProcessStatus(value);
        return this;
    }

    @Override
    public DevicesRecord value4(String value) {
        setRowStatus(value);
        return this;
    }

    @Override
    public DevicesRecord value5(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public DevicesRecord value6(LocalDateTime value) {
        setModificationDate(value);
        return this;
    }

    @Override
    public DevicesRecord value7(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public DevicesRecord value8(String value) {
        setDeviceName(value);
        return this;
    }

    @Override
    public DevicesRecord value9(String value) {
        setDeviceModel(value);
        return this;
    }

    @Override
    public DevicesRecord value10(String value) {
        setDeviceManufacturer(value);
        return this;
    }

    @Override
    public DevicesRecord value11(String value) {
        setOperationSystem(value);
        return this;
    }

    @Override
    public DevicesRecord value12(String value) {
        setDeviceOsVersion(value);
        return this;
    }

    @Override
    public DevicesRecord value13(String value) {
        setBrowserName(value);
        return this;
    }

    @Override
    public DevicesRecord value14(String value) {
        setİpAddress(value);
        return this;
    }

    @Override
    public DevicesRecord value15(String value) {
        setSalt(value);
        return this;
    }

    @Override
    public DevicesRecord value16(String value) {
        setHash(value);
        return this;
    }

    @Override
    public DevicesRecord value17(String value) {
        setVerificationCode(value);
        return this;
    }

    @Override
    public DevicesRecord value18(LocalDateTime value) {
        setVerificationCodeExpireDate(value);
        return this;
    }

    @Override
    public DevicesRecord value19(LocalDateTime value) {
        setVerificationCodeSendDate(value);
        return this;
    }

    @Override
    public DevicesRecord value20(BigDecimal value) {
        setVerificationCodeSendCount(value);
        return this;
    }

    @Override
    public DevicesRecord value21(Boolean value) {
        setİsVerified(value);
        return this;
    }

    @Override
    public DevicesRecord value22(Boolean value) {
        setİsPrimary(value);
        return this;
    }

    @Override
    public DevicesRecord values(UUID value1, Long value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6, UUID value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, String value16, String value17, LocalDateTime value18, LocalDateTime value19, BigDecimal value20, Boolean value21, Boolean value22) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        value21(value21);
        value22(value22);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached DevicesRecord
     */
    public DevicesRecord() {
        super(Devices.DEVİCES);
    }

    /**
     * Create a detached, initialised DevicesRecord
     */
    public DevicesRecord(UUID uuid, Long version, String processStatus, String rowStatus, LocalDateTime createdDate, LocalDateTime modificationDate, UUID userUuid, String deviceName, String deviceModel, String deviceManufacturer, String operationSystem, String deviceOsVersion, String browserName, String ipAddress, String salt, String hash, String verificationCode, LocalDateTime verificationCodeExpireDate, LocalDateTime verificationCodeSendDate, BigDecimal verificationCodeSendCount, Boolean isVerified, Boolean isPrimary) {
        super(Devices.DEVİCES);

        set(0, uuid);
        set(1, version);
        set(2, processStatus);
        set(3, rowStatus);
        set(4, createdDate);
        set(5, modificationDate);
        set(6, userUuid);
        set(7, deviceName);
        set(8, deviceModel);
        set(9, deviceManufacturer);
        set(10, operationSystem);
        set(11, deviceOsVersion);
        set(12, browserName);
        set(13, ipAddress);
        set(14, salt);
        set(15, hash);
        set(16, verificationCode);
        set(17, verificationCodeExpireDate);
        set(18, verificationCodeSendDate);
        set(19, verificationCodeSendCount);
        set(20, isVerified);
        set(21, isPrimary);
    }
}
