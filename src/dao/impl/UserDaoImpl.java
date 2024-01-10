package dao.impl;

import dao.GeneralDao;
import dao.UserDao;
import models.User;

import java.util.List;

public class UserDaoImpl implements UserDao, GeneralDao<User> {
    @Override
    public String add(User user) {
        return null;
    }

    @Override
    public String removeById(long id) {
        return null;
    }

    @Override
    public String updateById(long id, User user) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }
}
