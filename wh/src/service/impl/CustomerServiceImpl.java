package service.impl;

import java.util.List;

import pojos.Customer;
import dao.CustomerDao;
import service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> getCustomerList() {
		return customerDao.getCustomerList();
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int cusId) {
		return customerDao.getCustomerById(cusId);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);
	}

	@Override
	public Customer getCustomerByNumber(String customerNumber) {
		return customerDao.getCustomerByNumber(customerNumber);
	}
	
}
