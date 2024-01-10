package services.impl;

import models.Announcement;
import models.Favorite;
import models.User;
import services.AnnouncementService;
import services.GeneralService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService, GeneralService<Announcement> {
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
