package com.intellibucket.onnetwork.domain.core.root.wallets.abstracts;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.payment.WalletID;
import az.rock.lib.valueObject.DecimalValue;
import az.rock.lib.valueObject.payment.WalletType;

public abstract class WalletRoot extends AggregateRoot<WalletID> implements DecimalValue {

    private final WalletType walletType;

    protected WalletRoot(WalletType walletType) {
        this.walletType = walletType;
    }
}
