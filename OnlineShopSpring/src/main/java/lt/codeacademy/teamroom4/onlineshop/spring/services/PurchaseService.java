package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Purchase;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PurchaseRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;

@Service
public class PurchaseService {
	@Autowired
	ProductService productService;
	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ShoppingCartRepository cartRepository;
	
	public void buyItem(User user, Cart cart) {
        Purchase purchase = new Purchase();
        // purchase.setItem(item);
        // purchase.setQuantity(quantity);
       
        purchase.setPrice(cart.getTotalPrice());
        user.setMoney(user.getMoney()-cart.getTotalPrice());
        purchaseRepository.save(purchase);
    }
	public void buyItem(Long userId, Long cartId) {
        Purchase purchase = new Purchase();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        
        // purchase.setItem(item);
        // purchase.setQuantity(quantity);
        System.out.println(cart.getTotalPrice());
        purchase.setPrice(cart.getTotalPrice());
        purchase.setCart(cart);
        user.setMoney(user.getMoney()-cart.getTotalPrice());
        purchaseRepository.save(purchase);
        
    }
	public void removePurchasedItem(Cart cart) {
//		List<CartItem> cartItems = cart.getItems();
//		for()
	}
}
