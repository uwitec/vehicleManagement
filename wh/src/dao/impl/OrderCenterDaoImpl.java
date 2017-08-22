package dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojos.OrderCenter;

import dao.OrderCenterDao;

public class OrderCenterDaoImpl extends HibernateDaoSupport implements OrderCenterDao {

	@Override
	public void add(OrderCenter orderCenter) {
		super.getHibernateTemplate().save(orderCenter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderCenter> getOrderCenterListByOrderId(int orderId) {
		List<OrderCenter> list=super.getSession().createCriteria(OrderCenter.class).add(Restrictions.eq("orderformId", orderId)).addOrder(Order.desc("ordercenterId")).list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderCenter> getOrderCenterListByCityId(int cusCityId) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM ordercenter WHERE SCHEME_ID IN(SELECT SCHEME_ID FROM scheme WHERE END_CITY_ID IN(SELECT CASE WHEN(START_CITY_ID=1) THEN ");
		sql.append(cusCityId);
		sql.append(" ELSE START_CITY_ID END FROM scheme WHERE END_CITY_ID=");
		sql.append(cusCityId);
		sql.append("))");
		List<OrderCenter> list=super.getSession().createSQLQuery(sql.toString()).addEntity(OrderCenter.class).list();
		return list;
	}

	@Override
	public int getOrderCenterCountByCityId(int orderId) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT COUNT(1) FROM ordercenter WHERE STATUS=1 AND ORDERFORM_ID=");
		sql.append(orderId);
		int count=Integer.valueOf(String.valueOf(super.getSession().createSQLQuery(sql.toString()).uniqueResult()));
		return count;
	}

	@Override
	public void update(int orderId, int cusCityId) {
		StringBuffer sql=new StringBuffer();
		sql.append("UPDATE ordercenter SET STATUS=2 WHERE ORDERFORM_ID=");
		sql.append(orderId);
		sql.append(" AND SCHEME_ID IN (SELECT SCHEME_ID FROM scheme WHERE END_CITY_ID=");
		sql.append(cusCityId);
		sql.append(")");
		super.getSession().createSQLQuery(sql.toString()).executeUpdate();
	}
}
