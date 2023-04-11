package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WishListService;
//This class shows the users shopping cart or creates empty one if user does not have one.
@ControllerAdvice
public class GeneralCartController {
	//Autowiring services
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private WishListService wishListService;
	
	public void populateModel(Model model, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
		String sessionTokenWishList = (String) request.getSession(true).getAttribute("sessionTokenWishList");
		if(sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}else {
			model.addAttribute("shoppingCart",cartService.getShoppingCartBySessionToken(sessionToken));
		}
		
		if(sessionTokenWishList == null) {
			model.addAttribute("wishList", new WishList());
		}else {
			model.addAttribute("wishList",wishListService.getWishListBySessionToken(sessionTokenWishList));
		}
		
		model.addAttribute("categories", productService.getAllCategories());
		model.addAttribute("brands", productService.getAllBrands());
		model.addAttribute("parameters", productService.getAllParameters());
		model.addAttribute("featured", productService.getProductWithBigestDiscount());
	}
}