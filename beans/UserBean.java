package beans;

import java.util.Arrays;

public class UserBean {
	private String email,password,address,pancard,city;

	private String[] userType;
	private long mobile,postal;
	private int delivery,reciever,provider;
	
	
	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password + ", address=" + address + ", pancard=" + pancard
				+ ", city=" + city + ", userType=" + Arrays.toString(userType) + ", mobile=" + mobile + ", postal="
				+ postal + ", delivery=" + delivery + ", reciever=" + reciever + ", provider=" + provider + "]";
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public long getPostal() {
		return postal;
	}

	public void setPostal(long postal) {
		this.postal = postal;
	}

	public int getDelivery() {
		return delivery;
	}

	public void setDelivery(int delivery) {
		this.delivery = delivery;
	}

	public int getReciever() {
		return reciever;
	}

	public void setReciever(int reciever) {
		this.reciever = reciever;
	}

	public int getProvider() {
		return provider;
	}

	public void setProvider(int provider) {
		this.provider = provider;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getUserType() {
		String userTypeAll = "";
		for(int i=0;i<userType.length;i++)
			userTypeAll+=userType[i];
		return userTypeAll;
	}
	public void setUserType(String[] userType) {
		this.userType = userType;
		for(int i=0;i<userType.length;i++)
		{
			if(userType[i].equals("Provider"))
				setProvider(1);
			if(userType[i].equals("Delivery"))
				setDelivery(1);
			if(userType[i].equals("Reciever"))
				setReciever(1);
		}
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
}
