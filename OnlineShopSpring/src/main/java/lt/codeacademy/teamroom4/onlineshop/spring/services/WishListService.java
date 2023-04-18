package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
//This class handles wish list service
@Service
public class WishListService {
	//Autowiring services and repositories
	@Autowired
	private WishListRepository wishListRepository;
	
	@Autowired
	private WishListItemRepository wishListItemRepository;
	
	public WishList createWish(Long id) {
		WishList list = new WishList();
		return wishListRepository.save(list);
	}
	
	@Autowired
	private ProductService productService;
	//Adding first item to the wish list
	public WishList addToWishFirstTime(Long id, String sessionToken) {
		WishList wishList = new WishList();
		WishListItem item = new WishListItem();
		item.setDate(new Date());
		item.setProduct(productService.getProductById(id));
		wishList.getItems().add(item);
		wishList.setSessionToken(sessionToken);
		wishList.setDate(new Date());
		return wishListRepository.save(wishList);
		
	}
	//Adding wishlisted item to shopping cart
	public WishList addToExistingShoppingCart(Long id, String sessionToken) {
		WishList wishList = wishListRepository.findBySessionToken(sessionToken);
		Product p = productService.getProductById(id);
		Boolean productDoesExistInTheCart = false;
		if(wishList != null) {
			Set<WishListItem> items = wishList.getItems();
			for(WishListItem item : items) {
				if(item.getProduct().equals(p)) {
					productDoesExistInTheCart = true;
					break;
				}
			}
		}
		if(!productDoesExistInTheCart && (wishList != null)) {
			WishListItem item1 = new WishListItem();
			item1.setDate(new Date());
			item1.setProduct(p);
			wishList.getItems().add(item1);
			return wishListRepository.saveAndFlush(wishList);
		}
		return null;
	}
	//Getting wish list accordingly to session token
	public WishList getWishListBySessionToken(String sessionToken) {
		return wishListRepository.findBySessionToken(sessionToken);
	}
	public List<WishList> getAllWishLists() {
		return wishListRepository.findAll();
	}
	//Removing item from the wish lsit
	public WishList removeItemFromWishList(Long id, String sessionToken) {
		WishList wishList = wishListRepository.findBySessionToken(sessionToken);
		Set<WishListItem> items = wishList.getItems() ;
		WishListItem item = null;
		for(WishListItem item1 : items) {
			if(item1.getId()==id) {
				item = item1;
			}
		}
		items.remove(item);
		wishListItemRepository.delete(item);
		wishList.setItems(items);
		return wishListRepository.save(wishList);
	}
	//Clearing wish list
	public void clearWishList(String sessionToken) {
		WishList sh = wishListRepository.findBySessionToken(sessionToken);
		wishListRepository.delete(sh);
	}
}
