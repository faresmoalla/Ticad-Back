package tn.esprit.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Category;
import tn.esprit.spring.service.CategoryService;


@RestController
@RequestMapping("/category")
@Api(tags = "Category Management")
@CrossOrigin
public class CategoryController {
	@Autowired
	CategoryService categService;
	
	
	@ApiOperation(value = "Add Category")
	@PostMapping("/add-publication")
	public Category addCategory( @RequestBody Category f) {
		
		 return categService.addCategory(f);

	}
	
	@ApiOperation(value = "Delete Category")

	@DeleteMapping("/supprimer-category/{idCategory}")
	@ResponseBody
	public void deletePublication(
			@PathVariable("idCategory") Long idCategory) {
		categService.deleteCategory(idCategory);

	}
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {

		
		List<Category> listp = categService.ListAllCategory();
		return listp;

	}
}
