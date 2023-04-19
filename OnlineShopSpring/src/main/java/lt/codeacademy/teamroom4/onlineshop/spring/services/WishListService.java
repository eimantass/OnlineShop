package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
//This class handles wish list service

@Service
public class WishListService {
	
	@Autowired 
	WishListRepository repository;
	@Autowired
	WishListItemRepository itemRepository;

	@Autowired
	ProductRepository productRepository;
	public WishList createWish(Long id) {
		WishList wishList = new WishList();
		return repository.save(wishList);
	}


	public WishList addItem(Long wishListId, Long wishListItemId) {
		WishList wishList = repository.findById(wishListId)
				.orElseThrow(() -> new RuntimeException("WishList not found"));
		Date time = new Date();
		//item.setCart(cart);
		//cart.setItems(null);
		//CartItem item = cartItemRepository.findById(cartItemId).orElseThrow(() -> new RuntimeException("CartItem not found"));
		WishListItem item =new WishListItem(wishListId, time, productRepository.findById(wishListItemId).orElseThrow(() -> new RuntimeException("WishListItem not found")));
		wishList.getItems().add(item);
	
		return repository.save(wishList);
	}

	public WishList removeItem(Long wishListId, Long wishListItemId) {
		WishList cart = repository.findById(wishListId)
				.orElseThrow(() -> new RuntimeException("Cart not found"));
		WishListItem item =itemRepository.findById(wishListItemId).orElseThrow(() -> new RuntimeException("WishListItem not found"));
		cart.getItems().remove(item);
		return repository.save(cart);
	}
	
	public void deleteWishList(Long id) {
		repository.deleteById(id);
	}


	public List<WishList> getAllWishLists() {
		return repository.findAll();
	}


	public List<WishList> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return repository.findByUserId(id);
	}
}