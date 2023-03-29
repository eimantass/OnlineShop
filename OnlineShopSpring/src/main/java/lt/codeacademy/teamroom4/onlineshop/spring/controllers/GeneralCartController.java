package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@ControllerAdvice
public class GeneralCartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	public void populateModel(Model model, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(false).getAttribute("sessionToken");
		if(sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
		}else {
			model.addAttribute("shoppingCart",cartService.getShoppingCartBySessionToken(sessionToken));
		}
		
	}
}