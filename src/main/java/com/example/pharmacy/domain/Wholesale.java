package com.example.pharmacy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Wholesale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long wholeId;
	private String wholeName;
	private String wholeCountry;
	private String wholeCity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "wholesale")
	private List<Product> products;

	public Wholesale() {
		
	}

	public Wholesale(String wholeName, String wholeCountry, String wholeCity) {
		super();
		this.wholeName = wholeName;
		this.wholeCountry = wholeCountry;
		this.wholeCity = wholeCity;
	}

	public Long getWholeId() {
		return wholeId;
	}

	public void setWholeId(Long wholeId) {
		this.wholeId = wholeId;
	}

	public String getWholeName() {
		return wholeName;
	}

	public void setWholeName(String wholeName) {
		this.wholeName = wholeName;
	}

	public String getWholeCountry() {
		return wholeCountry;
	}

	public void setWholeCountry(String wholeCountry) {
		this.wholeCountry = wholeCountry;
	}

	public String getWholeCity() {
		return wholeCity;
	}

	public void setWholeCity(String wholeCity) {
		this.wholeCity = wholeCity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
