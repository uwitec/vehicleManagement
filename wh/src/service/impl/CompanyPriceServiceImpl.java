package service.impl;

import java.util.List;
import pojos.CompanyPrice;
import service.CompanyPriceService;
import dao.CompanyPriceDao;

public class CompanyPriceServiceImpl implements CompanyPriceService {
	private CompanyPriceDao companypricedao;

	public CompanyPriceDao getCompanypricedao() {
		return companypricedao;
	}

	public void setCompanypricedao(CompanyPriceDao companypricedao) {
		this.companypricedao = companypricedao;
	}
	
	@Override
	public List<CompanyPrice> getCompanyPriceList() {
		return companypricedao.getCompanyPriceList();
	}
}
