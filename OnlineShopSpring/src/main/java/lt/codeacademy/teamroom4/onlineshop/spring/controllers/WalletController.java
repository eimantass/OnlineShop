package lt.codeacademy.teamroom4.onlineshop.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.services.ValidationErrorService;
import lt.codeacademy.teamroom4.onlineshop.spring.services.WalletService;
//This controller handles wallet mappings
@RestController
@RequestMapping("/wallet")
public class WalletController {
	//Autowiring services
	@Autowired
	WalletService walletService;
	
	@Autowired
	ValidationErrorService validationErrorService;
	//Shows all wallets. This function will only be accessible to admin.
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(walletService.getAll(), HttpStatus.OK);
	}
	//Gets wallet by id
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		return new ResponseEntity<>(walletService.getById(id), HttpStatus.OK);
	}
	//Creates new wallet
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Wallet wallet, BindingResult result){
		ResponseEntity errors = validationErrorService.validate(result);
		if(errors != null) return errors;
		Wallet walletSaved = walletService.createOrUpdate(wallet);
		return new ResponseEntity<Wallet>(walletSaved, HttpStatus.CREATED);
	}
	//Updates wallet
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Wallet wallet, BindingResult result){
		ResponseEntity errors = validationErrorService.validate(result);
		if(errors != null) return errors;
		wallet.setId(id);
		Wallet walletSaved = walletService.createOrUpdate(wallet);
		return new ResponseEntity<Wallet>(walletSaved, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		walletService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
}
