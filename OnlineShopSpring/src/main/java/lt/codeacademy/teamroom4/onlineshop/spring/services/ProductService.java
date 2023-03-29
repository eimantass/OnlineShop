package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lt.codeacademy.teamroom4.onlineshop.spring.dto.RecordDto;
import lt.codeacademy.teamroom4.onlineshop.spring.dto.CartDto;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ServiceManager;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("Intel i3", INTEL, "thumb1.gif", 120, "Quad Core CPU", CPU));
		products.add(new Product("Intel i3", INTEL, "thumb2.gif", 300, "Quad Core RAM", RAM));
		return products;
	}

	public Product find(Long id) {
		List<Product> products = findAll();
		for (Product product : products) {
			if (product.getId().equals(id)) {
				return product;
			}
		}
		return null;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product findByName(String searchName) {
		searchName = searchName.toUpperCase();
		List<Product> allProducts = new ArrayList<Product>();
		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);
			if (currentProduct.getName().toUpperCase().equals(searchName)) {
				return (currentProduct);
			}
		}
		// return customerRepository.findById((long) 1);
		return null;

	}
	
	public void deleteProductById(Long id) {
		productRepository.deleteById(id);
	}
	

	public List<Product> sortByNameAsc() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	public List<Product> sortByNameDesc() {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
	}

	public List<Product> sortByPriceAsc() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}

	public List<Product> sortByPriceDesc() {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
	}

	public List<Product> sortByCategoryAsc() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "category"));

	}

	public List<Product> sortByCategoryDesc() {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "category"));

	}

	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}

	public void saveProductToDB(MultipartFile file, String name, String description,
			Double price, Brands brand) {
		Product p = new Product();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			p.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
		}catch(IOException e){
			e.printStackTrace();
		}
		p.setDescription(description);
		p.setName(name);
		p.setBrand(brand);
		p.setPrice(price);
		Coupon c = new Coupon();
		c.setDiscount(0);
		p.setDiscount(c);
		
		productRepository.save(p);
		
	}
	
	public void saveProductDiscount(Long id, int discount) {
		Product p = new Product();
		p = productRepository.findById(id).get();
		if(p.getDiscount() == null) {
			Coupon c = new Coupon();
			c.setDiscount(discount);
			p.setDiscount(c);
		}else {
			p.getDiscount().setDiscount(discount);
		}
		productRepository.save(p);
	}

	
	
	public void changeProuctDiscount(Long id, int discount) {
		Product p = new Product();
		p = productRepository.findById(id).get();
		p.getDiscount().setDiscount(discount);
		productRepository.save(p);
	}
	

	public void changeProductName(Long id, String name) {
		Product p = new Product();
		p = productRepository.findById(id).get();
		p.setName(name);
		productRepository.save(p);
	}

	public List<Product> filterBrand(Brands brand) {

		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);

			if (currentProduct.getBrand().equals(brand)) {
				filteredProducts.add(currentProduct);
			}
		}
		// return customerRepository.findById((long) 1);
		return filteredProducts;
	}

	public List<Product> filterByMaxPrice(Long maxPrice) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);

			if (currentProduct.getPrice() < maxPrice) {
				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

	}
	public List<Product> filterByMinPrice(Long minPrice) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);

			if (currentProduct.getPrice() > minPrice) {
				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

	}
	public List<Product> filterByMinAndMaxPrice(Long minPrice, Long maxPrice) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);

			if ((currentProduct.getPrice() > minPrice) && (currentProduct.getPrice() < maxPrice )) {
				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

	}
	
	public List<Product> filterByCpuSocket(String[] cpuParameters ) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);
			String cpuSocket = currentProduct.getParameters().get(0).toString();
			
			if (cpuSocket.equals("LGA1200")) {
				
				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

	}
}
