package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User extends BaseEntity {
    private String password;
    private String email;
    private Date registerDate;
    private Role role;
    private boolean isVote;
    private boolean canVote;
    private boolean enabled;

    public User() {
        registerDate = new Date();
    }

    public User(Integer id, String name,
                String email, String password,
                Role role) {
        super(id, name);
        this.password = password;
        this.role = role;
        this.email = email;
        this.registerDate = new Date();
        this.isVote = false;
        this.canVote = true;
        this.enabled = true;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registerDate=" + registerDate +
                ", role=" + role +
                ", isVote=" + isVote +
                ", canVote=" + canVote +
                ", enabled=" + enabled +
                '}';
    }
}
