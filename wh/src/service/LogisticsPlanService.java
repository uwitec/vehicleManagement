package service;

import java.util.List;

import pojos.LogisticsPlan;

public interface LogisticsPlanService {
	public void add(LogisticsPlan logisticplan,String ordernumber);
	public List<LogisticsPlan> nocalorderlist();
	public LogisticsPlan getlogisticsplanByNum(String ordernumber);
}
