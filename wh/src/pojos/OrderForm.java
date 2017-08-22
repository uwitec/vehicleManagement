package pojos;
public class OrderForm {
	private int orderId;
	private String orderNumber;
	private City startCity;
	private City endCity;
	private String carType;
	private int carNumber;
	private String orderTime;
	private String allCity;
	private int orderStatus;
	private String sendorderTime;
	private String receiptTime;
	private Customer orderCustomer;
	
	
	public int getCarNumber() {
		return carNumber;
	}
	public Customer getOrderCustomer() {
		return orderCustomer;
	}
	public void setOrderCustomer(Customer orderCustomer) {
		this.orderCustomer = orderCustomer;
	}
	public String getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getSendorderTime() {
		return sendorderTime;
	}
	public void setSendorderTime(String sendorderTime) {
		this.sendorderTime = sendorderTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public City getStartCity() {
		return startCity;
	}
	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}
	public City getEndCity() {
		return endCity;
	}
	public void setEndCity(City endCity) {
		this.endCity = endCity;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public int g() {
		return carNumber;
	}
	public void setCarNumber(int carNumber) {
		this.carNumber = carNumber;
	}
	public String getAllCity() {
		return allCity;
	}
	public void setAllCity(String allCity) {
		this.allCity = allCity;
	}
	
	
}	
