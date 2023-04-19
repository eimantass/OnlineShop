package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.services.CartServiceImpl;
import lt.codeacademy.teamroom4.onlineshop.spring.services.PurchaseService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WalletService;

@RestController
@RequestMapping("/purchase/")
public class PurchaseController {
	
	@Autowired
	PurchaseService purchaseService;
	@Autowired
	CartServiceImpl cartItemService;
	@Autowired
	WalletService walletService;
	/*@PostMapping("/buy")
	public void buyItem(@RequestParam  Long cartItemId, @RequestParam int quantity, @RequestParam double price,@RequestParam  Long walletId) {
		//Does not work yet.
		purchaseService.buyItem(cartItemService.findByUserId(cartItemId), quantity, price,walletService.getById(walletId));
	}
	*/
	@PostMapping
	public void buyItem(Wallet wallet, Cart cart) {
		purchaseService.buyItem(wallet, cart);
	}
}
