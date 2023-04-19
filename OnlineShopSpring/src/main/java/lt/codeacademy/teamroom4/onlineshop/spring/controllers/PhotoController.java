package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.io.IOException;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PhotoRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.ProductRepository;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Photo;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Product;
import lt.codeacademy.teamroom4.onlineshop.spring.services.PhotoService;
@RequestMapping("/photo")
@RestController
public class PhotoController {
	
	@Autowired
	private PhotoRepository repository;
	
	@Autowired
	private PhotoService photoService;
	@Autowired
	private ProductRepository productRepository;
	@RequestMapping(  
			method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addPhoto(@RequestParam("file") MultipartFile file) { 
		try { 
			photoService.addPhoto(file.getBytes(), file.getName()); 
			
			return ResponseEntity.ok().build(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
			} 
	}
	@PostMapping("assign-photo/{photoId}/{productId}")
	public void assignPhotoToUserById(@PathVariable Long photoId,@PathVariable Long productId) {
		Photo photo = repository.findById(photoId).orElseThrow(() -> new RuntimeException("Photo not found"));
		Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
		photo.setProduct(product);
		repository.save(photo);
		
	}
	 @GetMapping("/{id}")
	 public ResponseEntity<byte[]> getPhoto(@PathVariable Long id) {
		 Optional<Photo> photo = repository.findById(id);
	     if (photo.isPresent()) {
	    	 byte[] data = photo.get().getData();
	         HttpHeaders headers = new HttpHeaders();
	         headers.setContentType(MediaType.IMAGE_JPEG);
	         return new ResponseEntity<>(data, headers, HttpStatus.OK);
	     }
	     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }

	@GetMapping("/allPhotos")
	public List<Photo> allPhotos(){
		return photoService.getAllPhotos();
	}
	
	 @DeleteMapping("/{id}")
	 public ResponseEntity<?> deletePhotoById(@PathVariable Long id) {
		 photoService.deletePhotoById(id);
	     return ResponseEntity.noContent().build();
	 }

}
