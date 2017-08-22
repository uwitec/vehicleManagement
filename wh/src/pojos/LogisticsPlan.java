package pojos;

import java.io.Serializable;

public class LogisticsPlan implements Serializable{
	private static final long serialVersionUID = 1L;
	private int planno;
	private String departureplace;
	private String ordernumber;
	private String destination;
	private String planning;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int weight;
	public int getPlanno() {
		return planno;
	}
	public void setPlanno(int planno) {
		this.planno = planno;
	}
	public String getDepartureplace() {
		return departureplace;
	}
	public void setDepartureplace(String departureplace) {
		this.departureplace = departureplace;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPlanning() {
		return planning;
	}
	public void setPlanning(String planning) {
		this.planning = planning;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}



	
}
