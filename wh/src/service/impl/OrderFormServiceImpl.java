package service.impl;

import java.util.List;

import pojos.OrderForm;
import dao.OrderFormDao;
import service.OrderFormService;

public class OrderFormServiceImpl implements OrderFormService {
	private OrderFormDao orderFormDao;

	public OrderFormDao getOrderFormDao() {
		return orderFormDao;
	}

	public void setOrderFormDao(OrderFormDao orderFormDao) {
		this.orderFormDao = orderFormDao;
	}

	@Override
	public void add(OrderForm orderForm) {
		orderFormDao.add(orderForm);
	}

	@Override
	public List<OrderForm> getOrderFormList(int cityId,OrderForm orderForm) {
		return orderFormDao.getOrderFormList(cityId,orderForm);
	}

	@Override
	public OrderForm getOrderFormById(int orderformId) {
		return orderFormDao.getOrderFormById(orderformId);
	}

	@Override
	public void update(OrderForm orderForm) {
		orderFormDao.update(orderForm);
	}
	
}
