package az.rock.spring.security.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.HashSet;

public abstract class SecuredConstraint {
    private final Log log = LogFactory.getLog(this.getClass());

    protected void log(JoinPoint joinPoint) {
        log.info("monitor.before, class: " + joinPoint.getSignature().getDeclaringType().getSimpleName() + ", " +
                "method: " + joinPoint.getSignature().getName());
    }

    protected abstract void before(JoinPoint joinPoint) throws Throwable;

    protected abstract void control(HashSet<String> permissions) throws Throwable;

    protected Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
