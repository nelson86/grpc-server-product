package com.narabel.grpc_server_product.service.impl;

import com.narabel.grpc_server_product.model.Product;
import com.narabel.grpc_server_product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public Optional<Product> findById(String id) {
		return Optional.of(getProduct());
	}

	@Override
	public List<Product> findAll() {
		return Arrays.asList(getProduct());
	}

	private Product getProduct() {
		return Product.builder()
				.id(UUID.randomUUID().toString())
				.name("MacBook Pro M1")
				.type("Technology")
				.description("MacBook Pro M1, 16Gb ram, 1Tb SSD")
				.enabled(true)
				.build();
	}
}
