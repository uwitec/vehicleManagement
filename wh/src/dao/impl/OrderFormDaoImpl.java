package dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojos.OrderForm;

import dao.OrderFormDao;

public class OrderFormDaoImpl extends HibernateDaoSupport implements OrderFormDao {

	@Override
	public void add(OrderForm orderForm) {
		super.getHibernateTemplate().save(orderForm);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderForm> getOrderFormList(int cityId,OrderForm orderForm) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM orderform WHERE  ORDER_ID IN(SELECT DISTINCT(ordercenter.ORDERFORM_ID) FROM ordercenter,scheme WHERE ordercenter.SCHEME_ID=scheme.SCHEME_ID AND (START_CITY_ID=");
		sql.append(cityId);
		sql.append(" OR END_CITY_ID=");
		sql.append(cityId);
		sql.append("))");
		if(orderForm!=null){
			if(orderForm.getEndCity()!=null&&orderForm.getEndCity().getCityId()!=0){
				sql.append(" AND END_CITY=");
				sql.append(orderForm.getEndCity().getCityId());
			}
			if(orderForm.getCarType()!=null&&!"".equals(orderForm.getCarType())){
				sql.append(" AND CAR_TYPE like '%");
				sql.append(orderForm.getCarType());
				sql.append("%'");
			}
			if(orderForm.getOrderCustomer()!=null&&orderForm.getOrderCustomer().getCusName()!=null&&!"".equals(orderForm.getOrderCustomer().getCusName())){
				sql.append(" AND CUS_ID IN(");
				sql.append("select CUS_ID FROM customer where CUS_NAME like '%");
				sql.append(orderForm.getOrderCustomer().getCusName());
				sql.append("%')");
			}
		}
		List<OrderForm> list=super.getSession().createSQLQuery(sql.toString()).addEntity(OrderForm.class).list();
		return list;
	}

	@Override
	public OrderForm getOrderFormById(int orderformId) {
		OrderForm orderForm=(OrderForm) super.getSession().createCriteria(OrderForm.class).add(Restrictions.eq("orderId", orderformId)).uniqueResult();
		return orderForm;
	}

	@Override
	public void update(OrderForm orderForm) {
		super.getHibernateTemplate().update(orderForm);
	}

}
