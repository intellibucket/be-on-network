package az.rock.message;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageProvider {

    private ObjectMapper objectMapper;
    private Map<String, MessageModel> successMessages = new HashMap<>();
    private Map<String, MessageModel> failMessages = new HashMap<>();

    public static MessageProvider EMPTY = new MessageProvider();

    private MessageProvider() {
    }


    private MessageProvider(File successFile, File failFile) {
        this.objectMapper = new ObjectMapper();
    }

    private MessageProvider(Builder builder) {
        objectMapper = builder.objectMapper;
        successMessages = builder.successMessages;
        failMessages = builder.failMessages;
    }

    public String fail(String code, String lang) {
        var model = this.failMessages.get(code);
        if (lang.equals("az")) return model.getAz();
        else return model.getEn();
    }

    public String fail(String code) {
        return this.fail(code, "az");
    }

    public String success(String code, String lang) {
        return null;
    }


    /**
     * {@code MessageProvider} builder static inner class.
     */
    public static final class Builder {
        private File successFile;
        private File failFile;

        private String successFileString;
        private String failFileString;

        private ObjectMapper objectMapper;
        private final Map<String, MessageModel> successMessages = new HashMap<>();
        private final Map<String, MessageModel> failMessages = new HashMap<>();

        private Builder() {
        }

        public static Builder builder() {
            var builder = new Builder();
            builder.objectMapper = new ObjectMapper();
            return builder;
        }

        /**
         * Sets the {@code successFile} and returns a reference to this Builder enabling method chaining.
         *
         * @param successFile the {@code successFile} to set
         * @return a reference to this Builder
         */
        public Builder withFiles(File successFile, File failFile) {
            this.successFile = successFile;
            this.failFile = failFile;
            return this;
        }

        public Builder withFiles(String successFileAsString, String failFileAsString) {
            this.successFileString = successFileAsString;
            this.failFileString = failFileAsString;
            return this;
        }

        public Builder withSuccessString(String successFileAsString) {
            this.successFileString = successFileAsString;
            return this;
        }

        public Builder withFailString(String failFileAsString) {
            this.failFileString = failFileAsString;
            return this;
        }


        public MessageProvider buildString() {
            var object = new MessageProvider(this);
            try {
                var failList = Arrays.asList(objectMapper.readValue(this.failFileString, MessageModel[].class));
                var successList = Arrays.asList(objectMapper.readValue(this.failFileString, MessageModel[].class));

                failList.forEach(model -> object.failMessages.put(model.getCode(), model));
                successList.forEach(model -> object.successMessages.put(model.getCode(), model));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return object;
        }


        /**
         * Returns a {@code MessageProvider} built from the parameters previously set.
         *
         * @return a {@code MessageProvider} built with parameters of this {@code MessageProvider.Builder}
         */
        public MessageProvider buildFile() {
            var object = new MessageProvider(this);
            try {
                var failList = Arrays.asList(objectMapper.readValue(this.failFile, MessageModel[].class));
                var successList = Arrays.asList(objectMapper.readValue(this.successFile, MessageModel[].class));

                failList.forEach(model -> object.failMessages.put(model.getCode(), model));
                successList.forEach(model -> object.successMessages.put(model.getCode(), model));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return object;
        }
    }
}
