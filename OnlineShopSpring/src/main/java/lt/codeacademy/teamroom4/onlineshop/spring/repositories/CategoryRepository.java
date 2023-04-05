package lt.codeacademy.teamroom4.onlineshop.spring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.codeacademy.teamroom4.onlineshop.spring.entities.Category;
import lt.codeacademy.teamroom4.onlineshop.spring.utils.Parameters.Categories;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}