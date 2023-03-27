package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.IrasasDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.KrepselisDto;
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
	
	public List<KrepselisDto> getAll(){
		List<Cart> kvitai = krepselisRepository.findAll();
		return kvitai.stream().map(k -> new KrepselisDto(k)).toList();
	}
	
	public void saveKrepselis(KrepselisDto krepselisDto) {
		List<Line> eilutes = new ArrayList<>();
		for(IrasasDto irasas : krepselisDto.getIrasai()) {
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
