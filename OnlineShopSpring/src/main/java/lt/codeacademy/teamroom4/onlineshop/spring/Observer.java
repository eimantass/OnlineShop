package lt.codeacademy.teamroom4.onlineshop.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Admin;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Customer;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Manager;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.AdminRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CustomerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ManagerRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ServiceRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles.*;
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
	private AdminRepository adminRepository;

	@Autowired
	private ManagerRepository managerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ServiceRepository serviceRepsitory;

	@Autowired
	private ProductRepository productRepository;

	// Used to activate seed function
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAdmin();
		seedCustomer();
		seedServiceManager();
		seedManager();
		seedProduct();
	}

	// Seeding users and products

	private void seedAdmin() {
		List<Admin> admin = List
				.of(new Admin("ViliusAdmin", "viliusAdmin@gmail.com", "svbsdvisbv", "svbsdvisbv", ADMIN));

		adminRepository.saveAll(admin);

	}

	private void seedCustomer() {
		List<Customer> customer = List.of(
				new Customer(null, "ViliusCustomer", 0, "viliusCustomer@gmail.com", "svbsdvisbv", "svbsdvisbv"
		),
				new Customer(null, "ViliusCustomer2", 0, "viliusCustomer2@gmail.com", "svbsdvisbv", "svbsdvisbv"),
				new Customer(null, "ViliusCustomer3", 0, "viliusCustomer3@gmail.com", "svbsdvisbv", "svbsdvisbv")

		);

		customerRepository.saveAll(customer);
	}

	private void seedServiceManager() {
		List<ServiceManager> serviceManager = List.of(new ServiceManager("ViliusServiceManager", 0,
				"viliusServiceManager@gmail.com", "svbsdvisbv", "svbsdvisbv", SERVICEMANAGER));

		serviceRepsitory.saveAll(serviceManager);

	}

	private void seedManager() {
		List<Manager> manager = List.of(
				new Manager("ViliusManager", 0, "viliusManager@gmail.com", "svbsdvisbv", "svbsdvisbv", SERVICEMANAGER));

		managerRepository.saveAll(manager);
	}

	private void seedProduct() {
		// List<CPUParameters> parameters = List.of(CPU_SOCKET,CPU_FREQUENCY);
		// List<String> parameters = List.of( ("CPU_SOCKET = 1200"), ("CPU_CORES =
		// 16"));
		ArrayList<String[]> intelI3parametersArray = new ArrayList<>();
		String[] intelI3CPUparameters = { "CPU_SOCKET,", "LGA1200" };
		intelI3parametersArray.add(intelI3CPUparameters);

		ArrayList<String[]> intelI5parametersArray = new ArrayList<>();
		String[] intelI5CPUparameters = { "CPU_SOCKET,", "LGA1700" };
		intelI5parametersArray.add(intelI5CPUparameters);

		List<Product> product = List.of(
				new Product("i3-10100F", INTEL, "foto.png", 67, "Quad Core CPU", CPU, intelI3parametersArray),
				new Product("RX 6400XT", AMD, "foto.png", 160, " 4gb gddr6 RX 6400XT gpu", GPU),
				new Product("GTX 1650 Super", NVIDIA, "foto.png", 220, "4 gb gddr6 GTX 1650 Super gpu", GPU),
				new Product("4gb RAM", GOODRAM, "foto.png", 30, "4 gb ddr3 ram", RAM),
				new Product("IntelI5", INTEL, "foto.png", 200, "12 core cpu", CPU),
				new Product("IntelI7", INTEL, "foto.png", 250, "16 core cpu", CPU, intelI5parametersArray));

		productRepository.saveAll(product);
	}
}
