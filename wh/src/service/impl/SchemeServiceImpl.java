package service.impl;

import java.util.List;

import pojos.Scheme;
import dao.SchemeDao;
import service.SchemeService;

public class SchemeServiceImpl implements SchemeService {
	private SchemeDao schemeDao;

	public SchemeDao getSchemeDao() {
		return schemeDao;
	}

	public void setSchemeDao(SchemeDao schemeDao) {
		this.schemeDao = schemeDao;
	}
	public List<Scheme> getSchemeListByEndCityId(int endCityId,int type){
		return schemeDao.getSchemeListByEndCityId(endCityId,type);
	}

	@Override
	public List<Scheme> getSchemeListByOrderFormId(int orderformId) {
		return schemeDao.getSchemeListByOrderFormId(orderformId);
	}
	
}
