package dao.impl;

import dao.GeneralDao;
import dao.UserDao;
import db.Database;
import models.User;

import java.util.List;

public class UserDaoImpl implements UserDao, GeneralDao<User> {
    private final Database database;

    public UserDaoImpl(Database database) {
        this.database = database;
    }
    @Override
    public String add(User user) {
        database.getAllUser().add(user);
        return "Пользователь успешно добавлен!";
    }

    @Override
    public String removeById(long id) {
        for (User user : database.getAllUser()) {
            if(user.getId() == id){
                database.getAllUser().remove(user);
                return "Пользователь успешно удален!";
            }
        }
        return  null;
    }

    @Override
    public String updateById(long id, User user) {
        for (int i = 0; i < database.getAllUser().size(); i++) {
            if(database.getAllUser().get(i).getId() == id){
                database.getAllUser().set(i, user);
                return "Пользователь успешно изменен!";
            }
        }
        return  null;
    }

    @Override
    public List<User> getAllUsers() {
        return database.getAllUser();
    }

    @Override
    public User getUserById(long id) {
        for (User user : database.getAllUser()) {
            if(user.getId() == id){
                return user;
            }
        }
        return  null;
    }
}
