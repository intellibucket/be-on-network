package com.intellibucket.onnetwork.dataaccess.model.entities.wallet;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.payment.WalletType;
import jakarta.persistence.MappedSuperclass;

import java.math.BigDecimal;

@MappedSuperclass
public class BaseWalletEntity extends BaseEntity {
    protected WalletType walletType;
    protected BigDecimal balance;
}
