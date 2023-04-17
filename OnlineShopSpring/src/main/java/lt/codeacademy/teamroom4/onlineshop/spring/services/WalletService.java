package lt.codeacademy.teamroom4.onlineshop.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Wallet;
import lt.codeacademy.teamroom4.onlineshop.spring.exception.WalletException;
import lt.codeacademy.teamroom4.onlineshop.spring.repositories.WalletRepository;
//This class handles Wallet service
@Service
public class WalletService {
	//Autowiring wallet repository
	@Autowired
	WalletRepository walletRepository;
	//Returns all wallets 
	public List<Wallet> getAll(){
		return walletRepository.findAllByOrderByPriority();
	}
	//Returns wallet by it or throws exception if wallet is not found
	public Wallet getById(Long id) {
		Optional<Wallet> wallet = walletRepository.findById(id);
		if(wallet.isPresent()) {
			return wallet.get();
		}
		throw new WalletException("Wallet with " + id + "does not exists");
	}
	//Creates or updates wallet
	public Wallet createOrUpdate(Wallet wallet) {
		if(wallet.getId() == null) {
			walletRepository.save(wallet);
		}else {
			walletRepository.save(wallet);
		}
		return wallet;
	}
	//Deletes wallet accordingly to id
	public boolean delete(Long id) {
		Optional<Wallet> wallet = walletRepository.findById(id);
		if(wallet.isPresent()) {
			walletRepository.delete(wallet.get());
			return true;
		}
		throw new WalletException("Wallet with " + id + "does not exists");
	}
}
