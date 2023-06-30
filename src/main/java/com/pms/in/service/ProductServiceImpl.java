package com.pms.in.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.in.entity.Product;
import com.pms.in.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
				return productRepository.findAll();
	}

	@Override
	public Product getProduct(Integer pid) {
		
		return productRepository.findById(pid).get();
	}

	@Override
	public void deleteProduct(Integer pid) {
		Product product=getProduct(pid);
		productRepository.deleteById(product.getPid());

	}

	@Override
	public Product updateProduct(Integer pid, Product product) {
		Product existingProduct=getProduct(pid);
		existingProduct.setPname(product.getPname());
		return productRepository.save(existingProduct);
		

	}

	@Override
	public List<Product> getAllProductsByName(String pname) {
		
		return productRepository.findByPname(pname);
	}

}
