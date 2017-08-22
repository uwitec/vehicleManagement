package action;

import java.util.List;
import java.util.Locale;




import net.sf.cglib.core.Local;
import sun.util.resources.LocaleData;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import method.MainCalculation;
import pojos.LogisticsPlan;
import service.LogisticsPlanService;

public class TastAction extends ActionSupport{
	private LogisticsPlan logisticsplan;
	private List<LogisticsPlan> nocalorderlist;
	
	public List<LogisticsPlan> getNocalorderlist() {
		return nocalorderlist;
	}
	public void setNocalorderlist(List<LogisticsPlan> nocalorderlist) {
		this.nocalorderlist = nocalorderlist;
	}

	private LogisticsPlanService logisticsplanservice;
	
	private MainCalculation maincalculation;
	private String uu=null;
	
	public String getUu() {
		return uu;
	}
	public void setUu(String uu) {
		this.uu = uu;
	}
	public LogisticsPlanService getLogisticsplanservice() {
		return logisticsplanservice;
	}
	public void setLogisticsplanservice(LogisticsPlanService logisticsplanservice) {
		this.logisticsplanservice = logisticsplanservice;
	}


	public LogisticsPlan getLogisticsplan() {
		return logisticsplan;
	}
	public void setLogisticsplan(LogisticsPlan logisticsplan) {
		this.logisticsplan = logisticsplan;
	}
	public MainCalculation getMaincalculation() {
		return maincalculation;
	}
	public void setMaincalculation(MainCalculation maincalculation) {
		this.maincalculation = maincalculation;
	}
	@SuppressWarnings("unchecked")
	public String generateplan()
	{  	 
		
		logisticsplan=logisticsplanservice.getlogisticsplanByNum(logisticsplan.getOrdernumber());
		System.out.println(logisticsplan.getOrdernumber());
    	String departureplace=logisticsplan.getDepartureplace();
    	String destination=logisticsplan.getDestination();
    	int weight=(int)logisticsplan.getWeight();
    	String ordernumber=logisticsplan.getOrdernumber();
    	
    	String planning=null;
    	
    	planning=maincalculation.maincalculation(departureplace, destination, weight);/////////////////////////////
    	
    	logisticsplan.setPlanning(planning);
    	//logisticsplan.setWeight(11);
    	logisticsplan.setWeight(weight);
    	logisticsplanservice.add(logisticsplan,ordernumber);
    	return SUCCESS;  	
    	
    }
    
    public String uploadplan()
    {
    	uu="±£´æ³É¹¦";
		return SUCCESS;
    }
    
    public String nocalorderlist()
    {
    	nocalorderlist=logisticsplanservice.nocalorderlist();
    	ActionContext.getContext().getSession().put("nocalorderlist", nocalorderlist);
    	return "nocalorderlist";
    }
	
}
