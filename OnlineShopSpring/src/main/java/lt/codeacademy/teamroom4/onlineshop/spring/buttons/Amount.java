package lt.codeacademy.teamroom4.onlineshop.spring.buttons;

import com.google.gson.annotations.SerializedName;

public class Amount {
	
	@SerializedName("breakdown")
	private BreakDown breakDown;
	
	@SerializedName("currency_code")
	private String currencyCode;
	
	@SerializedName("value")
	private double value;

	public BreakDown getBreakDown() {
		return breakDown;
	}

	public void setBreakDown(BreakDown breakDown) {
		this.breakDown = breakDown;
	}

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

	public Amount(BreakDown breakDown, String currencyCode, double value) {
		this.breakDown = breakDown;
		this.currencyCode = currencyCode;
		this.value = value;
	}
	
	
	
}
