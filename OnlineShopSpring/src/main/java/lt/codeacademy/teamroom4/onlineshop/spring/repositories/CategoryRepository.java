package lt.codeacademy.teamroom4.onlineshop.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
//This repository stores and retrieves product categories
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}