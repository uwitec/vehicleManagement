package dao.impl;


import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UsersDao;

import pojos.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao
{
	@Override
	public Users getUsersByName(String userName) 
	{
		Users users=(Users) super.getSession().createCriteria(Users.class).add(Restrictions.eq("username", userName.trim())).uniqueResult();
		return users;
	}
}
