package tn.esprit.spring.controller;

import java.util.List;
import java.util.Set;

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
import tn.esprit.spring.entity.Metric;
import tn.esprit.spring.service.CategoryService;
import tn.esprit.spring.service.MetricService;

@RestController
@RequestMapping("/metric")
@Api(tags = "Metric Management")
@CrossOrigin
public class MetricController {
	@Autowired
	MetricService metricService;
	
	
	@ApiOperation(value = "Add metric")
	@PostMapping("/add-metric/{idMetric}")
	public Metric addMetric( @RequestBody Metric f, @PathVariable("idMetric") Long idMetric) {
		
		 return metricService.addMetric(f,idMetric);

	}
	
	@ApiOperation(value = "Delete Metric")

	@DeleteMapping("/supprimer-metric/{idMetric}")
	@ResponseBody
	public void deleteMetric(
			@PathVariable("idMetric") Long idMetric) {
		metricService.deleteMetric(idMetric);

	}
	
	@GetMapping("/getAllMetric")
	public List<Metric> getAllMetric() {

		
		List<Metric> listp = metricService.ListAllMetric();
		return listp;

	}
	
	@GetMapping("/getMetricByCategory/{idCategory}")
	public List<Metric> getMetricByCategory(@PathVariable("idCategory") Long idCategory) {

		
		List<Metric> listp = metricService.ListMetricByCategory(idCategory);
		return listp;

	}
	@GetMapping("/Stat")
	public List<Object> getAlStatlMetric() {

		
		List<Object> listp = metricService.Statistiques();
		return listp;

	}
}
