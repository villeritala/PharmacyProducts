package com.example.pharmacy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.pharmacy.domain.Manufacture;
import com.example.pharmacy.domain.ManufactureRepository;
import com.example.pharmacy.domain.Product;
import com.example.pharmacy.domain.ProductRepository;
import com.example.pharmacy.domain.User;
import com.example.pharmacy.domain.UserRepository;
import com.example.pharmacy.domain.Wholesale;
import com.example.pharmacy.domain.WholesaleRepository;


@SpringBootApplication
public class PharmacyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PharmacyApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner pharmacyProduct(ProductRepository productRepository, ManufactureRepository manufactureRepository, WholesaleRepository wholesaleRepository, UserRepository userRepository) {
		return (args) -> {
			log.info("save a couple of products");
			Manufacture manu1 = new Manufacture("Orion Pharma", "Finland");
			Manufacture manu2 = new Manufacture("GSK Pharma", "Germany");
			manufactureRepository.save(manu1);
			manufactureRepository.save(manu2);
			
			Wholesale sale1 = new Wholesale("Tamro","Finland", "Vantaa");
			Wholesale sale2 = new Wholesale("Medifon", "Finland", "Espoo");
			wholesaleRepository.save(sale1);
			wholesaleRepository.save(sale2);
			
			productRepository.save(new Product("983094", "SIMVASTATIN ORION tabletti, kalvopäällysteinen 10 mg", 12.35, 34, manu1, sale1));
			productRepository.save(new Product("122943", "LEVEMIR FLEXPEN injektioneste, liuos, esitäytetty kynä 100 U/ml", 42.95, 12, manu2, sale2));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@mail.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@mail.com", "ADMIN");
			userRepository.save(user1);
			userRepository.save(user2);
			
			log.info("fetch all products");
			for(Product product : productRepository.findAll()) {
				log.info(product.toString());
			}
		};
	}
}
