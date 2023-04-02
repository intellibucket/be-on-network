package az.rock.spring.security.web;

import az.rock.lib.util.constant.HeaderConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GUserDetail extends User {
    private String uuid;

    public GUserDetail(String uuid, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.uuid = uuid;
    }

    public GUserDetail(String uuid, String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.uuid = uuid;
    }


    public String getUserUUID() {
        return uuid;
    }


    public Map<String, String> prepareDetail() {
        HashMap<String, String> map = new HashMap<>();
        map.put(HeaderConstant.UUID, this.getUserUUID());
        map.put(HeaderConstant.USERNAME, this.getUsername());
        return map;
    }
}
