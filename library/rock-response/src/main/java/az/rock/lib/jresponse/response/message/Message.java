package az.rock.lib.jresponse.response.message;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
    /**
     * Message text or code
     * @autor Vugar Mammadli
     */
    private final String expression;
    private final Boolean isCode;

    private Boolean isParametrized = false;

    private List<String> params;


    public static Message of(String text, Boolean isCode,List<String> params) {
        return new Message(text, isCode,params);
    }

    public static Message of(String messageCode, List<String> params) {
        return new Message(messageCode, true, params);
    }

    public static Message of(String text, Boolean isCode) {
        return new Message(text, isCode);
    }

    public static Message of(String code) {
        return new Message(code, false);
    }

    public Message(String expression, Boolean isCode) {
        this.expression = expression;
        this.isCode = isCode;
    }

    public Message(String expression, Boolean isCode, List<String> params) {
        this.expression = expression;
        this.isCode = isCode;
        this.params = params;
    }

    public Boolean getCode() {
        return isCode;
    }

    public String getExpression() {
        return expression;
    }

    public Boolean getParametrized() {
        return isParametrized;
    }

    public List<String> getParams() {
        return params;
    }
}
