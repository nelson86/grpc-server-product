package com.narabel.grpc_server_product.service;

import com.narabel.grpc_server_product.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

	Optional<Product> findById(String id);

	List<Product> findAll();
}
