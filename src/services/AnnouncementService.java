package services;

import models.Announcement;
import models.Favorite;
import models.User;

import java.util.List;

public interface AnnouncementService {
  Announcement getAnnouncementById(long id);
  List<Announcement> getAnnouncementsByUser(User owner);
  List<Announcement> getAllAnnouncements();
  List<Announcement> getAnnouncementsFromFavorite(Favorite favorite);

}
