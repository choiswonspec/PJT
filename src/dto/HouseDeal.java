package dto;

public class HouseDeal {
	//리스트부분
	private int aptCode;
	private String aptName;
	private String dongName;
	private String dealAmount;
	private String area;
	private String floor;
	private String type;
	private String lat;
	private String lng;
	
	public HouseDeal(int aptCode, String aptName, String dongName, String dealAmount, String area, String floor,
			String type, String lat, String lng) {
		super();
		this.aptCode = aptCode;
		this.aptName = aptName;
		this.dongName = dongName;
		this.dealAmount = dealAmount;
		this.area = area;
		this.floor = floor;
		this.type = type;
		this.lat = lat;
		this.lng = lng;
	}
	public HouseDeal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getAptCode() {
		return aptCode;
	}
	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDongName() {
		return dongName;
	}
	public void setDongName(String dongName) {
		this.dongName = dongName;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "HouseDeal [aptCode=" + aptCode + ", aptName=" + aptName + ", dongName=" + dongName + ", dealAmount="
				+ dealAmount + ", area=" + area + ", floor=" + floor + ", type=" + type + ", lat=" + lat + ", lng="
				+ lng + "]";
	}
	
	
	
}
