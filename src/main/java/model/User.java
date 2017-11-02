package model;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // PROPERTY access for id due to bug: https://hibernate.atlassian.net/browse/HHH-3718
    private Long id;
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String name;
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
    private Date registerDate;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    @BatchSize(size = 200)
    private Set<Role> roles;
    private boolean isVote;
    private boolean canVote;
    private boolean enabled;

    public User() {
        registerDate = new Date();
    }

    public User(String name,
                String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.registerDate = new Date();
        this.isVote = false;
        this.canVote = true;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRole(Set<Role>roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + password + '\'' +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", role=" + roles +
                ", isVote=" + isVote +
                ", canVote=" + canVote +
                ", enabled=" + enabled +
                '}';
    }
}
