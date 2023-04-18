package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WishListService;

@RestController
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@Autowired
	UserDetailsServiceImpl userService;
	
	WishListRepository wishListRepository;
	
	@PostMapping("/create/{userId}")
	@ResponseBody
	public ResponseEntity<WishList> createWishList(@PathVariable("userId") Long userId) {
	   
	    User user = userService.getById(userId);
	  
	    WishList createdWish = wishListService.createWish(userId);
	    createdWish.setUser(user);
	    wishListRepository.save(createdWish);

	    return ResponseEntity.ok(createdWish);
	}
	
	@GetMapping("/addToWishList/{id}")
	public String addToWishList(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessionTokenWishList");
		if(sessionToken == null) {
			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessionTokenWishList", sessionToken);
			wishListService.addToWishFirstTime(id, sessionToken);
			
		}else {
			wishListService.addToExistingShoppingCart(id, sessionToken);
		}
		return "redirect:/";
	}
	@GetMapping("/getAllWishLists")
	public List<WishList> getAllWishLists(){
		return wishListService.getAllWishLists();
	}
	@GetMapping("/getWishListBySession/{sessionToken}")
	public WishList getWishListBySessionToken(@PathVariable String sessionToken, HttpServletRequest request){
		return wishListService.getWishListBySessionToken(sessionToken);
	}
	
	@GetMapping("/removeWishListItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessionTokenWishList");
		wishListService.removeItemFromWishList(id, sessionToken);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/clearWishList/{sessionToken}")
	public String clearWishList(@PathVariable String sessionToken, HttpServletRequest request) {
		//String sessionToken = (String) request.getSession(false).getAttribute("sessionTokenWishList");
		//request.getSession(false).removeAttribute("sessionTokenWishList");
		
		wishListService.clearWishList(sessionToken);
		return "redirect:/shoppingCart";
	}
}
