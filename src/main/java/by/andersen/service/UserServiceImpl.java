package by.andersen.service;

import by.andersen.dao.UserDao;
import by.andersen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    @Transactional
    public int save(User user) {
        return userDao.save(user);
    }

    public User get(int id) {
        return userDao.get(id);
    }

    public List<User> list() {
        return userDao.list();
    }

    @Transactional
    public void update(int id, User user) {
        userDao.update(id,user);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
