package pojos;
public class Scheme {
	private int schemeId;
	private City startCity;
	private City endCity;
	private int schemeDistance;
	private int schemeType;
	public int getSchemeId() {
		return schemeId;
	}
	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
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
	public int getSchemeDistance() {
		return schemeDistance;
	}
	public void setSchemeDistance(int schemeDistance) {
		this.schemeDistance = schemeDistance;
	}
	public int getSchemeType() {
		return schemeType;
	}
	public void setSchemeType(int schemeType) {
		this.schemeType = schemeType;
	}
	
}
