package az.rock.lib.jresponse;

import az.rock.lib.util.constant.HeaderConstant;

import java.util.HashMap;
import java.util.Map;

public final class JHeader {
    public static final JHeader EMPTY = new JHeader();

    private final Map<String, String> claims;

    public JHeader(Map<String, String> claims) {
        this.claims = claims;
    }

    public JHeader() {
        this.claims = new HashMap<>();
    }


    public String getUserUUID() {
        return this.claims.get(HeaderConstant.UUID);
    }
}
