package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
