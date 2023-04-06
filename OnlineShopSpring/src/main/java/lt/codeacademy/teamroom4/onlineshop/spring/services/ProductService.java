package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Enumerated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CategoryRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductParameterRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;


@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ProductParameterRepository productParameterRepository;

	
	
	public List<Product> sortByNameFiltered(String direction, List<Product> filteredProducts) {
		
		if (direction == "desc") {
			return filteredProducts;
		} else {
			return filteredProducts;
		}
	}
	
	public List<Product> sortByDiscountAll(String direction) {
		if (direction == "desc") {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "discount"));
		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "discount"));
		}
		}
	
	public List<Product> sortByNameAll(String direction) {
		if (direction == "desc") {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		}
	}


	public List<Product> sortByPriceAll(String direction) {
		if (direction == "desc") {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));

		}
		else {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}}

	public List<Product> sortByCategoryAll(String direction) {

	if (direction == "desc") {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "category"));

	}
		else {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "category"));
	}
	}
	public List<Product> sortByBrandAll(String direction) {

		if (direction == "desc") {
				return productRepository.findAll(Sort.by(Sort.Direction.DESC, "brand"));

		}
			else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "brand"));
		}
		}

	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}
	
	
	
	
	//gauname visus produktus
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	//slidebar pagal kaina
	public List<Product> searchByPrice(double min, double max){
		return productRepository.search(min, max);
	}
	
	//search products
	public List<Product> searchProductByNameLike(String searchName) {
		return productRepository.findByNameContainingIgnoreCase(searchName);
	}

	//galima atsifiltruoti pagal branda
	public List<Brands> getAllBrands() {
		return  productRepository.findAllBrandsDistincts();
	}
	
	//galima atsifiltruoti pagal kategorija
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	//galima atsifiltruoti pagal parametrus
	public List<ProductParameters> getAllParameters() {
		return productParameterRepository.findAll();
	}
	
	//galima atsifiltruoti pagal didziausia nuolaida
		public Product getProductWithBigestDiscount() {
			Coupon discount = couponRepository.findMax();
			List<Product> products = productRepository.findAll();
			Product featuredProduct = null;
			for(Product p : products) {
				if(p.getDiscount() != null) {
				if(p.getDiscount().equals(discount)) {
					featuredProduct = p;
					break;
				}
			}}
			return featuredProduct;
		}
	

	public List<Product> filterByMaxPrice(int maxPrice) {
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

}
