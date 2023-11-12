package com.intellibucket.lib.fj.notificatin.api;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public abstract class Notification {
    private NotificationType notificationType;

    private ZonedDateTime createdAt = ZonedDateTime.now();
    private String messageCode;
    private UUID publisherId;
    private UUID subscriberId;

    protected Notification(NotificationType notificationType,
                           String messageCode,
                           UUID publisherId,
                           UUID subscriberId) {
        this.notificationType = notificationType;
        this.messageCode = messageCode;
        this.publisherId = publisherId;
        this.subscriberId = subscriberId;
    }
}
