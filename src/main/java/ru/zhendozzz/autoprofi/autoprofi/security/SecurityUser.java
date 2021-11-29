package ru.zhendozzz.autoprofi.autoprofi.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.zhendozzz.autoprofi.autoprofi.entity.User;

@Data
public class SecurityUser implements UserDetails {

    public SecurityUser(String username, String password, List<SimpleGrantedAuthority> simpleGrantedAuthorities, boolean isActive) {
        this.username = username;
        this.password = password;
        this.simpleGrantedAuthorities = simpleGrantedAuthorities;
        this.isActive = isActive;
    }

    private final String username;
    private final String password;
    private final List<SimpleGrantedAuthority> simpleGrantedAuthorities;
    private final boolean isActive;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public static UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
            user.getLogin(),
            user.getPassword(),
            true,
            true,
            true,
            true,
            user.getRole().getAuthorities()
        );
    }
}
