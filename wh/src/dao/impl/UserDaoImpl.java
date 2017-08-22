package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.UserDao;

import pojos.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
     public void add(User user){
    	 getHibernateTemplate().save(user);
     }

	@SuppressWarnings("unchecked")
	public List<User> findUsers() {
		List<User> list=(List<User>)getHibernateTemplate().execute(
   			 new HibernateCallback(){
   				 public Object doInHibernate(Session session)
   				         throws HibernateException,SQLException{
   					 Query query=session.createQuery("from User");
   					 return query.list();
   				 }
   			 });
   	 return list;
	}
}
