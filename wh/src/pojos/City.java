package pojos;
public class City {
	private int cityId;
	private String cityName;
	private int transit;
	private int storage;
	
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getTransit() {
		return transit;
	}
	public void setTransit(int transit) {
		this.transit = transit;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
