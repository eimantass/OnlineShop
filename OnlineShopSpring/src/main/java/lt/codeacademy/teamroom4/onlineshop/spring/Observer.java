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
	private RoleRepository roleRepository;

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
	private void seedRole() {
		List<Role> role = List.of(new Role(ADMIN), new Role(CUSTOMER), new Role(MANAGER), new Role(SERVICEMANAGER));

		roleRepository.saveAll(role);

	}

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
		List<Coupon> discountCoupons = List.of(
				new Coupon(0),
				new Coupon(10),
				new Coupon(20));	
		
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
		List<Coupon> coupons= couponRepository.findAll();
		Category category =categoryRepository.getById((long) 1);
	List<Product> product = List.of(
				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", categoryList.get(1),cpuParameterList),
				new Product("RX 6400XT", AMD, "foto.png", 160, " 4gb gddr6 RX 6400XT gpu",categoryList.get(1), gpuParameterList),
				new Product("GTX 1650 Super", NVIDIA, "foto.png", 220, "4 gb gddr6 GTX 1650 Super gpu",categoryList.get(1),gpuParameterList),
			//	new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", cpu,gpuParameterList, coupons.get(0)),
				//new Product("IntelI5", INTEL, "foto.png", 200, "12 core cpu", cpu),
			new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", categoryList.get(0), cpuParameterList),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu",categoryList.get(1), cpuParameterList));

		productRepository.saveAll(product);
	}
	private void seedCategory() {
		List<Category> categoryList = List.of(
		new Category(GPU),
		new Category(CPU),
		new Category(RAM),
		new Category(HDD),
		new Category(MAINBOARD),
		new Category(PSU),
		new Category(THERMALPASTE),
		new Category(FANS),
		new Category(DESKTOPCOMPUTER),
		new Category(LAPTOPCOMPUTER),
		new Category(ALLINONECOMPUTER));
		categoryRepository.saveAll(categoryList);
	}

	private void seedWishListItemRepository() {
	WishListItem blank = new WishListItem();
	wishListItemRepository.save(blank);
	}
	private void seedWishList() {
	WishList  blank = new WishList();	
	wishListRepository.save(blank);
	}
	/*
	 * private void seedAdmin() { List<Admin> admin = List .of(new
	 * Admin("ViliusAdmin", "viliusAdmin@gmail.com", "svbsdvisbv", "svbsdvisbv",
	 * ADMIN));
	 * 
	 * adminRepository.saveAll(admin);
	 * 
	 * }
	 * 
	 * private void seedCustomer() { List<Customer> customer = List.of( new
	 * Customer(null, "ViliusCustomer", 0, "viliusCustomer@gmail.com", "svbsdvisbv",
	 * "svbsdvisbv" ), new Customer(null, "ViliusCustomer2", 0,
	 * "viliusCustomer2@gmail.com", "svbsdvisbv", "svbsdvisbv"), new Customer(null,
	 * "ViliusCustomer3", 0, "viliusCustomer3@gmail.com", "svbsdvisbv",
	 * "svbsdvisbv")
	 * 
	 * );
	 * 
	 * customerRepository.saveAll(customer); }
	 * 
	 * private void seedServiceManager() { List<ServiceManager> serviceManager =
	 * List.of(new ServiceManager("ViliusServiceManager", 0,
	 * "viliusServiceManager@gmail.com", "svbsdvisbv", "svbsdvisbv",
	 * SERVICEMANAGER));
	 * 
	 * serviceRepsitory.saveAll(serviceManager);
	 * 
	 * }
	 * 
	 * private void seedManager() { List<Manager> manager = List.of( new
	 * Manager("ViliusManager", 0, "viliusManager@gmail.com", "svbsdvisbv",
	 * "svbsdvisbv", SERVICEMANAGER));
	 * 
	 * managerRepository.saveAll(manager); }
	 * 
	 */
}
