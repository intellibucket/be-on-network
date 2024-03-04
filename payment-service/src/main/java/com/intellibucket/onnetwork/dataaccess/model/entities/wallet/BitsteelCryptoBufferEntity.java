package com.intellibucket.onnetwork.dataaccess.model.entities.wallet;

import az.rock.lib.domain.BaseEntity;
import az.rock.lib.valueObject.payment.Crypto;
import com.intellibucket.lib.fj.dataaccess.annotations.Description;
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
@Table(name = "buffer", schema = "crypto")
@Entity(name = "BitsteelCryptoBufferEntity")
@Description({
        "It is used to store the encrypted private key, seed, mnemonic and password of the bitsteel wallet",
        "It is used to store the path, address, salt and iv of the bitsteel wallet",
})
public class BitsteelCryptoBufferEntity extends BaseEntity {
    private Crypto crypto;
    private String path;
    private String address;
    private String salt;
    private String iv;
    private String encryptedPrivateKey;
    private String encryptedSeed;
    private String encryptedMnemonic;
    private String encryptedPassword;
}
