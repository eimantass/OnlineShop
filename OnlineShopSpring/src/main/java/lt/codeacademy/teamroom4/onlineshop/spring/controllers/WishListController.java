package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WishListService;

@RestController
@CrossOrigin(origins = "http://localhost:8081", allowCredentials = "true")
@RequestMapping("/wish-list")
public class WishListController {

	@Autowired
	private WishListService wishListService;
	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	UserDetailsServiceImpl userService;

	// Retrieve the User entity from the database using the userId
	@PostMapping("/create/{userId}")
	@ResponseBody
	public ResponseEntity<WishList> createWishList(@PathVariable("userId") Long userId) {
		User user = userService.getById(userId);

		WishList createdCart = wishListService.createWish(userId);
		createdCart.setUser(user);
		wishListRepository.save(createdCart);

		return ResponseEntity.ok(createdCart);
	}

	@PostMapping("/items/{wishListId}/{itemId}")
	@ResponseBody
	public ResponseEntity<WishList> addItem(@PathVariable Long wishListId, @PathVariable Long itemId) {

		WishList cart = wishListService.addItem(wishListId, itemId);
		return ResponseEntity.ok(cart);

	}

	@DeleteMapping("/removeItem/{wishListId}/{itemId}")
	public void removeWishListItem(@PathVariable Long wishListId, @PathVariable Long itemId) {
		wishListService.removeItem(wishListId, itemId);
		
	}

	@DeleteMapping("/deleteWishlist/{id}")
	public void deleteCart(@PathVariable Long id) {
		wishListService.deleteWishList(id);
	}

	@GetMapping("/allWishLists")
	public List<WishList> allWishLists() {
		return wishListService.getAllWishLists();
	}

	@GetMapping("/wishListByUserId/{userId}")
	public List<WishList> wishListByUserId(@PathVariable Long userId) {

		return wishListService.findByUserId(userId);
	}

}