package az.rock.lib.jresponse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class JTransfer {
    private final UUID trackId = UUID.randomUUID();
    private final ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));
    private JHeader header;

    public JTransfer() {
        this(JHeader.EMPTY);
    }

    public JTransfer(JHeader header) {
        this.header = header;
    }

    public UUID getTrackId() {
        return trackId;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public JHeader getHeader() {
        return header;
    }

    public void setHeader(JHeader header) {
        this.header = header;
    }
}
