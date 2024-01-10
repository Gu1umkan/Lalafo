package models;

public class Favorite {
    private User user;
    private Announcement announcement;

    public Favorite() {
    }

    public Favorite(User userName, Announcement announcement) {
        this.user = userName;
        this.announcement = announcement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "userName=" + user +
                ", announcement=" + announcement +
                '}';
    }
}

