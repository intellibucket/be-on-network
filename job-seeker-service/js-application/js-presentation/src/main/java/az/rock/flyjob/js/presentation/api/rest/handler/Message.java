package az.rock.flyjob.js.presentation.api.rest.handler;

public final class Message {
    private String code;
    private String az;
    private String en;
    private String ru;
    private String tr;
    private String regex;
    private Boolean hasRegex;

    public Message() {
    }

    public Message(String code, String az, String en, String ru, String tr, String regex, Boolean hasRegex) {
        this.code = code;
        this.az = az;
        this.en = en;
        this.ru = ru;
        this.tr = tr;
        this.regex = regex;
        this.hasRegex = hasRegex;
    }

    public String getCode() {
        return code;
    }

    public String getAz() {
        return az;
    }

    public String getEn() {
        return en;
    }

    public String getRu() {
        return ru;
    }

    public String getTr() {
        return tr;
    }

    public String getRegex() {
        return regex;
    }

    public Boolean getHasRegex() {
        return hasRegex;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAz(String az) {
        this.az = az;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public void setHasRegex(Boolean hasRegex) {
        this.hasRegex = hasRegex;
    }
}
