package az.rock.lib.valueObject;

import az.rock.lib.annotation.ValueObject;

@ValueObject
public class Contact {
    private final ContactFormatType formatType;

    private final ContactLiveType liveType;

    private final String data;

    public Contact(ContactFormatType formatType, ContactLiveType liveType, String data) {
        this.formatType = formatType;
        this.liveType = liveType;
        this.data = data;
    }

    private Contact(Builder builder) {
        formatType = builder.formatType;
        liveType = builder.liveType;
        data = builder.data;
    }


    public static final class Builder {
        private final ContactFormatType formatType;
        private final ContactLiveType liveType;
        private final String data;

        public Builder(ContactFormatType formatType, ContactLiveType liveType, String data) {
            this.formatType = formatType;
            this.liveType = liveType;
            this.data = data;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
