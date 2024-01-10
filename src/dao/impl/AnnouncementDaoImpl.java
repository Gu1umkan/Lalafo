package dao.impl;

import dao.AnnouncementDao;
import dao.GeneralDao;
import models.Announcement;
import models.Favorite;
import models.User;

import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao, GeneralDao<Announcement> {
    @Override
    public Announcement getAnnouncementById(long id) {
        return null;
    }

    @Override
    public List<Announcement> getAnnouncementsByUser(User owner) {
        return null;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return null;
    }

    @Override
    public List<Announcement> getAnnouncementsFromFavorite(Favorite favorite) {
        return null;
    }

    @Override
    public String add(Announcement announcement) {
        return null;
    }

    @Override
    public String removeById(long id) {
        return null;
    }

    @Override
    public String updateById(long id, Announcement announcement) {
        return null;
    }
}
