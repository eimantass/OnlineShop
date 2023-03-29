package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ShoppingCart;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addToCart")
	public String addToCart(HttpServletRequest request, Model model, @RequestParam("id") Long id,
			@RequestParam("quantity") int quantity) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessionToken");
		if(sessionToken == null) {
			sessionToken = UUID.randomUUID().toString();
			request.getSession().setAttribute("sessionToken", sessionToken);
			cartService.addShoppingCartFirstTime(id,sessionToken, quantity);
		}else {
			cartService.addToExistingShoppingCart(id, sessionToken, quantity);
		}
		return "redirect:/";
	}

}
