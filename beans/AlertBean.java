package beans;

import java.sql.Date;
import java.sql.Time;

public class AlertBean {
	String email,foodOption,foodType;
	int plates,id,left_plates;
	public int getLeft_plates() {
		return left_plates;
	}
	public void setLeft_plates(int left_plates) {
		this.left_plates = left_plates;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	Date reqDate;
	Time reqTime;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFoodOption() {
		return foodOption;
	}
	public void setFoodOption(String foodOption) {
		this.foodOption = foodOption;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getPlates() {
		return plates;
	}
	public void setPlates(int plates) {
		this.plates = plates;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public Time getReqTime() {
		return reqTime;
	}
	public void setReqTime(Time reqTime) {
		this.reqTime = reqTime;
	}
	@Override
	public String toString() {
		return "AlertBean [email=" + email + ", foodOption=" + foodOption + ", foodType=" + foodType + ", plates="
				+ plates + ", reqDate=" + reqDate + ", reqTime=" + reqTime + "]";
	}
}
