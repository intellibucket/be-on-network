package az.rock.lib.valueObject;

public final class MultipartFileWrapper {

        private final String fileName;
        private final String contentType;
        private final byte[] content;

        public MultipartFileWrapper(String fileName, String contentType, byte[] content) {
            this.fileName = fileName;
            this.contentType = contentType;
            this.content = content;
        }

        public static MultipartFileWrapper of(String fileName, String contentType, byte[] content) {
            return new MultipartFileWrapper(fileName, contentType, content);
        }

        public String getFileName() {
            return fileName;
        }

        public String getContentType() {
            return contentType;
        }

        public byte[] getContent() {
            return content;
        }

}
