package lt.codeacademy.teamroom4.onlineshop.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.ProductParameters;
//This repository stores and retrieves product parameters
@Repository
public interface ProductParameterRepository extends JpaRepository<ProductParameters,Long>{

}
