package az.rock.message;

import az.rock.lib.util.constant.LangConstant;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MessageProvider {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Map<String, MessageModel> successMessages = new HashMap<>();
    private Map<String, MessageModel> failMessages = new HashMap<>();

    public static final MessageProvider EMPTY = new MessageProvider();

    private MessageProvider() {
    }


    private MessageProvider(Builder builder) {
        successMessages = builder.successMessages;
        failMessages = builder.failMessages;
    }

    private String findModel(String code, String lang, Map<String, MessageModel> map) {
        var model = map.get(code);
        if (model == null) map.get("default");
        assert model != null;
        return model.getMessage(lang);
    }

    public String fail() {
        return this.fail("default", LangConstant.AZ);
    }

    public String fail(String code) {
        return this.fail(code, LangConstant.AZ);
    }

    public String fail(String code, String lang) {
        return this.findModel(code, lang, this.failMessages);
    }

    public String success() {
        return this.success("default", LangConstant.AZ);
    }

    public String success(String code) {
        return this.success(code, LangConstant.AZ);
    }

    public String success(String code, String lang) {
        return this.findModel(code, lang, this.successMessages);
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
