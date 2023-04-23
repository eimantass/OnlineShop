package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;

public interface CartService {
	
	Cart createCart(Long id);
	
	Cart addItem(Long id, Long cartItemId, int quantity);
	
	Cart removeItem(Long id, Long cartItem);
	
	Cart updateItemQuantity(Long id, Long itemId, int quantity);
	
	void deleteCart(Long id);
	
	List<Cart> getAllCarts();

	List<Cart> findByUserId(Long id);
	public List<Cart> findActiveCartsByUserId(Long id);
	public List<Cart> findInactiveCartsByUserId(Long id);
	List<Cart> findAllActiveCarts();

	List<Cart> findAllNotActiveCarts();
}
