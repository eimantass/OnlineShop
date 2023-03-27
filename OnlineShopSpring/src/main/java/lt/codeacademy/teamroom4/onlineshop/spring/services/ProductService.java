package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
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
}
