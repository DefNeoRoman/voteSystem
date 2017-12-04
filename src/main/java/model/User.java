package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Long id;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String username;
    @Column(name = "email", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String email;
    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String password;
    @Column(name = "register_date", columnDefinition = "timestamp default now()")
    @NotNull
    //  https://stackoverflow.com/questions/29027475/date-format-in-the-json-output-using-spring-boot
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    //with lazy not working
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> authorities;

    @Column(name = "isVote", nullable = false, columnDefinition = "bool default false")
    private boolean isVote;

    @Column(name = "canVote", nullable = false, columnDefinition = "bool default true")
    private boolean canVote;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    public User() {
        registerDate = new Date();
    }

    public User(String username,
                String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.registerDate = new Date();
        this.isVote = false;
        this.canVote = true;
        this.enabled = true;
    }

    public User(Long id, String username,
                String email, String password, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.registerDate = new Date();
        this.isVote = false;
        this.canVote = true;
        this.enabled = true;

    }

    public User(String username, String password,Set<Role>  authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.registerDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public boolean isVote() {
        return isVote;
    }

    public void setVote(boolean vote) {
        isVote = vote;
    }

    public boolean isCanVote() {
        return canVote;
    }

    public void setCanVote(boolean canVote) {
        this.canVote = canVote;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +

                ", isVote=" + isVote +
                ", canVote=" + canVote +
                ", enabled=" + enabled +
                '}';
    }
}
