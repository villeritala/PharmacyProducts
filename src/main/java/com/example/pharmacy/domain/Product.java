package com.example.pharmacy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;



@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prodId;
	
	@Length(min =6, max =6, message = "This field should contain six numbers")
	private String vnr;
	
	@NotEmpty(message = "This is a required field, please enter product name")
	private String name;
	
	private double price;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn(name = "manuId")
	private Manufacture manufacture;
	
	@ManyToOne
	@JoinColumn(name = "wholeId")
	private Wholesale wholesale;
	
	public Product() {
		super();
	}

	public Product(String vnr, String name, double price, int amount, Manufacture manufacture, Wholesale wholesale) {
		super();
		this.vnr = vnr;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.manufacture = manufacture;
		this.wholesale = wholesale;
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
	}

	public String getVnr() {
		return vnr;
	}

	public void setVnr(String vnr) {
		this.vnr = vnr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public Wholesale getWholesale() {
		return wholesale;
	}

	public void setWholesale(Wholesale wholesale) {
		this.wholesale = wholesale;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", vnr=" + vnr + ", name=" + name + ", price=" + price + ", amount="
				+ amount + "]";
	}
	
	
}
