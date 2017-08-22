package pojos;
public class Customer {
	private int cusId;
	private String cusName;
	private String cusTel;
	private String cusCartype;
	private String companyName;
	private String companyAddress;
	private int cusStatus;
	private String cusNumber;
	private String cusPassword;
	private City cusCity;
	
	public City getCusCity() {
		return cusCity;
	}
	public void setCusCity(City cusCity) {
		this.cusCity = cusCity;
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusTel() {
		return cusTel;
	}
	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	public String getCusCartype() {
		return cusCartype;
	}
	public void setCusCartype(String cusCartype) {
		this.cusCartype = cusCartype;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public int getCusStatus() {
		return cusStatus;
	}
	public void setCusStatus(int cusStatus) {
		this.cusStatus = cusStatus;
	}
	public String getCusNumber() {
		return cusNumber;
	}
	public void setCusNumber(String cusNumber) {
		this.cusNumber = cusNumber;
	}
	public String getCusPassword() {
		return cusPassword;
	}
	public void setCusPassword(String cusPassword) {
		this.cusPassword = cusPassword;
	}
	
}
