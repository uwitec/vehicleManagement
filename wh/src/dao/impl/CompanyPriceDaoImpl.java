package dao.impl;

import java.util.List;
import pojos.CompanyPrice;
import dao.CompanyPriceDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CompanyPriceDaoImpl extends HibernateDaoSupport implements CompanyPriceDao{
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CompanyPrice> getCompanyPriceList()
	{	
		List<CompanyPrice> list = super.getSession().createCriteria(CompanyPrice.class).list();
		return list;
	}

}
