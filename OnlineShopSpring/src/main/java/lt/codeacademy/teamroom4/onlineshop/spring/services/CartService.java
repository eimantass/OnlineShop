package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;

@Service
public class CartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductService productService;
	
	public ShoppingCart addShoppingCartFirstTime(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = new ShoppingCart();
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setDate(new Date());
		cartItem.setProduct(productService.getProductById(id));
		shoppingCart.getCartItems().add(cartItem);
		shoppingCart.setSessionToken(sessionToken);
		return shoppingCartRepository.save(shoppingCart);
		
	}

	public ShoppingCart addToExistingShoppingCart(Long id, String sessionToken, int quantity) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Product p = productService.getProductById(id);
		Boolean productDoesExistInTheCart = false;
		if(shoppingCart != null) {
			Set<CartItem> items = (Set<CartItem>) shoppingCart.getCartItems();
			for(CartItem item : items) {
				if(item.getProduct().equals(p)) {
					productDoesExistInTheCart = true;
					item.setQuantity(item.getQuantity()+quantity);
					shoppingCart.setCartItems(items);
					return shoppingCartRepository.saveAndFlush(shoppingCart);
				}
			}
		}
		if(!productDoesExistInTheCart && (shoppingCart != null)) {
			CartItem cartItem = new CartItem();
			cartItem.setDate(new Date());
			cartItem.setQuantity(quantity);
			cartItem.setProduct(p);
			shoppingCart.getCartItems().add(cartItem);
			return shoppingCartRepository.save(shoppingCart);
		}
		return this.addShoppingCartFirstTime(id, sessionToken, quantity);
	}

	public ShoppingCart getShoppingCartBySessionToken(String sessionToken) {
		return shoppingCartRepository.findBySessionToken(sessionToken);
	}

	public CartItem updateShoppingCartItem(Long id, int quantity) {
		CartItem cartItem = cartItemRepository.findById(id).get();
		cartItem.setQuantity(quantity);
		return cartItemRepository.saveAndFlush(cartItem);
	}

	public ShoppingCart removeCartItemFromShoppingCart(Long id, String sessionToken) {
		ShoppingCart shoppingCart = shoppingCartRepository.findBySessionToken(sessionToken);
		Set<CartItem> items = (Set<CartItem>) shoppingCart.getCartItems();
		CartItem cartItem = null;
		for(CartItem item : items) {
			if(item.getId().equals(id)) {
				cartItem = item;
			}
		}
		items.remove(cartItem);
		cartItemRepository.delete(cartItem);
		shoppingCart.setCartItems(items);
		return shoppingCartRepository.save(shoppingCart);
	}

	public void clearShoppingCart(String sessionToken) {
		ShoppingCart sh = shoppingCartRepository.findBySessionToken(sessionToken);
		shoppingCartRepository.delete(sh);
	}
}
