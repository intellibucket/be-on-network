package com.intellibucket.onnetwork.dataaccess.model.entities;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.payment.WalletType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallets", schema = "payment")
@Entity(name = "WalletEntity")
public class WalletEntity extends BaseEntity {
    private WalletType walletType;
    private BigDecimal amount;
}
