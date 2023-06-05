package az.rock.lib.jresponse.response.message;

import java.util.List;

public class RichMessage extends Message{
    private RichMessage(String message) {
        super(message, false);
    }

    public static RichMessage of(String message, List<String> params) {
        var expression = String.format(message, params.toArray());
        return new RichMessage(message);
    }

}
