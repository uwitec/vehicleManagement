package dao;

import java.util.List;

import pojos.LogisticsPlan;

public interface LogisticsPlanDao {
	public void add(LogisticsPlan logisticsplan,String ordernumber);
	public List<LogisticsPlan> nocalorderlist();
	public LogisticsPlan getlogisticsplanByNum(String ordernumber);
}
