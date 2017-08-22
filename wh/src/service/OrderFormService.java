package service;

import java.util.List;

import pojos.OrderForm;

public interface OrderFormService {
	public void add(OrderForm orderForm);
	public List<OrderForm> getOrderFormList(int cityId,OrderForm orderForm);
	public OrderForm getOrderFormById(int orderformId);
	public void update(OrderForm orderForm);
}
