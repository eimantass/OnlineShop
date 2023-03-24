package lt.codeacademy.teamroom4.onlineshop.spring.utils;

public class MoneyGenerator {
	
	double min = 1000;
	double max = 5000;
	
	public double virtualMoney() {
		double money = Math.floor(Math.random() * (max-min+1) + min);
		return money;
	}
}
