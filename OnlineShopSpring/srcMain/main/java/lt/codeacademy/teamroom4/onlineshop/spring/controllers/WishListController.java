package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lt.codeacademy.teamroom4.onlineshop.spring.services.WishListService;

@Controller
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
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
	
	@GetMapping("/removeWishListItem/{id}")
	public String removeItem(@PathVariable("id") Long id, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessionTokenWishList");
		wishListService.removeItemFromWishList(id, sessionToken);
		return "redirect:/shoppingCart";
	}
	
	@GetMapping("/clearWishList")
	public String clearWishList(HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessionTokenWishList");
		request.getSession(false).removeAttribute("sessionTokenWishList");
		wishListService.clearWishList(sessionToken);
		return "redirect:/shoppingCart";
	}
}
