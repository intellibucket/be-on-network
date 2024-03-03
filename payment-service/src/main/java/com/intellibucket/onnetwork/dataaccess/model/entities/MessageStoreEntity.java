package com.intellibucket.onnetwork.dataaccess.model.entities;

import az.rock.lib.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message_store", schema = "payment")
@Entity(name = "MessageStoreEntity")
public class MessageStoreEntity extends BaseEntity {
    private UUID transactionId;
    private String message;
}
