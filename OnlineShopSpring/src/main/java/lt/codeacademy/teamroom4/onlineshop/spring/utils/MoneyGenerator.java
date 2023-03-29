package lt.codeacademy.teamroom4.onlineshop.spring.utils;

public class MoneyGenerator {
	
	static double min = 1000;
	static double max = 5000;
	
	public static double virtualMoney() {
		double money = Math.floor(Math.random() * (max-min+1) + min);
		return money;
	}
}
