package com.intellibucket.onnetwork.domain.core.root.wallets.abstracts;

import az.rock.lib.valueObject.Money;
import az.rock.lib.valueObject.payment.WalletType;

import java.math.BigDecimal;

public abstract class MoneyWalletRoot extends WalletRoot {
    private Money amount;

    public MoneyWalletRoot() {
        super(WalletType.MONEY);
    }

    @Override
    public BigDecimal toDecimal() {
        return this.amount.getAmount();
    }
}
