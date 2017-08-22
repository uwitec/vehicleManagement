package service.impl;

import pojos.ProvinceType;
import dao.ProvinceTypeDao;
import service.ProvinceTypeService;

public class ProvinceTypeServiceImpl implements ProvinceTypeService{
	private ProvinceTypeDao privincetypedao;

	public ProvinceTypeDao getPrivincetypedao() {
		return privincetypedao;
	}

	public void setPrivincetypedao(ProvinceTypeDao privincetypedao) {
		this.privincetypedao = privincetypedao;
	}
	
	@Override
	public ProvinceType getProvinceTypeByName(String provincename)
	{
		return privincetypedao.getProvinceTpyeByName(provincename);
	}
	
}
