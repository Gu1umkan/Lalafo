package db;

import models.Announcement;
import models.Favorite;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private final List<User> users = new ArrayList<>();
    private final List<Announcement> announcements = new ArrayList<>();
    private final List<Favorite> favorites = new ArrayList<>();

    public List<User> getAllUser() {
        return users;
    }

    public List<Announcement> getAnnouncements() {
        return announcements;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }
}
