package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    List<User> getAllUsers();
}
