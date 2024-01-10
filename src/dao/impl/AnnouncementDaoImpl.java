package dao.impl;

import dao.AnnouncementDao;
import dao.GeneralDao;
import db.Database;
import models.Announcement;
import models.Favorite;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao, GeneralDao<Announcement> {
    private final Database database;

    public AnnouncementDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public Announcement getAnnouncementById(long id) {
        for (Announcement announcement : database.getAnnouncements()) {
            if (announcement.getId() == id) {
                return announcement;
            }
        }
        return null;
    }

    @Override
    public List<Announcement> getAnnouncementsByUser(User owner) {
        List<Announcement> announcements = new ArrayList<>();
        for (Announcement allAnnouncement : getAllAnnouncements()) {
            if (allAnnouncement.getOwner().getId() == owner.getId()) {
                announcements.add(allAnnouncement);
            }
        }
        return announcements;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return database.getAnnouncements();
    }

    @Override
    public List<Announcement> getAnnouncementsFromFavorite(Favorite favorite) {
        for (Favorite databaseFavorite : database.getFavorites()) {
            if (databaseFavorite.getUser().getId() == favorite.getUser().getId()) {
                return databaseFavorite.getAnnouncements();
            }
        }
        return null;
    }

    @Override
    public String add(Announcement announcement) {
        database.getAnnouncements().add(announcement);
        return "Успешно добавлено!";
    }

    @Override
    public String removeById(long id) {
        for (Announcement announcement : getAllAnnouncements()) {
            if (announcement.getId() == id) {
                getAllAnnouncements().remove(announcement);
                for (Favorite favorite : database.getFavorites()) {
                    for (Announcement favoriteAnnouncement : favorite.getAnnouncements()) {
                        if (favoriteAnnouncement.getId() == id) {
                            favorite.getAnnouncements().remove(favoriteAnnouncement);
                        }
                    }
                }
                return "Объявление успешно изменено!";
            }
        }
        return "Неправильный id";
    }

    @Override
    public String updateById(long id, Announcement announcement) {
        for (int i = 0; i < getAllAnnouncements().size(); i++) {
            if (getAllAnnouncements().get(i).getId() == id) {
                getAllAnnouncements().set(i, announcement);
                for (Favorite favorite : database.getFavorites()) {
                    for (int i1 = 0; i1 < favorite.getAnnouncements().size(); i1++) {
                        if (favorite.getAnnouncements().get(i).getId() == id) {
                            favorite.getAnnouncements().set(i, announcement);
                        }
                    }
                }
                return "Объявление успешно изменено!";
            }
        }
        return "Неправильный id";
    }
}
