package lt.codeacademy.teamroom4.onlineshop.spring.services;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Coupon;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CategoryRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CouponRepository;
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

	// search products
	public List<Product> searchProductByNameLike(String searchName) {
		return productRepository.findByNameContainingIgnoreCase(searchName);
	}

	public List<Product> sortByNameAsc(String direction) {
		if (direction == "desc") {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		}
	}


	public List<Product> sortByPrice(String direction) {
		if (direction == "desc") {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));

		}
		else {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}}

	public List<Product> sortByCategoryAsc() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "category"));

	}

	public List<Product> sortByCategoryDesc() {
		return productRepository.findAll(Sort.by(Sort.Direction.DESC, "category"));

	}

	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}

	public List<Brands> getAllBrands() {
		return  productRepository.findAllBrandsDistincts();
	}
	
	public List<Categories> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Product getProductWithBigestDiscount() {
		Coupon discount = couponRepository.findMax();
		List<Product> products = productRepository.findAll();
		Product featuredProduct = null;
		for(Product p : products ) {
			if(p.getDiscount().equals(discount)) {
				featuredProduct = p;
				break;
			}
		}
		return featuredProduct;
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

			if ((currentProduct.getPrice() > minPrice) && (currentProduct.getPrice() < maxPrice)) {
				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

	}

	public List<Product> filterByCpuSocket(String[] cpuParameters) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> filteredProducts = new ArrayList<Product>();

		allProducts.addAll(productRepository.findAll());
		ArrayList<String[]> cpuSocket = allProducts.get(0).getParameters();

		for (long i = 1; i <= allProducts.size(); i++) {
			// Customer currentCustomer = customerRepository.getById(i);
			Product currentProduct = productRepository.findById(i).orElseThrow(RuntimeException::new);
			// String cpuSockets = currentProduct.getParameters().toString();
			// System.out.println(cpuSocket);
			if (cpuSocket.toArray().equals(cpuParameters)) {

				filteredProducts.add(currentProduct);
			}
		}
		return filteredProducts;

		// return cpuSocket.get(0);

	}

}
