package lt.codeacademy.teamroom4.onlineshop.spring.buttons;

import com.google.gson.annotations.SerializedName;

public class BreakDown {
	
	@SerializedName("item_total")
	private ItemTotal itemTotal;

	public ItemTotal getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(ItemTotal itemTotal) {
		this.itemTotal = itemTotal;
	}

	public BreakDown(ItemTotal itemTotal) {
		this.itemTotal = itemTotal;
	}
	
	
}
