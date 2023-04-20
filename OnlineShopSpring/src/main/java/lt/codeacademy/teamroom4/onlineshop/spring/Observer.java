package lt.codeacademy.teamroom4.onlineshop.spring;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Photo;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CategoryRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PhotoRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ShoppingCartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.PhotoService;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

@Configuration
public class Observer {
	// Used to generate random amount of money
	MoneyGenerator moneyGenerator = new MoneyGenerator();

	// Autowiring repositories

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PhotoService photoService;
	@Autowired
	private PhotoRepository photoRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private WishListItemRepository wishListItemRepository;
	@Autowired
	private WishListRepository wishListRepository;
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	// Used to activate seed function

	// @EventListener

	public void seed(ContextRefreshedEvent event) {
		seedUserAdmin();
		seedUserCustomer();
		seedUserManager();
		seedUserServiceManager();
		seedCoupons();
		seedCategory();
		seedProduct();
	seedWishListItemRepository();
		//seedProductWithPhoto();
		seedWishList();
	//	seedCart();
	}


	// Seeding users and products

	private void seedUserAdmin() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(ADMIN));
		List<User> admin = List.of(
				new User("admin", "admin@gmail.com", SecurityConfig.passwordEncoder().encode("administrator"), roles));

		userRepository.saveAll(admin);
	}

	private void seedUserCustomer() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(CUSTOMER));
		List<User> customer = List.of(
				new User("customer", "customer@gmail.com", SecurityConfig.passwordEncoder().encode("customer"), roles));
		userRepository.saveAll(customer);
	}

	private void seedUserManager() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(MANAGER));
		List<User> manager = List.of(
				new User("manager", "manager@gmail.com", SecurityConfig.passwordEncoder().encode("manager"), roles));
		userRepository.saveAll(manager);
	}

	private void seedUserServiceManager() {
		Set<Role> roles = new HashSet<>();
		roles.add(new Role(SERVICEMANAGER));
		List<User> serviceManager = List.of(new User("serviceManager", "serviceManager@gmail.com",
				SecurityConfig.passwordEncoder().encode("serviceManager"), roles));
		userRepository.saveAll(serviceManager);
	}

	private void seedCoupons() {
		List<Coupon> discountCoupons = List.of(new Coupon(0), new Coupon(10), new Coupon(20));

		couponRepository.saveAll(discountCoupons);

	}

	private void seedProduct() {
		Set<ProductParameters> cpuParameterList = new HashSet<>();
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		ProductParameters firstCPU = new ProductParameters("I3", "Intel");
		ProductParameters firstGpu = new ProductParameters("RX 6400XT", "2321 Mhz");
		gpuParameterList.add(firstGpu);
		cpuParameterList.add(firstCPU);
		List<Coupon> coupons = couponRepository.findAll();
		//Photo photo = new Photo();
		// photo = photoService.findPhotoById((long)1);
		//photoRepository.save(photo);
		List<Product> product = List.of(
//				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", categoryList.get(1),cpuParameterList),
				new Product("RX 6400XT", AMD,"photo",  160, " 4gb gddr6 RX 6400XT gpu", null, GRAPHICS_CARDS,
						gpuParameterList, null),
				new Product("GTX 1650 Super", NVIDIA,"photo",  220, "4 gb gddr6 GTX 1650 Super gpu", null, GRAPHICS_CARDS,
						gpuParameterList, null),
				new Product("4gb RAM", GOODRAM,"photo",  30, "4 gb ddr3 ram", null, LAPTOPS, gpuParameterList,
						coupons.get(0)),
				new Product("IntelI5", INTEL,  null, 200, "12 core cpu", null, PROCESSORS, gpuParameterList, null));
				//new Product("IntelI7", INTEL, null, 250, "16 core cpu", PROCESSORS, cpuParameterList),
				//new Product("IntelI7", INTEL,  250, "16 core cpu", PROCESSORS, cpuParameterList,
						//coupons.get(1)));
//
		productRepository.saveAll(product);
	}
//	private void seedProductWithPhoto() {
//		Photo photo = photoService.findPhotoById((long)1);
//		Product product = new Product((long)40,"RX 6400XT With Photo", AMD,  160, " 4gb gddr6 RX 6400XT gpu", GRAPHICS_CARDS,
//				null, null);
//		productRepository.save(product);
//	}
	private void seedCategory() {
		List<Category> categoryList = List.of(new Category(PROCESSORS), new Category(LAPTOPS),
				new Category(GRAPHICS_CARDS), new Category(MAINBOARDS), new Category(MOBILE_PHONES),
				new Category(MONITORS), new Category(PRINTERS), new Category(GAMECONSOLES), new Category(GAMES));

		categoryRepository.saveAll(categoryList);
	}

	private void seedWishListItemRepository() {
		WishListItem blank = new WishListItem();
		wishListItemRepository.save(blank);
	}

	private void seedWishList() {
		WishList blank = new WishList();
		wishListRepository.save(blank);
	}
	
	private void seedCart() {
		Date time = new Date();
		List<CartItem> items = List.of(
				new CartItem(5, time, new Product((long)14,"IntelI5", INTEL, 200, "12 core cpu", PROCESSORS))
				);
		
		Cart cart = new Cart(4515.545, items);
		shoppingCartRepository.save(cart);
	}

}