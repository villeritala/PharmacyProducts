package com.example.pharmacy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.pharmacy.controller.ProductController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PharmacyApplicationTests {
	
	@Autowired
	private ProductController productController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
	}

}
