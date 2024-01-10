package dao;

import models.Favorite;
import models.User;

public interface FavoriteDao {
    Favorite getFavoriteByUser(User user);
}
