package com.intellibucket.onnetwork.domain.core.root.wallets.abstracts;

import az.rock.lib.valueObject.DecimalValue;
import az.rock.lib.valueObject.payment.WalletType;

import java.math.BigDecimal;

public abstract class CryptoWalletRoot<C extends DecimalValue> extends WalletRoot {
    private C balance;

    public CryptoWalletRoot() {
        super(WalletType.CRYPTO);
    }

    @Override
    public BigDecimal toDecimal() {
        return this.balance.toDecimal();
    }
}
