package models;

public class Favorite {
    private User userName;
    private Announcement announcement;

    public Favorite() {
    }

    public Favorite(User userName, Announcement announcement) {
        this.userName = userName;
        this.announcement = announcement;
    }

    public User getUserName() {
        return userName;
    }

    public void setUserName(User userName) {
        this.userName = userName;
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
                "userName=" + userName +
                ", announcement=" + announcement +
                '}';
    }
}

