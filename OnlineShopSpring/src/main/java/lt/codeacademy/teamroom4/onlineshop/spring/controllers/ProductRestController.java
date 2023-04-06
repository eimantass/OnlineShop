package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "search/{min}/{max}", method = RequestMethod.GET,
					produces = {MimeTypeUtils.APPLICATION_JSON_VALUE},
					headers = {"Accept=application/json"})
	public ResponseEntity<List<Product>> search(@PathVariable("min") double min, @PathVariable("max") double max ){
		try {
			List<Product> products = productService.searchByPrice(min, max, 0, 0);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
}
