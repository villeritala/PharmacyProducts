package com.example.pharmacy.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pharmacy.domain.ManufactureRepository;
import com.example.pharmacy.domain.Product;
import com.example.pharmacy.domain.ProductRepository;
import com.example.pharmacy.domain.WholesaleRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ManufactureRepository manufactureRepository;
	
	@Autowired
	private WholesaleRepository wholesaleRepository;
	
	//Login page
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	//List of all products
	@RequestMapping(value = "/productlist")
	public String productList(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "productlist";
	}
	
	//Adding product
	@RequestMapping(value = "/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("manufactures", manufactureRepository.findAll());
		model.addAttribute("wholesales", wholesaleRepository.findAll());
		return "addproduct";
	}
	
	//Saving product information
	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public String save(@Valid Product product, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("manufactures", manufactureRepository.findAll());
			model.addAttribute("wholesales", wholesaleRepository.findAll());
			return "addproduct";
		} else {
			productRepository.save(product);
			return "redirect:productlist";
		}
		
	}
	
	//Deleting product from product list
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("id") Long prodId, Model model) {
		productRepository.deleteById(prodId);
		return "redirect:../productlist";
	}
	
	//Editing product information 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") Long prodId, Model model) {
		model.addAttribute("product", productRepository.findById(prodId));
		model.addAttribute("manufactures", manufactureRepository.findAll());
		model.addAttribute("wholesales", wholesaleRepository.findAll());
		return "editproduct";
	}
}
