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
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.RoleRepository;
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
	RoleRepository roleRepository;
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
	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	// Used to activate seed function

	//Use this one if you want to seed only roles without users or products
	//@EventListener
	public void seedRolesOnly(ContextRefreshedEvent event) {
	 seedRole();

	}
	//@EventListener
	public void seed(ContextRefreshedEvent event) {
	//	seedRole();
	//	seedUserAdmin();
	//	seedUserCustomer();
	//	seedUserManager();
	//	seedUserServiceManager();
	//	seedCoupons();
	//	seedCategory();
		seedProduct();
	//	seedWishListItemRepository();
		//seedProductWithPhoto();

		seedWishList();

		
	}
	 private void seedRole() {
			List<Role> role = List.of(
					new Role(CUSTOMER),
					new Role(ADMIN),
					new Role(MANAGER),
					new Role(SERVICEMANAGER)
					);

			roleRepository.saveAll(role);

		}

	// Seeding users and products

	private void seedUserAdmin() {
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName(ADMIN).orElseThrow( () -> new RuntimeException("Error: Role is not found")));
		List<User> admin = List.of(
				new User("admin", "admin@gmail.com", SecurityConfig.passwordEncoder().encode("administrator"), roles));
		roleRepository.saveAll(roles);
		userRepository.saveAll(admin);
	}

	private void seedUserCustomer() {
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName(CUSTOMER).orElseThrow( () -> new RuntimeException("Error: Role is not found")));
		List<User> customer = List.of(
				new User("customer", "customer@gmail.com", SecurityConfig.passwordEncoder().encode("customer"), roles));
		userRepository.saveAll(customer);
	}

	private void seedUserManager() {
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName(MANAGER).orElseThrow( () -> new RuntimeException("Error: Role is not found")));
		List<User> manager = List.of(
				new User("manager", "manager@gmail.com", SecurityConfig.passwordEncoder().encode("manager"), roles));
		userRepository.saveAll(manager);
	}

	private void seedUserServiceManager() {
		Set<Role> roles = new HashSet<>();
		roles.add(roleRepository.findByName(SERVICEMANAGER).orElseThrow( () -> new RuntimeException("Error: Role is not found")));
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
		List<Product> product = List.of(
				new Product("Intel Core i3-10100F", INTEL, "https://avitela.lt/image/cache/catalog/product-images/62/225/original/e633e099cb5811924267c39c10fc23d7-1080x1000.jpg", 
						180, "Quad Core CPU", (long)20, PROCESSORS, cpuParameterList, null),
				new Product("AMD Radeon RX 6400XT", AMD, "https://cdn.mdcomputers.in/image/cache/catalog/graphics%20card/asus/dual-rx-6700-4g/dual-rx-6700-4g-image-main-600x600.JPG",  
						240, "4gb gddr6 RX 6400XT gpu", (long)20, GRAPHICS_CARDS, gpuParameterList, null),
				new Product("Geforce GTX 1650 Super", NVIDIA, "https://images.kaina24.lt/5665/54/asus-geforce-tuf-gtx1650s-o4g-gaming-2.jpg",  
						220, "4 gb gddr6 GTX 1650 Super gpu", (long)20, GRAPHICS_CARDS, gpuParameterList, null),
				new Product("MSI GF63 i5-11400H 16GB 512SSD RTX3050Ti", MSI, "https://nesiojami.lt/wp-content/uploads/2021/01/MSI-GF65.jpg",  
						120, "MSI Gaming Laptop", (long)20, LAPTOPS, gpuParameterList, null),
				new Product("Intel Core™ i5-9400F", INTEL,  "https://images.kaina24.lt/8832/94/intel-core-i5-9400f-1.jpg", 
						200, "6 core CPU", (long)20, PROCESSORS, gpuParameterList, null),
				new Product("MSI B350M PRO-VDH", AMD, "https://asset.msi.com/resize/image/global/product/product_5_20170331165110_58de187eec6c3.png62405b38c58fe0f07fcef2367d8a9ba1/380.png", 
						200, "6 core CPU", (long)20, MAINBOARDS, gpuParameterList, null),
				new Product("Monitorius BenQ EX2710U | 27", BENQ,  "https://www.varle.lt/static/uploads/products/235x195/622/ste/stebeti-benq-mobiuz-ex240n-9hll6lbqbe.jpg", 
						200, "Maksimali rezoliucija 3840 x 2160 ", (long)20, MONITORS, gpuParameterList, null));

		productRepository.saveAll(product);
	}

	private void seedCategory() {
		List<Category> categoryList = List.of(new Category(PROCESSORS), new Category(LAPTOPS),
				new Category(GRAPHICS_CARDS), new Category(MAINBOARDS), new Category(MOBILE_PHONES),
				new Category(MONITORS), new Category(PRINTERS), new Category(GAMECONSOLES), new Category(GAMES));

		categoryRepository.saveAll(categoryList);
	}

	

}