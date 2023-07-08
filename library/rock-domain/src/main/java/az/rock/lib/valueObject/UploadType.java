package az.rock.lib.valueObject;

public enum UploadType {
    PROFILE_PICTURE(new String[]{"image/jpeg", "image/png", "image/gif", "image/jpg"}){
        @Override
        public String getUploadPath() {
            return "/image/profile/";
        }
    }, COVER_PICTURE(new String[]{"image/jpeg"}){
        @Override
        String getUploadPath() {
            return "/image/cover/";
        }
    }, VIDEO(new String[]{"video/mp4"}){
        @Override
        String getUploadPath() {
            return "/video/";
        }
    }, DOCUMENT(new String[]{"application/pdf"}){
        @Override
        String getUploadPath() {
            return "/document/";
        }
    }, NONE(new String[]{}){
        @Override
        public String getUploadPath() {
            return "/none/";
        }
    };

    private final String[] contentType;

    UploadType(String[] contentType) {
        this.contentType = contentType;
    }

    abstract String getUploadPath();
}
