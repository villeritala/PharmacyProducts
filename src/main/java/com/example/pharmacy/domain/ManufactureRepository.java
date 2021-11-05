package com.example.pharmacy.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ManufactureRepository extends CrudRepository<Manufacture, Long>{
	List<Manufacture> findByManuName(String manuName);
}
