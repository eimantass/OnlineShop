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

	public List<Product> sortByDiscountAll(int direction) {
		if (direction == 1) {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "discount"));
		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "discount"));
		}
	}

	public List<Product> sortByNameAll(int direction) {
		if (direction == 1) {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		}
	}

	public List<Product> sortByPriceAll(int direction) {
		if (direction == 1) {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));

		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
		}
	}

	public List<Product> sortByCategoryAll(int direction) {

		if (direction == 1) {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "category"));

		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "category"));
		}
	}

	public List<Product> sortByBrandAll(int direction) {

		if (direction == 1) {
			return productRepository.findAll(Sort.by(Sort.Direction.DESC, "brand"));

		} else {
			return productRepository.findAll(Sort.by(Sort.Direction.ASC, "brand"));
		}
	}

	public Product getProductById(Long id) {
		return productRepository.getById(id);
	}
	

	// gauname visus produktus
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// slidebar pagal kaina
	public List<Product> searchByPrice(double min, double max, int direction, int sortingMethod) {
		if(max <= 0) {
		max = Integer.MAX_VALUE;
		}
		return sortingPlusPriceFiltering(min, max, direction, sortingMethod);
	}

	private List<Product> sortingPlusPriceFiltering(double min, double max, int direction, int sortingMethod) {
		switch (sortingMethod) {
		case 1:
			if (direction == 1) {
				return productRepository.search(Sort.by(Sort.Direction.DESC, "name"), min, max);
			} else {
				return productRepository.search(Sort.by(Sort.Direction.ASC, "name"), min, max);

			}

		case 2:
			if (direction == 1) {
				return productRepository.search(Sort.by(Sort.Direction.DESC, "price"), min, max);
			} else {
				return productRepository.search(Sort.by(Sort.Direction.ASC, "price"), min, max);

			}
		case 3:
			if (direction == 1) {
				return productRepository.search(Sort.by(Sort.Direction.DESC, "category"), min, max);
			} else {
				return productRepository.search(Sort.by(Sort.Direction.ASC, "category"), min, max);

			}
			
		case 4:
			if (direction == 1) {
				return productRepository.search(Sort.by(Sort.Direction.DESC, "discount"), min, max);
			} else {
				return productRepository.search(Sort.by(Sort.Direction.ASC, "discount"), min, max);

			}
			
		case 5:
			if (direction == 1) {
				return productRepository.search(Sort.by(Sort.Direction.DESC, "brand"), min, max);
			} else {
				return productRepository.search(Sort.by(Sort.Direction.ASC, "brand"), min, max);

			}
		default:
			return productRepository.search(Sort.by(Sort.Direction.ASC, "name"), min, max);
		}
	}

	// search products
	public List<Product> searchProductByNameLike(String searchName) {
		return productRepository.findByNameContainingIgnoreCase(searchName);
	}
	public List<Product> searchProductByCategory(Categories category){
		return productRepository.findAllWithCategory(category);
	}
	// galima atsifiltruoti pagal branda
	public List<Brands> getAllBrands() {
		return productRepository.findAllBrandsDistincts();
	}

	// galima atsifiltruoti pagal kategorija
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	// galima atsifiltruoti pagal parametrus
	public List<ProductParameters> getAllParameters() {
		return productParameterRepository.findAll();
	}

	// galima atsifiltruoti pagal didziausia nuolaida
	public Product getProductWithBigestDiscount() {
		Coupon discount = couponRepository.findMax();
		List<Product> products = productRepository.findAll();
		Product featuredProduct = null;
		for (Product p : products) {
			if (p.getDiscount() != null) {
				if (p.getDiscount().equals(discount)) {
					featuredProduct = p;
					break;
				}
			}
		}
		return featuredProduct;
	}
}
