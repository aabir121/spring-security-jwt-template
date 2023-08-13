package aabir.example.securityjpa.model;

import aabir.example.securityjpa.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetails implements UserDetails {
    private Long id;
    private String username;
    private String password;
    private boolean active;
    private List<SimpleGrantedAuthority> authorityList;

    public CustomUserDetails(User user) {
        this.id = user.getId();
        this.username = user.getUserName();
        this.active = user.isActive();
        this.password = user.getPassword();
        this.authorityList = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Add your own logic to calculate if the account is expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Add your own logic to calculate if the account is locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Add your own logic to calculate if the credentials are expired
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
