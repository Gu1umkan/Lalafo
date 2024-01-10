package dao.impl;

import dao.FavoriteDao;
import dao.GeneralDao;
import models.Favorite;
import models.User;

public class FavoriteDaoImpl implements FavoriteDao, GeneralDao<Favorite> {
    @Override
    public Favorite getFavoriteByUser(User user) {
        return null;
    }

    @Override
    public String add(Favorite favorite) {
        return null;
    }

    @Override
    public String removeById(long id) {
        return null;
    }

    @Override
    public String updateById(long id, Favorite favorite) {
        return null;
    }
}
