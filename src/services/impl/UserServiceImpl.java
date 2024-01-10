package services.impl;

import models.User;
import services.GeneralService;
import services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService, GeneralService<User> {
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
