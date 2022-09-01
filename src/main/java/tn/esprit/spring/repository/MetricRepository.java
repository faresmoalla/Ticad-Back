package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Metric;


@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
	
	@Query("Select c from Metric c where c.category.categoryId=:categoryId")
	List<Metric> listeMetricByCategory(@Param("categoryId") Long categoryId) ;
	
	
}
