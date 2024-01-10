package services.impl;

import dao.impl.FavoriteDaoImpl;
import models.Favorite;
import models.User;
import services.FavoriteService;
import services.GeneralService;

public class FavoriteServiceImpl implements FavoriteService, GeneralService<Favorite> {
    private final FavoriteDaoImpl favoriteDao;

    public FavoriteServiceImpl(FavoriteDaoImpl favoriteDao) {
        this.favoriteDao = favoriteDao;
    }

    @Override
    public Favorite getFavoriteByUser(User user) {
        return favoriteDao.getFavoriteByUser(user);
    }

    @Override
    public String add(Favorite favorite) {
        return favoriteDao.add(favorite);
    }

    @Override
    public String removeById(long id) {
        return favoriteDao.removeById(id);
    }

    @Override
    public String updateById(long id, Favorite favorite) {
        return favoriteDao.updateById(id, favorite);
    }
}
