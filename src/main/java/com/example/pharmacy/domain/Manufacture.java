package com.example.pharmacy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Manufacture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long manuId;
	private String manuName;
	private String manuCountry;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacture")
	private List<Product> products;

	public Manufacture() {
		
	}

	public Manufacture(String manuName, String manuCountry) {
		super();
		this.manuName = manuName;
		this.manuCountry = manuCountry;
	}

	public Long getManuId() {
		return manuId;
	}

	public void setManuId(Long manuId) {
		this.manuId = manuId;
	}

	public String getManuName() {
		return manuName;
	}

	public void setManuName(String manuName) {
		this.manuName = manuName;
	}

	public String getManuCountry() {
		return manuCountry;
	}

	public void setManuCoutry(String manuCountry) {
		this.manuCountry = manuCountry;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
}
