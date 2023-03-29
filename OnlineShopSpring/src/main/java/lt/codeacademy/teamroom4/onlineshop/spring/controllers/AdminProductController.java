package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lt.codeacademy.teamroom4.onlineshop.spring.services.ProductService;

@Controller
public class AdminProductController {
	
	@Autowired
	ProductService productService;
		
	@GetMapping("/Admin/product")
	public String showAddProduct() {
		return "Admin/product";
	}
	
	//adminas gali prideti nauja preke i parduotuve
//	@PostMapping("/Admin/addCategory")
//	public String addCategory(@ModelAttribute Category category, Model model) {
//		productService.saveCategory(category);
//		return "redirect:/Admin/product";
//	}
	
//	@PostMapping("/Admin/addPictureToProduct")
//	public String addImageToProduct(@RequestParam("file") MultipartFile file,
//			@RequestParam("product_id") Long id) {
//		productService.addImageToProduct(file, id);
//		return "redirect:/Admin/product";
//	}
	
	@PostMapping("/Admin/addDiscountToP")
	public String addDiscountToProduct(@RequestParam("product_id") Long id, 
			@RequestParam("discount") int discount) {
		productService.saveProductDiscount(id, discount);
		return "redirect:/Admin/product";
	}
	
	//Adminas keicia prekiu info(redaguoja prekes)
	@PostMapping("/Admin/changeDiscount")
	public String changeDiscount(@RequestParam("id") Long id,
			@RequestParam("newDiscount") int discount) {
		productService.changeProuctDiscount(id,discount);
		return "redirect:/Admin/index";
	}
	
}
