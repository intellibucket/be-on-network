package az.rock.lib.annotation;

import az.rock.lib.valueObject.common.MediaType;

import java.awt.*;

public @interface FileSupport {
    String[] types() default {MediaType.BYTE_ARRAY};
}
