package service.impl;


import pojos.Users;
import dao.UsersDao;
import service.UsersService;
public class UsersServiceImpl implements UsersService
{	
	private UsersDao usersDao;
	
	public UsersDao getUsersDao()
	{
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao)
	{
		this.usersDao = usersDao;
	}

	@Override
	public Users getUsersByName(String username) 
	{
		return usersDao.getUsersByName(username);
	}
}
