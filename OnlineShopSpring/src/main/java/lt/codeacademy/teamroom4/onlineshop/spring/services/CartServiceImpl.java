package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired 
	ShoppingCartRepository repository;

	@Override
	public Cart createCart(Cart id) {
		Cart cart = new Cart();
		return repository.save(cart);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cart addItem(Long id, CartItem item) {
		Cart cart = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		//item.setCart(cart);
		cart.getItems().add(item);
		return repository.save(cart);
	}

	@Override
	public Cart removeItem(Long id, CartItem item) {
		Cart cart = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		cart.getItems().remove(item);
		return repository.save(cart);
	}

	@Override
	public Cart updateItemQuantity(Long id, CartItem item, int quantity) {
		Cart cart = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		item.setQuantity(quantity);
		return repository.save(cart);
	}

	@Override
	public void deleteCart(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Cart> getAllCarts() {
		return repository.findAll();
	}

}

