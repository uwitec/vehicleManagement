package dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojos.Customer;

import dao.CustomerDao;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomerList() {
		List<Customer> list=super.getSession().createCriteria(Customer.class).list();
		return list;
	}

	@Override
	public void updateCustomer(Customer customer) {
		super.getHibernateTemplate().saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomerById(int cusId) {
		return (Customer) super.getSession().createCriteria(Customer.class).add(Restrictions.eq("cusId", cusId)).uniqueResult();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		super.getHibernateTemplate().delete(customer);
	}

	@Override
	public Customer getCustomerByNumber(String customerNumber) {
		Customer customer=(Customer) super.getSession().createCriteria(Customer.class).add(Restrictions.eq("cusNumber", customerNumber.trim())).uniqueResult();
		return customer;
	}

}
