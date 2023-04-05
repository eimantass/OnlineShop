package lt.codeacademy.teamroom4.onlineshop.spring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Role;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.User;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.RoleRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.UserRepository;
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

	// Used to activate seed function
	//@EventListener
	public void seed(ContextRefreshedEvent event) {
		// seedRole();
		seedUserAdmin();
		seedUserCustomer();
		seedUserManager();
		seedUserServiceManager();
		seedProduct();
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

	private void seedProduct() {
		ArrayList<String[]> intelI3parametersArray = new ArrayList<>();
		String[] intelI3CPUparameters = { "CPU_SOCKET,", "LGA1200" };
		intelI3parametersArray.add(intelI3CPUparameters);

		ArrayList<String[]> intelI5parametersArray = new ArrayList<>();
		String[] intelI5CPUparameters = { "CPU_SOCKET,", "LGA1700" };
		intelI5parametersArray.add(intelI5CPUparameters);
		Set<ProductParameters> cpuParameterList = new HashSet<>();
		Set<ProductParameters> gpuParameterList = new HashSet<>();
		ProductParameters firstCPU = new ProductParameters("I3", "Intel");
		ProductParameters firstGpu = new ProductParameters("RX 6400XT", "2321 Mhz");
		gpuParameterList.add(firstGpu);
		cpuParameterList.add(firstCPU);
		Category cpu = new Category(CPU);
		Category gpu = new Category(GPU);

		List<Product> product = List.of(
				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", cpu),
				new Product("RX 6400XT", AMD, "foto.png", 160, " 4gb gddr6 RX 6400XT gpu", gpu, gpuParameterList),
				new Product("GTX 1650 Super", NVIDIA, "foto.png", 220, "4 gb gddr6 GTX 1650 Super gpu", gpu),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", cpu),
				new Product("IntelI5", INTEL, "foto.png", 200, "12 core cpu", cpu),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", cpu, cpuParameterList),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", cpu, cpuParameterList));

		productRepository.saveAll(product);
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
