package service;

import java.util.List;

import pojos.OrderCenter;

public interface OrderCenterService {
	public void add(OrderCenter orderCenter);
	public List<OrderCenter> getOrderCenterListByOrderId(int orderId);
	public List<OrderCenter> getOrderCenterListByCityId(int cusCityId);
	public int getOrderCenterCountByCityId(int orderId);
	public void update(int orderId, int cusCityId);
}
