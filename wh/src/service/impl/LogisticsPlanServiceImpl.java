package service.impl;

import java.util.List;

import dao.LogisticsPlanDao;
import pojos.LogisticsPlan;
import service.LogisticsPlanService;;
public class LogisticsPlanServiceImpl implements LogisticsPlanService {
	private LogisticsPlanDao logisticsplandoa;

	public LogisticsPlanDao getLogisticsplandoa() {
		return logisticsplandoa;
	}

	public void setLogisticsplandoa(LogisticsPlanDao logisticsplandoa) {
		this.logisticsplandoa = logisticsplandoa;
	}

	@Override
	public void add(LogisticsPlan logisticsplan,String ordernumber) {
		logisticsplandoa.add(logisticsplan,ordernumber);
	}

	@Override
	public List<LogisticsPlan> nocalorderlist() {
		// TODO Auto-generated method stub
		return logisticsplandoa.nocalorderlist();
	}

	@Override
	public LogisticsPlan getlogisticsplanByNum(String ordernumber) {
		// TODO Auto-generated method stub
		return logisticsplandoa.getlogisticsplanByNum(ordernumber);
	}



}
