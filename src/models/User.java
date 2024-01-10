package models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private long id;
    private String userNAme;
    private String email;
    private String pass;
    private Role role;
    private List<Announcement> announcements = new ArrayList<>();

    public User() {
    }

    public User(long id, String userNAme, String email, String pass, Role role) {
        this.id = id;
        this.userNAme = userNAme;
        this.email = email;
        this.pass = pass;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserNAme() {
        return userNAme;
    }

    public void setUserNAme(String userNAme) {
        this.userNAme = userNAme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", userNAme='" + userNAme + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


