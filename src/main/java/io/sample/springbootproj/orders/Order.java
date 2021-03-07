package io.sample.springbootproj.orders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_table")
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "orderID", nullable = false)
	private long orderID;
	private String customerName;
	private String staffName;
	private String numberOfPeople;
	private String foodType;
	private String decaorationCost;
	private String otherCost;
	private String totalCost;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(long orderID, String customerName, String staffName, String numberOfPeople, String foodType,
			String decaorationCost, String otherCost, String totalCost) {
		super();
		this.orderID = orderID;
		this.customerName = customerName;
		this.staffName = staffName;
		this.numberOfPeople = numberOfPeople;
		this.foodType = foodType;
		this.decaorationCost = decaorationCost;
		this.otherCost = otherCost;
		this.totalCost = totalCost;
	}
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(String numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public String getDecaorationCost() {
		return decaorationCost;
	}
	public void setDecaorationCost(String decaorationCost) {
		this.decaorationCost = decaorationCost;
	}
	public String getOtherCost() {
		return otherCost;
	}
	public void setOtherCost(String otherCost) {
		this.otherCost = otherCost;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	
	

}
