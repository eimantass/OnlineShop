package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Photo;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired 
	private PhotoRepository photoRepository; 
	@Autowired
	private ProductService productService;
	public void addPhoto(byte[] data, String name) { 
		Photo photo = new Photo();
		photo.setData(data); 
		photo.setName(name);
		photoRepository.save(photo); 
	}
	public List<Photo> getAllPhotos() {
		return photoRepository.findAll();
	}

	public Photo findPhotoById(Long id) {
		return photoRepository.findById(id).orElseThrow(() -> new RuntimeException("Photo not found"));
	}

	 public void deletePhotoById(Long id) {
		 photoRepository.deleteById(id);
	 }

}
