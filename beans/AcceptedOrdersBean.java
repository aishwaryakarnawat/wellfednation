package beans;

public class AcceptedOrdersBean {
	
	private int order_id,accepted_plates,accepted_order_id ;
	private String providerEmail,recieverEmail;
	
	
	public int getAccepted_order_id() {
		return accepted_order_id;
	}
	public void setAccepted_order_id(int accepted_order_id) {
		this.accepted_order_id = accepted_order_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAccepted_plates() {
		return accepted_plates;
	}
	public void setAccepted_plates(int accepted_plates) {
		this.accepted_plates = accepted_plates;
	}
	public String getProviderEmail() {
		return providerEmail;
	}
	public void setProviderEmail(String providerEmail) {
		this.providerEmail = providerEmail;
	}
	public String getRecieverEmail() {
		return recieverEmail;
	}
	public void setRecieverEmail(String recieverEmail) {
		this.recieverEmail = recieverEmail;
	}
	@Override
	public String toString() {
		return "AcceptedOrdersBean [order_id=" + order_id + ", accepted_plates=" + accepted_plates + ", providerEmail="
				+ providerEmail + ", recieverEmail=" + recieverEmail + "]";
	}
	
}
