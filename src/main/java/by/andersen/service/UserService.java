package by.andersen.service;

import by.andersen.model.User;

import java.util.List;

public interface UserService {
    int save(User user);
    User get(int id);
    List<User> list();
    void update(int id, User user);
    void delete(int id);
}
