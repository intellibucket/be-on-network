package com.intellibucket.lib.fj.notificatin.api.notifications;

import com.intellibucket.lib.fj.notificatin.api.Notification;
import com.intellibucket.lib.fj.notificatin.api.NotificationRecord;
import com.intellibucket.lib.fj.notificatin.api.NotificationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NotificationRecord
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ViewedProfileNotification extends Notification {
    public ViewedProfileNotification(UUID publisherId, UUID subscriberId) {
        super(NotificationType.VIEWED_PROFILE, "notification.viewedProfile", publisherId, subscriberId);
    }

    public ViewedProfileNotification(UUID publisherId, UUID subscriberId, String messageCode) {
        super(NotificationType.VIEWED_PROFILE, messageCode, publisherId, subscriberId);
    }

    public static ViewedProfileNotification of(UUID publisherId, UUID subscriberId) {
        return new ViewedProfileNotification(publisherId, subscriberId);
    }
}
