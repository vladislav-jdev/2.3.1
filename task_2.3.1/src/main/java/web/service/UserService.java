package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
