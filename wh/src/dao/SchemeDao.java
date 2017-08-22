package dao;

import java.util.List;

import pojos.Scheme;

public interface SchemeDao {
	public List<Scheme> getSchemeListByEndCityId(int endCityId,int type);
	public List<Scheme> getSchemeListByOrderFormId(int orderformId);
}
