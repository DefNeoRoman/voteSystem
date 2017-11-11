package model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import util.DateTimeUtil;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {
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
  //  https://stackoverflow.com/questions/29027475/date-format-in-the-json-output-using-spring-boot
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    //with lazy not working
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @Column(name = "isVote", nullable = false, columnDefinition = "bool default false")
    private boolean isVote;

    @Column(name = "canVote", nullable = false, columnDefinition = "bool default true")
    private boolean canVote;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
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

    public void setRoles(Set<Role>roles) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registerDate=" + registerDate +
                ", roles=" + roles +
                ", isVote=" + isVote +
                ", canVote=" + canVote +
                ", enabled=" + enabled +
                '}';
    }
}
