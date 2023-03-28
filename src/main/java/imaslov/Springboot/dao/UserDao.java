package imaslov.Springboot.dao;

import imaslov.Springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void createUser(User user);
    void updateUser(long id, User updateUser);
    User readUser(long id);
    User deleteUser(long id);
}

