package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import lt.codeacademy.teamroom4.onlineshop.spring.buttons.Amount;
import lt.codeacademy.teamroom4.onlineshop.spring.buttons.BreakDown;
import lt.codeacademy.teamroom4.onlineshop.spring.buttons.Item;
import lt.codeacademy.teamroom4.onlineshop.spring.buttons.ItemTotal;
import lt.codeacademy.teamroom4.onlineshop.spring.buttons.PurchaseUnit;
import lt.codeacademy.teamroom4.onlineshop.spring.buttons.UnitAmount;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public String index(ModelMap modelMap, HttpSession session) {
		List<Line> cart = (List<Line>) session.getAttribute("cart");
		Gson gson = new Gson();
		modelMap.put("cart", gson.toJson(convertPurchaseUnit(cart)));
		return "cart/all";
	}
	
	@GetMapping("/buy/{id}")
	public String buy(@PathVariable("id")Long id, HttpSession session) {
		Product product = productService.find(id);
		if(session.getAttribute("cart") == null) {
			List<Line> cart = new ArrayList<Line>();
			cart.add(new Line(product, 1));
			session.setAttribute("cart", cart);
		}else {
			List<Line> cart = (List<Line>) session.getAttribute("cart");
			cart.add(new Line(product, 1));
			session.setAttribute("cart", cart);
		}
		return "redirect:/cart/all";
	}
	
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("index")int index, HttpSession session) {
			List<Line> cart = (List<Line>) session.getAttribute("cart");
			cart.remove(index);
			session.setAttribute("cart", cart);
		return "redirect:/cart/all";
	}
	
	private PurchaseUnit convertPurchaseUnit(List<Line> cart) {
		PurchaseUnit purchaseUnit = new PurchaseUnit();
		
		double total = 0;
		for(Line line : cart) {
			total += line.getPreke().getKaina() * line.getKiekis();
			
			purchaseUnit.getItems().add(new Item(
					line.getPreke().getId(), 
					line.getPreke().getPavadinimas(),
					line.getPreke().getAprasymas(),
					new UnitAmount("USD", line.getPreke().getKaina()),
					line.getKiekis()
					));
		}
		 purchaseUnit.setAmount(new Amount(new BreakDown(new ItemTotal("USD", total)), "USD", total));
		 return purchaseUnit;
	}

}
