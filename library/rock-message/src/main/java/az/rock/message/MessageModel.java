package az.rock.message;

public class MessageModel {
    private String code;
    private String hasRegexp;
    private String az;
    private String en;
    private String tr;
    private String ru;

    public MessageModel(String code, String az, String en, String tr, String ru) {
        this.code = code;
        this.az = az;
        this.en = en;
        this.tr = tr;
        this.ru = ru;
    }

    public MessageModel() {
    }

    public String getMessage(String lang) {
        return switch (lang) {
            case "az" -> az;
            case "en" -> en;
            case "tr" -> tr;
            case "ru" -> ru;
            default -> az;
        };
    }

    public String hasRegexp() {
        return hasRegexp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAz() {
        return az;
    }

    public void setAz(String az) {
        this.az = az;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }
}
