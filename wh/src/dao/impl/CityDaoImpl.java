package dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import pojos.City;

import dao.CityDao;

public class CityDaoImpl extends HibernateDaoSupport implements CityDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCityList() {
		List<City> list=super.getSession().createQuery("from City c where c.cityId<>1").list();
		return list; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCityList() {
		List<City> list=super.getSession().createQuery("from City").list();
		return list;
	}

}
