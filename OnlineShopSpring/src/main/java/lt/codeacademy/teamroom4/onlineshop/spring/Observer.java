package lt.codeacademy.teamroom4.onlineshop.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Admin;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.AdminRepository;

@Configuration
public class Observer {
	
	@Autowired
	AdminRepository adminRepository;
	
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		seedAdmin();
	}
	
	private void seedAdmin() {
		List<Admin> admin = List.of(
				new Admin("Vilius", "vilius@gmail.com", "svbsdvisbv","svbsdvisbv" ,"Admin")
				);
		
		adminRepository.saveAll(admin);
				
	}
	
	
}
