package db;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();

   public List<User> getAllUser(){
        return users;
   }
}
