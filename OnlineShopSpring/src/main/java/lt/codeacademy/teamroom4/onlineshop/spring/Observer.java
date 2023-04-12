package lt.codeacademy.teamroom4.onlineshop.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lt.codeacademy.teamroom4.onlineshop.spring.config.SecurityConfig;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishList;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.WishListItem;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CategoryRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.RoleRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WishListRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.UserDetailsServiceImpl;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.ERoles.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;
//This class is used to generate dummy data;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.CPUParameters.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

@Configuration
public class Observer {
	// Used to generate random amount of money
	MoneyGenerator moneyGenerator = new MoneyGenerator();

	// Autowiring repositories

	@Autowired
	private UserRepository userRepository;

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

	// Used to activate seed function
	// @EventListener
	public void seed(ContextRefreshedEvent event) {
		// seedRole();
		seedUserAdmin();
		seedUserCustomer();
		seedUserManager();
		seedUserServiceManager();
		seedCoupons();
		seedCategory();
		seedProduct();
		seedWishListItemRepository();
		seedWishList();
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
		List<Category> categoryList = categoryRepository.findAll();
		List<Coupon> coupons = couponRepository.findAll();
		Category category = categoryRepository.getById((long) 1);
		List<Product> product = List.of(
//				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", categoryList.get(1),cpuParameterList),
				new Product("RX 6400XT", AMD, "foto.png", 160, " 4gb gddr6 RX 6400XT gpu", GPU, gpuParameterList),
				new Product("GTX 1650 Super", NVIDIA, "foto.png", 220, "4 gb gddr6 GTX 1650 Super gpu", GPU,
						gpuParameterList),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM, gpuParameterList, coupons.get(0)),
				new Product("IntelI5", INTEL, "foto.png", 200, "12 core cpu", CPU),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, cpuParameterList));
//
		List<Product> productList = List.of(new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList),
				new Product("Gt710", NVIDIA, "foto.png", 40, "RTX", GPU,gpuParameterList),
				new Product("Gt730", NVIDIA, "foto.png", 90, "RTX", GPU,gpuParameterList),
				new Product("Gt1030", NVIDIA, "foto.png", 100, "RTX", GPU,gpuParameterList),
				new Product("Gt610", NVIDIA, "foto.png", 90, "RTX", GPU,gpuParameterList),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM,gpuParameterList),
				new Product("RTX", NVIDIA, "foto.png", 80, "RTX", GPU,gpuParameterList));
		productRepository.saveAll(productList);
	}

	private void seedCategory() {
		List<Category> categoryList = List.of(new Category(GPU), new Category(CPU), new Category(RAM),
				new Category(HDD), new Category(MAINBOARD), new Category(PSU), new Category(THERMALPASTE),
				new Category(FANS), new Category(DESKTOPCOMPUTER), new Category(LAPTOPCOMPUTER),
				new Category(ALLINONECOMPUTER), new Category(MONITORS), new Category(PHONES), new Category(TABLETS),
				new Category(PRINTERS), new Category(GAMECONSOLES), new Category(GAMES));

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
}
