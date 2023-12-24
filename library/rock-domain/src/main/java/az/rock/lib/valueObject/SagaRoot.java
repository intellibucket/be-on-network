package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.TransactionID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.trx.TrxProcessStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

@ValueObject
public final class SagaRoot<D> {
    private final TransactionID transactionID;
    private final TrxProcessStatus sagaStatus;
    private final ZonedDateTime time;
    private final D data;

    public SagaRoot(TransactionID transactionID, TrxProcessStatus sagaStatus, ZonedDateTime time, D data) {
        this.transactionID = transactionID;
        this.sagaStatus = sagaStatus;
        this.time = time;
        this.data = data;
    }

    public static class SagaDetail {
        private final TransactionID transactionID;
        private final TrxProcessStatus sagaStatus;
        private final ZonedDateTime time;

        private SagaDetail(TransactionID transactionID, TrxProcessStatus sagaStatus, ZonedDateTime time) {
            this.transactionID = transactionID;
            this.sagaStatus = sagaStatus;
            this.time = time;
        }

        public static SagaDetail of(SagaRoot<?> sagaRoot) {
            return new SagaDetail(sagaRoot.getSagaID(), sagaRoot.getSagaStatus(), sagaRoot.getTime());
        }


        public TransactionID getSagaID() {
            return transactionID;
        }

        public TrxProcessStatus getSagaStatus() {
            return sagaStatus;
        }

        public ZonedDateTime getTime() {
            return time;
        }
    }

    public static <T> SagaRoot<T> replace(SagaRoot<?> sagaRoot, T payload) {
        return new SagaRoot<>(sagaRoot.getSagaID(), sagaRoot.sagaStatus, sagaRoot.time, payload);
    }

    private SagaRoot(Builder<D> builder) {
        transactionID = builder.transactionID;
        sagaStatus = builder.sagaStatus;
        time = builder.time;
        data = builder.data;
    }

    public TransactionID getSagaID() {
        return transactionID;
    }

    public TrxProcessStatus getSagaStatus() {
        return sagaStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public D getData() {
        return data;
    }

    @JsonIgnore
    public Boolean hasData() {
        return data != null;
    }

    public static <D> SagaRoot<D> of(TransactionID transactionID, TrxProcessStatus sagaStatus, ZonedDateTime time, D data) {
        return new SagaRoot<>(transactionID, sagaStatus, time, data);
    }

    public static <D> SagaRoot<D> of(D data) {
        return SagaRoot.of(TransactionID.of(UUID.randomUUID()), TrxProcessStatus.STARTED, ZonedDateTime.now(), data);
    }


    public static final class Builder<D> {
        private TransactionID transactionID;
        private TrxProcessStatus sagaStatus;
        private ZonedDateTime time;
        private D data;

        private Builder() {
        }

        public static <D> Builder<D> builder() {
            return new Builder<D>();
        }

        public Builder<D> sagaID(TransactionID val) {
            transactionID = val;
            return this;
        }

        public Builder<D> sagaStatus(TrxProcessStatus val) {
            sagaStatus = val;
            return this;
        }

        public Builder<D> time(ZonedDateTime val) {
            time = val;
            return this;
        }

        public Builder<D> data(D val) {
            data = val;
            return this;
        }

        public SagaRoot<D> build() {
            return new SagaRoot<D>(this);
        }
    }
}
