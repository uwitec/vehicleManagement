package service;

import java.util.List;

import pojos.Scheme;

public interface SchemeService {
	public List<Scheme> getSchemeListByEndCityId(int endCityId,int type);
	public List<Scheme> getSchemeListByOrderFormId(int orderformId);
}
