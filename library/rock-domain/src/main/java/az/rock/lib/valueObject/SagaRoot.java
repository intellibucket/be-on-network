package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;
import az.rock.lib.domain.SagaID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.intellibucket.lib.payload.trx.ProcessStatus;

import java.time.ZonedDateTime;
import java.util.UUID;

@ValueObject
public final class SagaRoot<D> {
    private final SagaID sagaID;
    private final ProcessStatus sagaStatus;
    private final ZonedDateTime time;
    private final D data;

    public SagaRoot(SagaID sagaID, ProcessStatus sagaStatus, ZonedDateTime time, D data) {
        this.sagaID = sagaID;
        this.sagaStatus = sagaStatus;
        this.time = time;
        this.data = data;
    }

    public static class SagaDetail {
        private final SagaID sagaID;
        private final ProcessStatus sagaStatus;
        private final ZonedDateTime time;

        private SagaDetail(SagaID sagaID, ProcessStatus sagaStatus, ZonedDateTime time) {
            this.sagaID = sagaID;
            this.sagaStatus = sagaStatus;
            this.time = time;
        }

        public static SagaDetail of(SagaRoot<?> sagaRoot) {
            return new SagaDetail(sagaRoot.getSagaID(), sagaRoot.getSagaStatus(), sagaRoot.getTime());
        }


        public SagaID getSagaID() {
            return sagaID;
        }

        public ProcessStatus getSagaStatus() {
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
        sagaID = builder.sagaID;
        sagaStatus = builder.sagaStatus;
        time = builder.time;
        data = builder.data;
    }

    public SagaID getSagaID() {
        return sagaID;
    }

    public ProcessStatus getSagaStatus() {
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

    public static <D> SagaRoot<D> of(SagaID sagaID, ProcessStatus sagaStatus, ZonedDateTime time, D data) {
        return new SagaRoot<>(sagaID, sagaStatus, time, data);
    }

    public static <D> SagaRoot<D> of(D data) {
        return SagaRoot.of(SagaID.of(UUID.randomUUID()), ProcessStatus.STARTED, ZonedDateTime.now(), data);
    }


    public static final class Builder<D> {
        private SagaID sagaID;
        private ProcessStatus sagaStatus;
        private ZonedDateTime time;
        private D data;

        private Builder() {
        }

        public static <D> Builder<D> builder() {
            return new Builder<D>();
        }

        public Builder<D> sagaID(SagaID val) {
            sagaID = val;
            return this;
        }

        public Builder<D> sagaStatus(ProcessStatus val) {
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
