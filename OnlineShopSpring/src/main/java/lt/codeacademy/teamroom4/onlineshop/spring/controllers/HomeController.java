package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.CartItem;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.CartItemRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Brands.*;

//This class handles functions, which do not require authentication to use
@RestController
public class HomeController {
	// Autowiring services and repositories

	@Autowired
	ProductService productService;

	@Autowired
	CartItemRepository cartRep;

	// Shows the main start page
	@GetMapping("/")
	public String startPage() {
		return "index";
	}

	// Shows all products
	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}
	// Adds customers

	// Shows cart
	@GetMapping("/cart")
	public CartItem getCart() {
		return cartRep.findById(1L).get();
	}

	// Searches products by name
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView search(@RequestParam("value") String searchName) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fragments/searchFragment");
		List<Product> products = productService.searchProductByNameLike(searchName);
		mv.addObject("products", products);
		return mv;
	}

	// Initial sorting before applying filters
	// http://localhost:8080/products/sort-by/filter/0/sorting-method/1/direction/1/min-price/0/maxPrice/100
	@GetMapping("/products/sort-by/filter/{filterType}/sorting-method/{sortingMethod}/direction/{direction}/min-price/{minPrice}/maxPrice/{maxPrice}")
	public List<Product> SortProductsByName(@PathVariable int filterType, @PathVariable int sortingMethod,
			@PathVariable int direction, @PathVariable int minPrice, @PathVariable int maxPrice) {
		if (filterType == 0) {
			switch (sortingMethod) {
			case 1:
				return productService.sortByNameAll(direction);

			case 2:
				return productService.sortByPriceAll(direction);
			case 3:
				return productService.sortByCategoryAll(direction);
			case 4:
				return productService.sortByDiscountAll(direction);
			case 5:
				return productService.sortByBrandAll(direction);

			default:
				return productService.sortByNameAll(direction);

			}
		} else if (filterType == 1) {
			
			return productService.searchByPrice(minPrice, maxPrice,direction,sortingMethod);
			// return productRepository2.findAll();
		}
		return null;

	}

	// Filters products by brand

	// @GetMapping("/products/filter-by-brand/{brand}")
	// public List<Product> filterByBrand(@PathVariable Brands brand) {
	// return productService.filterBrand(brand);
	// }

	// Filters products by max price
	/*
	 * @GetMapping("/products/filter-price/{minPrice}/{maxPrice}") public
	 * List<Product> filterByPrice(@PathVariable int minPrice, @PathVariable int
	 * maxPrice) { return productService.filterByPrice(minPrice, maxPrice); }
	 */
	// Gets all brands

	@GetMapping("/products/get-all-brands")
	public List<Brands> getAllBrands() {
		return productService.getAllBrands();
	}

	// Gets all parameters
	@GetMapping("/products/get-all-parameters")
	public List<ProductParameters> getAllParameters() {
		return productService.getAllParameters();
	}

	// Finds product with biggest discount
	@GetMapping("/products/get-product-with-biggest-discount")
	public Product getProductWithBiggestDiscount() {
		return productService.getProductWithBigestDiscount();
	}

//}

// Sorts products by name
	@GetMapping("/products/sort-by-name/{direction}")
	public List<Product> SortProductsByNameAsc(@PathVariable int direction) {
		return productService.sortByNameAll(direction);
	}
	/*
	 * // Sorts products by price
	 * 
	 * @GetMapping("/products/sort-by-price/{direction}") public List<Product>
	 * SortProductsByPrice(@PathVariable String direction) { return
	 * productService.sortByPriceAll(direction); }
	 * 
	 * // Sorts products by category
	 * 
	 * @GetMapping("/products/sort-by-category/{direction}") public List<Product>
	 * SortProductsByCategoryAsc(@PathVariable String direction) { return
	 * productService.sortByCategoryAll(direction); }
	 */
}