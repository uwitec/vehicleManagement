package dao.impl;

import java.util.List;
import pojos.LogisticsPlan;
import dao.LogisticsPlanDao;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class LogisticsPlanDaoImpl extends HibernateDaoSupport implements LogisticsPlanDao{
	@Override
	public void add(LogisticsPlan logisticsplan,String ordernumber) {
		StringBuffer sql=new StringBuffer();
		sql.append("update logisticsplan set planning='"+logisticsplan.getPlanning()+"' where ordernum='"+ordernumber+"'");
		super.getSession().createSQLQuery(sql.toString()).executeUpdate();
	}

	@Override
	public List<LogisticsPlan> nocalorderlist() {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM logisticsplan WHERE planning is NULL");
		List<LogisticsPlan> list=super.getSession().createSQLQuery(sql.toString()).addEntity(LogisticsPlan.class).list();
		return list;
	}

	@Override
	public LogisticsPlan getlogisticsplanByNum(String ordernumber) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM logisticsplan WHERE ordernum='"+ordernumber+"'");
		List<LogisticsPlan> lp=super.getSession().createSQLQuery(sql.toString()).addEntity(LogisticsPlan.class).list();
		return lp.get(0);
	}

}
