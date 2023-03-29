package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;

@Service
public class CartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private ProductService productService;
	
	public ShoppingCart addShoppingCartFirstTime(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct(productService.getProductById(id));
		shoppingCart.getCartItems().add(cartItem);
		shoppingCart.setTokenSession(sessionToken);
		return shoppingCartRepository.save(shoppingCart);
		
	}

	public ShoppingCart addToExistingShoppingCart(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product p = productService.getProductById(id);
		for(CartItem item : shoppingCart.getCartItems()) {
			if(p.getId().equals(item.getProduct().getId())) {
				item.setQuantity(item.getQuantity()+quantity);
				return shoppingCartRepository.save(shoppingCart);
			}
		}
		CartItem cartItem = new CartItem();
		cartItem.setDate(new Date());
		cartItem.setQuantity(quantity);
		cartItem.setProduct(p);
		shoppingCart.getCartItems().add(cartItem);
		return shoppingCartRepository.save(shoppingCart);
	}
}
