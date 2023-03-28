package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Line;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<CartDto> getAll(){
		List<Cart> records = cartRepository.findAll();
		return records.stream().map(k -> new CartDto(k)).toList();
	}
	
	public void saveCart(CartDto cartDto) {
		List<Line> lines = new ArrayList<>();
		for(RecordDto record : cartDto.getRecords()) {
			if(record.getAmount() <=0)
				continue;
			
		Product product = productRepository.findById(record.getId()).get();
		Line line = new Line(product, record.getAmount());
		lines.add(line);
			
		}
		Cart krepselis = new Cart(lines);
		cartRepository.save(krepselis);
	}
}
