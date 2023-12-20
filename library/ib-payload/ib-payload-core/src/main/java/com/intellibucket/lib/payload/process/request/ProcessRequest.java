package com.intellibucket.lib.payload.process.request;

import com.intellibucket.lib.payload.trx.OutboxStatus;

import java.util.UUID;

public class ProcessRequest<T> {
    private UUID transactionId;
    private final OutboxStatus outboxStatus = OutboxStatus.STARTED;
    private String step;
    private T data;
}
