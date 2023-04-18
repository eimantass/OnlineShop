package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lt.codeacademy.teamroom4.onlineshop.spring.services.PhotoService;

@RestController
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@PostMapping("/photos") 
	public ResponseEntity<?> addPhoto(@RequestParam("file") MultipartFile file) { 
		try { 
			photoService.addPhoto(file.getBytes(), file.getName()); 
			return ResponseEntity.ok().build(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
			} 
	}
}
