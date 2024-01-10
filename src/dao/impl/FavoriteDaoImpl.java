package dao.impl;

import dao.FavoriteDao;
import dao.GeneralDao;
import db.Database;
import models.Favorite;
import models.User;

public class FavoriteDaoImpl implements FavoriteDao, GeneralDao<Favorite> {
    private final Database database;

    public FavoriteDaoImpl(Database database) {
        this.database = database;
    }
    @Override
    public Favorite getFavoriteByUser(User user) {
        for (Favorite favorite : database.getFavorites()) {
            if(favorite.getUser().getId() == user.getId()){
                return favorite;
            }
        }
        return null;
    }

    @Override
    public String add(Favorite favorite) {
        database.getFavorites().add(favorite);
        return "Избранное успешно добавлено!";
    }

    @Override
    public String removeById(long id) {
        for (Favorite favorite : database.getFavorites()) {
            if(favorite.getUser().getId() == id){
                database.getFavorites().remove(favorite);
                return "Успешно удален избранное!";
            }
        }
        return null;
    }

    @Override
    public String updateById(long userId, Favorite favorite) {
        for (int i = 0; i < database.getFavorites().size(); i++) {
         if(database.getFavorites().get(i).getUser().getId() == userId){
                database.getFavorites().set(i, favorite);
                return "Успешно удален избранное!";
            }
        }
        return null;
    }
}
