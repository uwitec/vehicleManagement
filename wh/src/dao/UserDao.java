package dao;

import java.util.List;

import pojos.User;

public interface UserDao {
    public void add(User user);
    public List<User> findUsers();
}
