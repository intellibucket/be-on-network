package com.intellibucket.onnetwork.dataaccess.model.entities.wallet;

import az.rock.lib.valueObject.payment.MoneyWalletType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "money_wallets", schema = "wallet")
@Entity(name = "MoneyWalletEntity")
public class MoneyWalletEntity extends BaseWalletEntity {
    private MoneyWalletType moneyWallet;
}
