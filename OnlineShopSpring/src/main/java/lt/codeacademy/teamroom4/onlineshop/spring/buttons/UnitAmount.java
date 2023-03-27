package lt.codeacademy.teamroom4.onlineshop.spring.buttons;

import com.google.gson.annotations.SerializedName;

public class UnitAmount {
	
	@SerializedName("currency_code")
	private String currencyCode;
	
	@SerializedName("value")
	private double value;

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public UnitAmount(String currencyCode, double value) {
		this.currencyCode = currencyCode;
		this.value = value;
	}

	public UnitAmount() {}
	
}
