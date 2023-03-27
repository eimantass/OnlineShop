package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.IrasasDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.KrepselisDto;
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
	
	public KrepselisDto getNewKrepselisDto() {
		KrepselisDto dto = new KrepselisDto();
		List<IrasasDto> irasai = 
				getAllProducts()
				.stream()
				.map(p -> new Line(p, 0))
				.map(e -> new IrasasDto(e))
				.toList();
		dto.setIrasai(irasai);
		return dto;
	}
}
