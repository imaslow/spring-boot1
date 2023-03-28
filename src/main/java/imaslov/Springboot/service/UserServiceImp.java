package imaslov.Springboot.service;

import imaslov.Springboot.dao.UserDao;
import imaslov.Springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImp implements UserService {
    private final UserDao userDao;
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
    @Override
    public void updateUser(long id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }
    @Override
    public User readUser(long id) {
        return userDao.readUser(id);
    }

    @Override
    public User deleteUser(long id) {
        User user = null;
        try {
            user = userDao.deleteUser(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return user;
    }
}
