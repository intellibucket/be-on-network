package com.intellibucket.onnetwork.dataaccess.model.entities.wallet;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.payment.TransferFailCaused;
import az.rock.lib.valueObject.payment.WalletTransferStatus;
import az.rock.lib.valueObject.payment.WalletType;
import com.intellibucket.lib.fj.dataaccess.annotations.Description;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet_transfer_histories", schema = "wallet",
        indexes = {
                @Index(name = "idx_wallet_transfer_histories_by_transaction_id", columnList = "transaction_id"),
        }
)
@Entity(name = "WalletTransferHistoryEntity")
public class WalletTransferHistoryEntity extends BaseEntity {

    @Column(name = "transaction_id", nullable = false, updatable = false, unique = true)
    private UUID transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "transfer_status", nullable = false)
    private WalletTransferStatus transferStatus;

    @Description({
            "It is used to lock the source wallet and prevent double spending",
            "It is unique for each transaction and it is generated by the system",
            "It could be used to unlock the source wallet if the transaction is failed or cancelled",
            "It contains many characters and it is generated by source wallet id, transfer status and payment account id",
    })
    @Column(name = "lock_constraint", nullable = false, unique = true)
    private String lockConstraint;

    @Min(0)
    @Column(name = "source_transfer_value", nullable = false, updatable = false)
    private BigDecimal sourceTransferValue;

    @Min(0)
    @Column(name = "target_transfer_value", nullable = false, updatable = false)
    private BigDecimal realTimeExchangeRate;

    @Enumerated(EnumType.STRING)
    private WalletType sourceWalletType;
    @Column(name = "source_wallet_id", nullable = false, updatable = false)
    private UUID sourceWalletId;

    @Enumerated(EnumType.STRING)
    private WalletType targetWalletType;
    @Column(name = "target_wallet_id", nullable = false, updatable = false)
    private UUID targetWalletId;

    @Enumerated(EnumType.STRING)
    @Column(name = "fail_caused")
    private TransferFailCaused failCaused;

}