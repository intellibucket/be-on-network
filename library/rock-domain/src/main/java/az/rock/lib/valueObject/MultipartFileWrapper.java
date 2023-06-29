package az.rock.lib.valueObject;

import java.io.InputStream;

public final class MultipartFileWrapper {

        private final String fileName;
        private final String contentType;
        private final InputStream content;

        private UploadType uploadType;

        private FileType fileType;

        public MultipartFileWrapper(String fileName, String contentType, InputStream content) {
            this.fileName = fileName;
            this.contentType = contentType;
            this.content = content;
        }

        public static MultipartFileWrapper of(String fileName, String contentType, InputStream content) {
            return new MultipartFileWrapper(fileName, contentType, content);
        }

        public String getFileName() {
            return fileName;
        }

        public String getContentType() {
            return contentType;
        }

        public InputStream getInputStream() {
            return content;
        }

}
