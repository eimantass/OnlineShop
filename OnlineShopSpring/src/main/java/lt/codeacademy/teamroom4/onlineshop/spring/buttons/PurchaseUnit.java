package lt.codeacademy.teamroom4.onlineshop.spring.buttons;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class PurchaseUnit {
	
	@SerializedName("amount")
	private Amount amount;
	
	@SerializedName("items")
	private List<Item> items = new ArrayList<Item>();

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
}
