package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.exception.WalletException;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WalletRepository;

@Service
public class WalletService {
	
	@Autowired
	WalletRepository walletRepository;
	
	public List<Wallet> getAll(){
		return walletRepository.findAllByOrderByPriority();
	}
	
	public Wallet getById(Long id) {
		Optional<Wallet> wallet = walletRepository.findById(id);
		if(wallet.isPresent()) {
			return wallet.get();
		}
		throw new WalletException("Wallet with " + id + "does not exists");
	}
	
	public Wallet createOrUpdate(Wallet wallet) {
		if(wallet.getId() == null) {
			walletRepository.save(wallet);
		}else {
			walletRepository.save(wallet);
		}
		return wallet;
	}
	
	public boolean delete(Long id) {
		Optional<Wallet> wallet = walletRepository.findById(id);
		if(wallet.isPresent()) {
			walletRepository.delete(wallet.get());
			return true;
		}
		throw new WalletException("Wallet with " + id + "does not exists");
	}
}
