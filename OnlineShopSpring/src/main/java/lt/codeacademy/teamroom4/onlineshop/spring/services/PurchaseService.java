package lt.codeacademy.teamroom4.onlineshop.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Purchase;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PurchaseRepository;

@Service
public class PurchaseService {
	
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public void buyItem(Wallet wallet, Cart cart) {
        Purchase purchase = new Purchase();
        // purchase.setItem(item);
        // purchase.setQuantity(quantity);
       
        purchase.setPrice(cart.getTotalPrice());
        wallet.setCurrentBalance(wallet.getCurrentBalance()-cart.getTotalPrice());
        purchaseRepository.save(purchase);
    }
}
