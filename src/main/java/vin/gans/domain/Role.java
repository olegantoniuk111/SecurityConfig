package vin.gans.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by root on 01.05.17.
 */
public enum Role implements GrantedAuthority {
    USER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
