package models;

import java.util.List;

public class Favorite {
    private User userName;
    private List<Announcement> announcement;

    public Favorite() {
    }

    public Favorite(User userName, List<Announcement> announcement) {
        this.userName = userName;
        this.announcement = announcement;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
    }

    public List<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(List<Announcement> announcement) {
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "userName=" + userName +
                ", announcement=" + announcement +
                '}';
    }
}

