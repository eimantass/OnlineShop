package lt.codeacademy.teamroom4.onlineshop.spring.controllers;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
//In this class the shopping cart mappings are handled
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("")
	public ResponseEntity<Cart> createCart(){
		Cart cart = cartService.createCart();
		return ResponseEntity.ok(cart);
	}
	
	@PostMapping("/items/{id}")
	public ResponseEntity<Cart> addItem(@PathVariable Long id, @RequestBody CartItem item){
		Cart cart = cartService.addItem(id, item);
		return ResponseEntity.ok(cart);

	}
	
	@PutMapping("/update/{id}")
	public Cart updateCart(@PathVariable Long id, @RequestBody CartItem item, @RequestParam int quantity) {
		return cartService.updateItemQuantity(id, item, quantity);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeItem(@PathVariable Long id, @RequestBody CartItem item){
		cartService.removeItem(id, item);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCart(@PathVariable Long id) {
		cartService.deleteCart(id);
	}
	
	@GetMapping("/allCarts")
	public List<Cart> allCarts(){
		return cartService.getAllCarts();
	}
	@GetMapping("/allItems")
	public List<Cart> allItems(){
		return cartService.getAllCarts();
	}

}