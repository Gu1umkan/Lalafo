package services.impl;

import dao.impl.UserDaoImpl;
import models.User;
import services.GeneralService;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService, GeneralService<User> {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public String add(User user) {
        return userDao.add(user);
    }

    @Override
    public String removeById(long id) {
        return userDao.removeById(id);
    }

    @Override
    public String updateById(long id, User user) {
        return userDao.updateById(id, user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }
}
