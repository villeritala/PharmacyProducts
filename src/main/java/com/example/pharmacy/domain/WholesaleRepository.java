package com.example.pharmacy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WholesaleRepository extends CrudRepository<Wholesale, Long>{
	List<Wholesale> findByWholeName(String wholeName);
}
