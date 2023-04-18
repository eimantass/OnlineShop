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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;
//In this class the shopping cart mappings are handled
@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ShoppingCartRepository cartRepository;
	@Autowired
	UserDetailsServiceImpl userService;
	
//	@PostMapping("")
//	public ResponseEntity<Cart> createCart(){
//		Cart cart = cartService.createCart();
//		return ResponseEntity.ok(cart);
//	}
	
	@PostMapping("/create/{userId}")
	@ResponseBody
	public ResponseEntity<Cart> createCart(@PathVariable("userId") Long userId) {
	    // Retrieve the User entity from the database using the userId
	    User user = userService.getById(userId);
	    // Create a new Cart
	   // Cart cart = new Cart();
	    // Set the User entity associated with the Cart
	
	    // Save the Cart to the database
	    Cart createdCart = cartService.createCart(userId);
	    createdCart.setUser(user);
	    cartRepository.save(createdCart);

	    return ResponseEntity.ok(createdCart);
	}
	
	@PostMapping("/items/{cartId}/{itemId}/{quantity}")
	@ResponseBody
	public ResponseEntity<Cart> addItem(@PathVariable Long cartId, @PathVariable Long itemId, @PathVariable int quantity){
		
		Cart cart = cartService.addItem(cartId, itemId,quantity);
		return ResponseEntity.ok(cart);

	}
	
	@PutMapping("/update/{cartId}/{itemId}/{quantity}")
	public Cart updateCart(@PathVariable Long cartId, @PathVariable Long itemId, @PathVariable int quantity) {
		return cartService.updateItemQuantity(cartId,itemId, quantity);
	}
	
	@DeleteMapping("/remove/{cartId}/{itemId}")
	public void removeItem(@PathVariable Long cartId, @PathVariable Long itemId){
		cartService.removeItem(cartId, item);
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
	@GetMapping("/cartByUserId/{userId}")
	public List<Cart> cartByUserId(@PathVariable Long userId ){
		
		return cartService.findByUserId(userId);
	}

}