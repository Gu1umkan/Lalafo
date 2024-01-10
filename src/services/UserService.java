package services;

import models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);

}
