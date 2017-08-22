package service.impl;

import java.util.List;

import pojos.OrderCenter;
import dao.OrderCenterDao;
import service.OrderCenterService;

public class OrderCenterServiceImpl implements OrderCenterService {
	private OrderCenterDao ordercenterDao;

	public OrderCenterDao getOrdercenterDao() {
		return ordercenterDao;
	}

	public void setOrdercenterDao(OrderCenterDao ordercenterDao) {
		this.ordercenterDao = ordercenterDao;
	}

	@Override
	public void add(OrderCenter orderCenter) {
		ordercenterDao.add(orderCenter);
	}

	@Override
	public List<OrderCenter> getOrderCenterListByOrderId(int orderId) {
		return ordercenterDao.getOrderCenterListByOrderId(orderId);
	}

	@Override
	public List<OrderCenter> getOrderCenterListByCityId(int cusCityId) {
		return ordercenterDao.getOrderCenterListByCityId(cusCityId);
	}

	@Override
	public int getOrderCenterCountByCityId(int orderId) {
		return ordercenterDao.getOrderCenterCountByCityId(orderId);
	}

	@Override
	public void update(int orderId, int cusCityId) {
		ordercenterDao.update(orderId, cusCityId);
	}
	
}
