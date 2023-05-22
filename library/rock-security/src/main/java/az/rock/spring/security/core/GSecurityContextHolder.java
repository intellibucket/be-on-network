package az.rock.spring.security.core;

import org.springframework.security.core.context.SecurityContextHolder;

public class GSecurityContextHolder {
    private static final ThreadLocal<GSecurityContext> contextHolder = new ThreadLocal<>();
    GHolderStrategy strategy = GHolderStrategy.MODE_THREADLOCAL;
}
