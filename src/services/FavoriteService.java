package services;

import models.Favorite;
import models.User;

public interface FavoriteService {
  Favorite getFavoriteByUser(User user);
}
