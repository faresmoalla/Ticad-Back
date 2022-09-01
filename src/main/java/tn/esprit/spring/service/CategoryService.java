package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.repository.CategoryRepository;

@Service
public class CategoryService {
@Autowired
CategoryRepository categoryRepo;




public List<Category> ListAllCategory() {
	// return commentRepo.findAll();
	return categoryRepo.findAll();
}

public Category addCategory(Category category) {
	return categoryRepo.save(category);
}

public void deleteCategory(Long idCategory) {
	Category category = categoryRepo.findById(idCategory).orElse(null);

	categoryRepo.delete(category);
}

public Category FindCategoryById(Long idCategory) {
	Category category = categoryRepo.findById(idCategory).orElse(null);
	return category;
}


	
}
