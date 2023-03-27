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
	CartRepository krepselisRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<CartDto> getAll(){
		List<Cart> kvitai = krepselisRepository.findAll();
		return kvitai.stream().map(k -> new CartDto(k)).toList();
	}
	
	public void saveKrepselis(CartDto krepselisDto) {
		List<Line> eilutes = new ArrayList<>();
		for(RecordDto irasas : krepselisDto.getIrasai()) {
			if(irasas.getKiekis() <=0)
				continue;
			
		Product product = productRepository.findById(irasas.getId()).get();
		Line eilute = new Line(product, irasas.getKiekis());
		eilutes.add(eilute);
			
		}
		Cart krepselis = new Cart(eilutes);
		krepselisRepository.save(krepselis);
	}
}
