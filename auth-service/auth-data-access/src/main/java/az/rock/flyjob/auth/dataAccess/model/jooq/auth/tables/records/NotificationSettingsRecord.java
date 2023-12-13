/*
 * This file is generated by jOOQ.
 */
package az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.records;


import az.rock.flyjob.auth.dataAccess.model.jooq.auth.tables.NotificationSettings;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NotificationSettingsRecord extends UpdatableRecordImpl<NotificationSettingsRecord> implements Record11<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, Boolean, Boolean, Boolean, Boolean> {

    private static final long serialVersionUID = -757642175;

    /**
     * Setter for <code>auth.notification_settings.uuid</code>.
     */
    public void setUuid(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>auth.notification_settings.uuid</code>.
     */
    public UUID getUuid() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>auth.notification_settings.version</code>.
     */
    public void setVersion(Long value) {
        set(1, value);
    }

    /**
     * Getter for <code>auth.notification_settings.version</code>.
     */
    public Long getVersion() {
        return (Long) get(1);
    }

    /**
     * Setter for <code>auth.notification_settings.process_status</code>.
     */
    public void setProcessStatus(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>auth.notification_settings.process_status</code>.
     */
    public String getProcessStatus() {
        return (String) get(2);
    }

    /**
     * Setter for <code>auth.notification_settings.row_status</code>.
     */
    public void setRowStatus(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>auth.notification_settings.row_status</code>.
     */
    public String getRowStatus() {
        return (String) get(3);
    }

    /**
     * Setter for <code>auth.notification_settings.created_date</code>.
     */
    public void setCreatedDate(LocalDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>auth.notification_settings.created_date</code>.
     */
    public LocalDateTime getCreatedDate() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>auth.notification_settings.modification_date</code>.
     */
    public void setModificationDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>auth.notification_settings.modification_date</code>.
     */
    public LocalDateTime getModificationDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>auth.notification_settings.user_uuid</code>.
     */
    public void setUserUuid(UUID value) {
        set(6, value);
    }

    /**
     * Getter for <code>auth.notification_settings.user_uuid</code>.
     */
    public UUID getUserUuid() {
        return (UUID) get(6);
    }

    /**
     * Setter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me</code>.
     */
    public void setNotifyMeWhenSomebodySpeaksAboutMe(Boolean value) {
        set(7, value);
    }

    /**
     * Getter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me</code>.
     */
    public Boolean getNotifyMeWhenSomebodySpeaksAboutMe() {
        return (Boolean) get(7);
    }

    /**
     * Setter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me_on_posts</code>.
     */
    public void setNotifyMeWhenSomebodySpeaksAboutMeOnPosts(Boolean value) {
        set(8, value);
    }

    /**
     * Getter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me_on_posts</code>.
     */
    public Boolean getNotifyMeWhenSomebodySpeaksAboutMeOnPosts() {
        return (Boolean) get(8);
    }

    /**
     * Setter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me_on_comments</code>.
     */
    public void setNotifyMeWhenSomebodySpeaksAboutMeOnComments(Boolean value) {
        set(9, value);
    }

    /**
     * Getter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_me_on_comments</code>.
     */
    public Boolean getNotifyMeWhenSomebodySpeaksAboutMeOnComments() {
        return (Boolean) get(9);
    }

    /**
     * Setter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_my_replies</code>.
     */
    public void setNotifyMeWhenSomebodySpeaksAboutMyReplies(Boolean value) {
        set(10, value);
    }

    /**
     * Getter for <code>auth.notification_settings.notify_me_when_somebody_speaks_about_my_replies</code>.
     */
    public Boolean getNotifyMeWhenSomebodySpeaksAboutMyReplies() {
        return (Boolean) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, Boolean, Boolean, Boolean, Boolean> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<UUID, Long, String, String, LocalDateTime, LocalDateTime, UUID, Boolean, Boolean, Boolean, Boolean> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.UUİD;
    }

    @Override
    public Field<Long> field2() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.VERSİON;
    }

    @Override
    public Field<String> field3() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.PROCESS_STATUS;
    }

    @Override
    public Field<String> field4() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.ROW_STATUS;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.CREATED_DATE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.MODİFİCATİON_DATE;
    }

    @Override
    public Field<UUID> field7() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.USER_UUİD;
    }

    @Override
    public Field<Boolean> field8() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.NOTİFY_ME_WHEN_SOMEBODY_SPEAKS_ABOUT_ME;
    }

    @Override
    public Field<Boolean> field9() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.NOTİFY_ME_WHEN_SOMEBODY_SPEAKS_ABOUT_ME_ON_POSTS;
    }

    @Override
    public Field<Boolean> field10() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.NOTİFY_ME_WHEN_SOMEBODY_SPEAKS_ABOUT_ME_ON_COMMENTS;
    }

    @Override
    public Field<Boolean> field11() {
        return NotificationSettings.NOTİFİCATİON_SETTİNGS.NOTİFY_ME_WHEN_SOMEBODY_SPEAKS_ABOUT_MY_REPLİES;
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
    public Boolean component8() {
        return getNotifyMeWhenSomebodySpeaksAboutMe();
    }

    @Override
    public Boolean component9() {
        return getNotifyMeWhenSomebodySpeaksAboutMeOnPosts();
    }

    @Override
    public Boolean component10() {
        return getNotifyMeWhenSomebodySpeaksAboutMeOnComments();
    }

    @Override
    public Boolean component11() {
        return getNotifyMeWhenSomebodySpeaksAboutMyReplies();
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
    public Boolean value8() {
        return getNotifyMeWhenSomebodySpeaksAboutMe();
    }

    @Override
    public Boolean value9() {
        return getNotifyMeWhenSomebodySpeaksAboutMeOnPosts();
    }

    @Override
    public Boolean value10() {
        return getNotifyMeWhenSomebodySpeaksAboutMeOnComments();
    }

    @Override
    public Boolean value11() {
        return getNotifyMeWhenSomebodySpeaksAboutMyReplies();
    }

    @Override
    public NotificationSettingsRecord value1(UUID value) {
        setUuid(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value2(Long value) {
        setVersion(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value3(String value) {
        setProcessStatus(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value4(String value) {
        setRowStatus(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value5(LocalDateTime value) {
        setCreatedDate(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value6(LocalDateTime value) {
        setModificationDate(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value7(UUID value) {
        setUserUuid(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value8(Boolean value) {
        setNotifyMeWhenSomebodySpeaksAboutMe(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value9(Boolean value) {
        setNotifyMeWhenSomebodySpeaksAboutMeOnPosts(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value10(Boolean value) {
        setNotifyMeWhenSomebodySpeaksAboutMeOnComments(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord value11(Boolean value) {
        setNotifyMeWhenSomebodySpeaksAboutMyReplies(value);
        return this;
    }

    @Override
    public NotificationSettingsRecord values(UUID value1, Long value2, String value3, String value4, LocalDateTime value5, LocalDateTime value6, UUID value7, Boolean value8, Boolean value9, Boolean value10, Boolean value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached NotificationSettingsRecord
     */
    public NotificationSettingsRecord() {
        super(NotificationSettings.NOTİFİCATİON_SETTİNGS);
    }

    /**
     * Create a detached, initialised NotificationSettingsRecord
     */
    public NotificationSettingsRecord(UUID uuid, Long version, String processStatus, String rowStatus, LocalDateTime createdDate, LocalDateTime modificationDate, UUID userUuid, Boolean notifyMeWhenSomebodySpeaksAboutMe, Boolean notifyMeWhenSomebodySpeaksAboutMeOnPosts, Boolean notifyMeWhenSomebodySpeaksAboutMeOnComments, Boolean notifyMeWhenSomebodySpeaksAboutMyReplies) {
        super(NotificationSettings.NOTİFİCATİON_SETTİNGS);

        set(0, uuid);
        set(1, version);
        set(2, processStatus);
        set(3, rowStatus);
        set(4, createdDate);
        set(5, modificationDate);
        set(6, userUuid);
        set(7, notifyMeWhenSomebodySpeaksAboutMe);
        set(8, notifyMeWhenSomebodySpeaksAboutMeOnPosts);
        set(9, notifyMeWhenSomebodySpeaksAboutMeOnComments);
        set(10, notifyMeWhenSomebodySpeaksAboutMyReplies);
    }
}