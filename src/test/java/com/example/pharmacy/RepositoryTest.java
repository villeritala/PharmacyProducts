package com.example.pharmacy;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.pharmacy.domain.Manufacture;
import com.example.pharmacy.domain.ManufactureRepository;
import com.example.pharmacy.domain.Product;
import com.example.pharmacy.domain.ProductRepository;
import com.example.pharmacy.domain.Wholesale;
import com.example.pharmacy.domain.WholesaleRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ManufactureRepository manufactureRepository;
	
	@Autowired
	private WholesaleRepository wholesaleRepository;
	
	@Test
	public void findByNameShouldReturnProduct() {
		List<Product> products = productRepository.findByName("Simvastatin");
		assertThat(products).hasSize(1);
		assertThat(products.get(0).getVnr()).isEqualTo(123456);
	}
	@Test
	public void createNewProduct() {
		Product product = new Product("456234", "Panadol", 9.50, 21, new Manufacture("Orion", "Finland"), new Wholesale("Tamro", "Finland", "Vantaa"));
		productRepository.save(product);
		assertThat(product.getProdId()).isNotNull();
	}
	@Test
	public void findByManuNameShouldReturnManufacture() {
		List<Manufacture> manufactures = manufactureRepository.findByManuName("Orion Pharma");
		assertThat(manufactures).hasSize(1);
		assertThat(manufactures.get(0).getManuCountry()).isEqualTo("Finland");
	}
	@Test
	public void createNewManufacture() {
		Manufacture manufacture = new Manufacture("Pfizer", "USA");
		manufactureRepository.save(manufacture);
		assertThat(manufacture.getManuId()).isNotNull();
	}
	@Test
	public void findByWholeNameShouldReturnWholesale() {
		List<Wholesale> wholesales = wholesaleRepository.findByWholeName("Tamro");
		assertThat(wholesales).hasSize(1);
		assertThat(wholesales.get(0).getWholeCity()).isEqualTo("Vantaa");
	}
	@Test
	public void createNewWholesale() {
		Wholesale wholesale  = new Wholesale("Magnum", "Vantaa", "Finland");
		wholesaleRepository.save(wholesale);
		assertThat(wholesale.getWholeId()).isNotNull();
	}
}
