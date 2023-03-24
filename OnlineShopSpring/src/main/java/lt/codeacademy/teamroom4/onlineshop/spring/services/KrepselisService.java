package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.IrasasDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.KrepselisDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Eilute;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Krepselis;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.KrepselisRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;

@Service
public class KrepselisService {

	@Autowired
	KrepselisRepository krepselisRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public List<KrepselisDto> getAll(){
		List<Krepselis> kvitai = krepselisRepository.findAll();
		return kvitai.stream().map(k -> new KrepselisDto(k)).toList();
	}
	
	public void saveKrepselis(KrepselisDto krepselisDto) {
		List<Eilute> eilutes = new ArrayList<>();
		for(IrasasDto irasas : krepselisDto.getIrasai()) {
			if(irasas.getKiekis() <=0)
				continue;
			
		Product product = productRepository.findById(irasas.getId()).get();
		Eilute eilute = new Eilute(product, irasas.getKiekis());
		eilutes.add(eilute);
			
		}
		Krepselis krepselis = new Krepselis(eilutes);
		krepselisRepository.save(krepselis);
	}
}
