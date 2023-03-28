package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ServiceRepository;

@Service
public class ServiceManagerService {
	@Autowired
	private ServiceRepository serviceRepository;

	public ServiceManager findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<ServiceManager> allServiceManagers = new ArrayList<ServiceManager>();
		allServiceManagers.addAll(serviceRepository.findAll());
		
		for(long i =1; i<=allServiceManagers.size();i++) {
			//Customer currentCustomer = customerRepository.getById(i);
			ServiceManager currentManager = serviceRepository.findById(i).orElseThrow(RuntimeException::new);
			if(currentManager.getFullName().toUpperCase().equals(searchName)){
				return (currentManager);
			}
		}
		//return customerRepository.findById((long) 1);
		return null;
		
	}
}
