package dao;

import java.util.List;

import pojos.Customer;

public interface CustomerDao {
	public List<Customer> getCustomerList();
	public void updateCustomer(Customer customer);
	public Customer getCustomerById(int cusId);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerByNumber(String customerNumber);
}
