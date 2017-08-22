package service;

import java.util.List;

import dao.UserDao;

import pojos.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
       userDao.add(user);
	}

	@Override
	public List<User> findUsers() {
		return userDao.findUsers();
	}

}
