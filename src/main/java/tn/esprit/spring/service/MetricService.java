package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Category;
import tn.esprit.spring.entity.Metric;
import tn.esprit.spring.repository.CategoryRepository;
import tn.esprit.spring.repository.MetricRepository;

@Service
public class MetricService {
@Autowired
MetricRepository metricRepo;
	@Autowired
	CategoryRepository categRepo;



public List<Metric> ListAllMetric() {
	
	
	// return commentRepo.findAll();
	return metricRepo.findAll();
}

public Metric addMetric(Metric metric, Long idCategory) {
	Category cat = categRepo.findById(idCategory).orElse(null);
metric.setCategory(cat);
	return metricRepo.save(metric);
}

public void deleteMetric(Long idMetric) {
	Metric metric = metricRepo.findById(idMetric).orElse(null);

	metricRepo.delete(metric);
}

public Metric FindCategoryById(Long idMetric) {
	Metric metric = metricRepo.findById(idMetric).orElse(null);
	return metric;
}

public List<Metric> ListMetricByCategory(Long idCategory) {
	
	Category categ = categRepo.findById(idCategory).orElse(null);

	List<Metric> metric= metricRepo.listeMetricByCategory(idCategory);
	return metric ;
	
	
}



public List<Object> Statistiques() {
	
	ArrayList<Object> arrayList = new ArrayList<Object>();
	
	float somme=0;
	for (Category categ: categRepo.findAll()) {
		for (Metric metric : categ.getMetrics()) {
			somme = somme+ metric.getValue();			
	}
		arrayList.add(categ.getCategoryId());
		arrayList.add(categ.getLabel());
		arrayList.add(somme*categ.getCoef());
		System.out.println("/////////////"+somme);
		
	}
	return arrayList;
}



	
}
