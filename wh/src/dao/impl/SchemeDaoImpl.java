package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojos.Scheme;

import dao.SchemeDao;

public class SchemeDaoImpl extends HibernateDaoSupport implements SchemeDao {
	@SuppressWarnings("unchecked")
	public List<Scheme> getSchemeListByEndCityId(int endCityId,int type){
		List<Scheme> list=new ArrayList<Scheme>();
		while (true) {
			List<Scheme> schemes=super.getSession().createCriteria(Scheme.class).createCriteria("endCity").add(Restrictions.eq("cityId", endCityId)).list();
			//循环方案
			if(schemes.size()>1){//如果存在两种方案
				for (Scheme scheme : schemes) {
					System.err.println(scheme.getSchemeType());
					if(type==1){//非周二、周六
						if(scheme.getSchemeType()==1){//走铁路或公路
							list.add(scheme);
							endCityId=scheme.getStartCity().getCityId();
						}
					}else{
						if(scheme.getSchemeType()!=1){//走江路或海路
							list.add(scheme);
							endCityId=scheme.getStartCity().getCityId();
						}
					}
					
				}
			}else {
				list.add(schemes.get(0));
				endCityId=schemes.get(0).getStartCity().getCityId();
			}
			if(endCityId==1){
				break;
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Scheme> getSchemeListByOrderFormId(int orderformId) {
		StringBuffer sql=new StringBuffer();
		sql.append("SELECT * FROM scheme WHERE scheme_id IN(SELECT Scheme_id FROM ordercenter WHERE orderform_id=");
		sql.append(orderformId);
		sql.append(")");
		List<Scheme> list=super.getSession().createSQLQuery(sql.toString()).addEntity(Scheme.class).list();
		return list;
 	}
}
