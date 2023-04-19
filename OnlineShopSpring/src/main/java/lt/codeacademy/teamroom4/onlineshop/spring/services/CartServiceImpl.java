package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired 
	ShoppingCartRepository repository;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	ProductRepository productRepository;
	@Override
	public Cart createCart(Long id) {
		Cart cart = new Cart();
		return repository.save(cart);
	}

	@Override
	public Cart addItem(Long cartId, Long cartItemId, int quanitity) {
		Cart cart = repository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		Date time = new Date();
		//item.setCart(cart);
		//cart.setItems(null);
		//CartItem item = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("CartItem not found"));
		CartItem item =new CartItem(quanitity, time, productRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("CartItem not found")));
		cart.getItems().add(item);
	
		return repository.save(cart);
	}

	@Override
	public Cart removeItem(Long cartId, Long cartItem) {
		Cart cart = repository.findById(cartId)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		CartItem item = cartItemRepository.findById(cartItem).orElseThrow(() -> new RuntimeException("CartItem not found"));
		cart.getItems().remove(item);
		return repository.save(cart);
	}

	@Override
	public Cart updateItemQuantity(Long id, Long itemId, int quantity) {
		Cart cart = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		CartItem item = cartItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("CartItem not found"));;
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

	@Override
	public List<Cart> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return repository.findByUserId(id);
	}

}

