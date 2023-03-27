package imaslov.Springboot.service;

import imaslov.Springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void createUser(User user);
    void updateUser(long id, User updateUser);
    User readUser(long id);
    User deleteUser(long id);
}
