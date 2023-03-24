package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.repositories.KlientasRepository;

@RestController
public class KlientasController {
	@Autowired
	private KlientasRepository customerRepository;

	@GetMapping
	public List<Klientas> getCustomers(){
	return  customerRepository.findAll();
}
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
