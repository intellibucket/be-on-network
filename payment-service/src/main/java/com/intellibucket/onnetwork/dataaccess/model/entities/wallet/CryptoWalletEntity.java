package com.intellibucket.onnetwork.dataaccess.model.entities.wallet;

import az.rock.lib.valueObject.payment.CryptoWalletType;
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
@Table(name = "crypto_wallets", schema = "wallet")
@Entity(name = "CryptoWalletEntity")
public class CryptoWalletEntity extends BaseWalletEntity {
    private CryptoWalletType cryptoWallet;
}
