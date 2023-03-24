package az.rock.spring.security.aspect;

import az.rock.lib.jexception.JSecurityException;
import az.rock.spring.security.web.JPermissionSecured;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;


@Component
@Aspect
public class PermissionSecuredConstraint extends SecuredConstraint {

    @Before(value = "@within(az.rock.lib.security.core.JPermissionSecured) || @annotation(az.rock.lib.security.core.JPermissionSecured)")
    public void before(JoinPoint joinPoint) throws Throwable {
        this.log(joinPoint);
        var permissions = new HashSet<>(Arrays.asList(((MethodSignature) joinPoint.getSignature())
                .getMethod()
                .getAnnotation(JPermissionSecured.class)
                .permissions()));
        this.control(permissions);
    }

    protected void control(HashSet<String> permissions) {
        var authentication = this.getAuthentication();
        var authorities = authentication.getAuthorities();
        if (authentication.isAuthenticated() && !authorities.isEmpty()) {
            var simpleUserAuthorities = authorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toSet());
            permissions.removeAll(simpleUserAuthorities);
            if (!permissions.isEmpty()) throw new JSecurityException("Unauthorized request exception");
        } else throw new JSecurityException("Unauthorized request exception");
    }

}