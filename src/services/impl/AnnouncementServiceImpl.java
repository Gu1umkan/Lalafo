package services.impl;

import dao.AnnouncementDao;
import dao.impl.AnnouncementDaoImpl;
import models.Announcement;
import models.Favorite;
import models.User;
import services.AnnouncementService;
import services.GeneralService;

import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService, GeneralService<Announcement> {
    private final AnnouncementDaoImpl announcementDao;

    public AnnouncementServiceImpl(AnnouncementDaoImpl announcementDao) {
        this.announcementDao = announcementDao;
    }

    @Override
    public Announcement getAnnouncementById(long id) {
        return announcementDao.getAnnouncementById(id);
    }

    @Override
    public List<Announcement> getAnnouncementsByUser(User owner) {
        return announcementDao.getAnnouncementsByUser(owner);
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementDao.getAllAnnouncements();
    }

    @Override
    public List<Announcement> getAnnouncementsFromFavorite(Favorite favorite) {
        return announcementDao.getAnnouncementsFromFavorite(favorite);
    }

    @Override
    public String add(Announcement announcement) {
        return announcementDao.add(announcement);
    }

    @Override
    public String removeById(long id) {
        return announcementDao.removeById(id);
    }

    @Override
    public String updateById(long id, Announcement announcement) {
        return announcementDao.updateById(id, announcement);
    }
}
