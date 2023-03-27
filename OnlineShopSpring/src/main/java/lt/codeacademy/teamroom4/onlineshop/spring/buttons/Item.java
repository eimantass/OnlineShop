package lt.codeacademy.teamroom4.onlineshop.spring.buttons;

import com.google.gson.annotations.SerializedName;

public class Item {
	
	private Long sku;
	private String name;
	private String description;
	@SerializedName("unit_amount")
	private UnitAmount unitAmount;
	private int quantity;
	
	public Long getSku() {
		return sku;
	}
	public void setSku(Long sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UnitAmount getUnitAmount() {
		return unitAmount;
	}
	public void setUnitAmount(UnitAmount unitAmount) {
		this.unitAmount = unitAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item(Long sku, String name, String description, UnitAmount unitAmount, int quantity) {
		this.sku = sku;
		this.name = name;
		this.description = description;
		this.unitAmount = unitAmount;
		this.quantity = quantity;
	}
	
	public Item() {}
	
	
	
}
