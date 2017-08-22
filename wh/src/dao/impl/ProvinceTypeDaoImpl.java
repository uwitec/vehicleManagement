package dao.impl;

import pojos.ProvinceType;
import dao.ProvinceTypeDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ProvinceTypeDaoImpl extends HibernateDaoSupport implements ProvinceTypeDao{
	@Override
	public ProvinceType getProvinceTpyeByName(String provincename) {
		ProvinceType provincetype=(ProvinceType) super.getSession().createCriteria(ProvinceType.class).add(Restrictions.eq("provincename", provincename.trim())).uniqueResult();
		return provincetype;
	}

}
