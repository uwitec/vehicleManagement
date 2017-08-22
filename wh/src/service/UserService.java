package service;

import java.util.List;
import pojos.User;

public interface UserService {
    public void add(User user);
    public List<User> findUsers();
}
