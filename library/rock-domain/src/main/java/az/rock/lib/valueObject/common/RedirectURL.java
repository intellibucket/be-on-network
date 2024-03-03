package az.rock.lib.valueObject.common;

public final class RedirectURL {
    private final String successUrl;
    private final String cancelUrl;

    public RedirectURL(String successUrl, String cancelUrl) {
        this.successUrl = successUrl;
        this.cancelUrl = cancelUrl;
    }


    public String getCancelUrl() {
        return cancelUrl;
    }

    public String getSuccessUrl() {
        return successUrl;
    }
}
