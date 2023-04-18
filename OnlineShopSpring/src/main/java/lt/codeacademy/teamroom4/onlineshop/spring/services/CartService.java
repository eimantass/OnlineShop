package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
//This class handles cart functions

public interface CartService {
	
	Cart createCart(Long id);
	
	Cart addItem(Long id, Long cartItemId, int quantity);
	
	Cart removeItem(Long id, Long cartItem);
	
	Cart updateItemQuantity(Long id, Long itemId, int quantity);
	
	void deleteCart(Long id);
	
	List<Cart> getAllCarts();

	List<Cart> findByUserId(Long id);
}
