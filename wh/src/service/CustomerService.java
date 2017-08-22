package service;

import java.util.List;

import pojos.Customer;

public interface CustomerService {
	public List<Customer> getCustomerList();
	public void updateCustomer(Customer customer);
	public Customer getCustomerById(int cusId);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerByNumber(String customerNumber);
}
