package pojos;
public class OrderCenter {
	private int ordercenterId;
	private int orderformId;
	private Scheme scheme;
	private int status;
	private String startTime;
	private String endTime;
	private String transportMode;
	
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public int getOrdercenterId() {
		return ordercenterId;
	}
	public void setOrdercenterId(int ordercenterId) {
		this.ordercenterId = ordercenterId;
	}
	public int getOrderformId() {
		return orderformId;
	}
	public void setOrderformId(int orderformId) {
		this.orderformId = orderformId;
	}
	
	public Scheme getScheme() {
		return scheme;
	}
	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
