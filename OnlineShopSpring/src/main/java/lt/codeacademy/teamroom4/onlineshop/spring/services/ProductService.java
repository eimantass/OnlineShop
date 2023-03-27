package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public CartDto getNewKrepselisDto() {
		CartDto dto = new CartDto();
		List<RecordDto> irasai = 
				getAllProducts()
				.stream()
				.map(p -> new Line(p, 0))
				.map(e -> new RecordDto(e))
				.toList();
		dto.setIrasai(irasai);
		return dto;
	}
	public Product findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<Product> allProducts = new ArrayList<Product>();
		allProducts.addAll(productRepository.findAll());
		
		for(long i =1; i<=allProducts.size();i++) {
			//Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);
			if(currentProduct.getName().toUpperCase().equals(searchName)){
				return (currentProduct);
			}
		}
		//return customerRepository.findById((long) 1);
		return null;
		
	}
}
