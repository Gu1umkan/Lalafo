package services.impl;

import models.Favorite;
import models.User;
import services.FavoriteService;
import services.GeneralService;

public class FavoriteServiceImpl implements FavoriteService, GeneralService<Favorite> {
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
