package com.intellibucket.ws.flyjob.message.data;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka-consumer-config")
public class KafkaConsumerConfigData {
    private String keyDeserializer;
    private String valueDeserializer;
    private String autoOffsetReset;
    private String specificAvroReaderKey;
    private String specificAvroReader;
    private Boolean batchListener;
    private Boolean autoStartup;
    private Integer concurrencyLevel;
    private Integer sessionTimeoutMs;
    private Integer heartbeatIntervalMs;
    private Integer maxPollIntervalMs;
    private Long pollTimeoutMs;
    private Integer maxPollRecords;
    private Integer maxPartitionFetchBytesDefault;
    private Integer maxPartitionFetchBytesBoostFactor;

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public String getSpecificAvroReaderKey() {
        return specificAvroReaderKey;
    }

    public void setSpecificAvroReaderKey(String specificAvroReaderKey) {
        this.specificAvroReaderKey = specificAvroReaderKey;
    }

    public String getSpecificAvroReader() {
        return specificAvroReader;
    }

    public void setSpecificAvroReader(String specificAvroReader) {
        this.specificAvroReader = specificAvroReader;
    }

    public Boolean getBatchListener() {
        return batchListener;
    }

    public void setBatchListener(Boolean batchListener) {
        this.batchListener = batchListener;
    }

    public Boolean getAutoStartup() {
        return autoStartup;
    }

    public void setAutoStartup(Boolean autoStartup) {
        this.autoStartup = autoStartup;
    }

    public Integer getConcurrencyLevel() {
        return concurrencyLevel;
    }

    public void setConcurrencyLevel(Integer concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
    }

    public Integer getSessionTimeoutMs() {
        return sessionTimeoutMs;
    }

    public void setSessionTimeoutMs(Integer sessionTimeoutMs) {
        this.sessionTimeoutMs = sessionTimeoutMs;
    }

    public Integer getHeartbeatIntervalMs() {
        return heartbeatIntervalMs;
    }

    public void setHeartbeatIntervalMs(Integer heartbeatIntervalMs) {
        this.heartbeatIntervalMs = heartbeatIntervalMs;
    }

    public Integer getMaxPollIntervalMs() {
        return maxPollIntervalMs;
    }

    public void setMaxPollIntervalMs(Integer maxPollIntervalMs) {
        this.maxPollIntervalMs = maxPollIntervalMs;
    }

    public Long getPollTimeoutMs() {
        return pollTimeoutMs;
    }

    public void setPollTimeoutMs(Long pollTimeoutMs) {
        this.pollTimeoutMs = pollTimeoutMs;
    }

    public Integer getMaxPollRecords() {
        return maxPollRecords;
    }

    public void setMaxPollRecords(Integer maxPollRecords) {
        this.maxPollRecords = maxPollRecords;
    }

    public Integer getMaxPartitionFetchBytesDefault() {
        return maxPartitionFetchBytesDefault;
    }

    public void setMaxPartitionFetchBytesDefault(Integer maxPartitionFetchBytesDefault) {
        this.maxPartitionFetchBytesDefault = maxPartitionFetchBytesDefault;
    }

    public Integer getMaxPartitionFetchBytesBoostFactor() {
        return maxPartitionFetchBytesBoostFactor;
    }

    public void setMaxPartitionFetchBytesBoostFactor(Integer maxPartitionFetchBytesBoostFactor) {
        this.maxPartitionFetchBytesBoostFactor = maxPartitionFetchBytesBoostFactor;
    }
}
