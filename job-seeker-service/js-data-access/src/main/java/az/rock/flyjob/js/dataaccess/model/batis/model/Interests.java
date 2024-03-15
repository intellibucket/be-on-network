package az.rock.flyjob.js.dataaccess.model.batis.model;

import java.util.Date;

public class Interests {
    private Object uuid;

    private Long version;

    private String processStatus;

    private String rowStatus;

    private Date createdDate;

    private Date modificationDate;

    private Object resumeUuid;

    private String accessModifier;

    private Integer orderNumber;

    private Boolean isHobby;

    private String name;

    private String description;

    public Object getUuid() {
        return uuid;
    }

    public void setUuid(Object uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getRowStatus() {
        return rowStatus;
    }

    public void setRowStatus(String rowStatus) {
        this.rowStatus = rowStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public Object getResumeUuid() {
        return resumeUuid;
    }

    public void setResumeUuid(Object resumeUuid) {
        this.resumeUuid = resumeUuid;
    }

    public String getAccessModifier() {
        return accessModifier;
    }

    public void setAccessModifier(String accessModifier) {
        this.accessModifier = accessModifier;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean getIsHobby() {
        return isHobby;
    }

    public void setIsHobby(Boolean isHobby) {
        this.isHobby = isHobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}