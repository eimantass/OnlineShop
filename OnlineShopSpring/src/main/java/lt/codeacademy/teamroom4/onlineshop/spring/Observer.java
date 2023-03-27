package lt.codeacademy.teamroom4.onlineshop.spring;

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
import lt.codeacademy.teamroom4.onlineshop.spring.services.CustomerService;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.MoneyGenerator;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles.*;
import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Categories.*;

@Configuration
public class Observer {
	MoneyGenerator moneyGenerator = new MoneyGenerator();
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
	
	//@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAdmin();
		seedCustomer();
		seedServiceManager();
		seedManager();
		seedProduct();
	}
	
	private void seedAdmin() {
		List<Admin> admin = List.of(
				new Admin("ViliusAdmin", "viliusAdmin@gmail.com", "svbsdvisbv","svbsdvisbv" ,ADMIN)
				);
		
		adminRepository.saveAll(admin);
				
	}
	private void seedCustomer() {
		List<Customer> customer = List.of(
				new Customer(
						null, "ViliusCustomer", 0, "viliusCustomer@gmail.com", "svbsdvisbv","svbsdvisbv" ,CUSTOMER, moneyGenerator.virtualMoney()
						),
				new Customer(null, "ViliusCustomer2", 0, "viliusCustomer2@gmail.com", "svbsdvisbv","svbsdvisbv" ,CUSTOMER, moneyGenerator.virtualMoney()),
				new Customer(null, "ViliusCustomer3", 0, "viliusCustomer3@gmail.com", "svbsdvisbv","svbsdvisbv" ,CUSTOMER, moneyGenerator.virtualMoney())

				);
		
		customerRepository.saveAll(customer);
	}
		private void seedServiceManager() {
			List<ServiceManager> serviceManager = List.of(
					new ServiceManager( "ViliusServiceManager", 0, "viliusServiceManager@gmail.com", "svbsdvisbv","svbsdvisbv" ,SERVICEMANAGER)
					);
			
			serviceRepsitory.saveAll(serviceManager);
	
	}
		private void seedManager() {
			List<Manager> manager = List.of(
					new Manager( "ViliusManager", 0, "viliusManager@gmail.com", "svbsdvisbv","svbsdvisbv" ,SERVICEMANAGER)
					);
			
			managerRepository.saveAll(manager);
	}	
		private void seedProduct() {
			List<Product> product = List.of(
					new Product("Intel i3","foto.png", 120,"Quad Core CPU",CPU)
					);
			
			productRepository.saveAll(product);
			}
}
