package service.impl;

import java.util.List;

import dao.CityDao;

import pojos.City;
import service.CityService;

public class CityServiceImpl implements CityService {

	private CityDao cityDao;
	
	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public List<City> getCityList() {
		return cityDao.getCityList();
	}

	@Override
	public List<City> getAllCityList() {
		return cityDao.getAllCityList();
	}

}
