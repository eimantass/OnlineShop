package lt.codeacademy.teamroom4.onlineshop.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Photo;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.PhotoRepository;

@Service
public class PhotoService {
	
	@Autowired 
	private PhotoRepository photoRepository; 
	
	public void addPhoto(byte[] data, String name) { 
		Photo photo = new Photo();
		photo.setData(data); 
		photo.setName(name); 
		photoRepository.save(photo); 
	}
}
