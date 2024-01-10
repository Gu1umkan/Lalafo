package models;

import java.util.ArrayList;
import java.util.List;

public class Favorite {
    private User user;
    private List<Announcement> announcements = new ArrayList<>();

    public Favorite() {
    }

    public Favorite(User userName, List<Announcement> announcements) {
        this.user = userName;
        this.announcements = announcements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<Announcement> announcement) {
        this.announcements = announcement;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "userName=" + user +
                ", announcements =" + announcements +
                '}';
    }
}

