package com.pms.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.in.entity.Product;
import com.pms.in.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping(value = "/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		Product savedProduct=productService.saveProduct(product);		
		ResponseEntity<Product> re=new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
		return re;
		
	}
	
	
	@GetMapping(value = "/{pid}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer pid) {
		
		Product product=productService.getProduct(pid);
				
		ResponseEntity<Product> re=new ResponseEntity<Product>(product,HttpStatus.OK);
		return re;
		
	}
	
	
	@GetMapping(value = "/allProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> allProducts=productService.getAllProducts();
				
		ResponseEntity<List<Product>> re=new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
		return re;
		
	}
	
	
	@DeleteMapping(value = "/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid){
		productService.deleteProduct(pid);
		ResponseEntity<String> re=new ResponseEntity<String>("Product with Id:"+pid+" Deleted Successfully!",HttpStatus.OK);
		return re;		
	}
	
	@PutMapping(value = "/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer pid,@RequestBody Product product){
				
		Product updatedProduct=productService.updateProduct(pid, product);
		ResponseEntity<Product> re=new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(value = "/productName/{pname}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String pname){
				
		List<Product> productsByName=productService.getAllProductsByName(pname);
		ResponseEntity<List<Product>> re=new ResponseEntity<List<Product>>(productsByName,HttpStatus.OK);
		return re;
	}
	

}
