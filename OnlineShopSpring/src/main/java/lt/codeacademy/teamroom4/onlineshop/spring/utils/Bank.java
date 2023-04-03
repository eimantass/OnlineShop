package lt.codeacademy.teamroom4.onlineshop.spring.utils;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;

public class Bank {
	
	void pay(User cust, double pay) {
		double balance = cust.getMoney();
		String name = cust.getFullName();
		if(balance >= pay) {
			System.out.println(name + " pay " + pay);
			
			balance = balance - pay;
			System.out.println("Your balance after pay: " + balance);
		}else {
			System.out.println(name + " you can not pay " + pay);
			System.out.println("Your balance is: " + balance);
		}
	}
}
