package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Cart;
import lt.codeacademy.teamroom4.onlineshop.spring.entities.Photo;
import lt.codeacademy.teamroom4.onlineshop.spring.services.PhotoService;

@RestController
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@RequestMapping(value= "/photos",   
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
	@GetMapping("/allPhotos")
	public List<Photo> allPhotos(){
		return photoService.getAllPhotos();
	}
}
