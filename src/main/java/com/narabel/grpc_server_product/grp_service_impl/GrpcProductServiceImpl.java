package com.narabel.grpc_server_product.grp_service_impl;

import com.narabel.grpc_server_product.model.Product;
import com.narabel.grpc_server_product.service.ProductService;
import com.narabel.productservicegrpc.grpc.Empty;
import com.narabel.productservicegrpc.grpc.ProductObject;
import com.narabel.productservicegrpc.grpc.ProductsList;
import com.narabel.productservicegrpc.grpc.id;
import com.narabel.productservicegrpc.grpc.productServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Log4j2
@GrpcService
public class GrpcProductServiceImpl extends productServiceGrpc.productServiceImplBase {

	@Autowired
	private ProductService productService;

	@Override
	public void getById(id request, StreamObserver<ProductObject> responseObserver) {
		log.info("ProductId: {}", request.getId());
		Product product = productService.findById(request.getId()).get();

		responseObserver.onNext(toObjectGrpc(product));
		responseObserver.onCompleted();
	}

	@Override
	public void gelAll(Empty request, StreamObserver<ProductsList> responseObserver) {
		List<Product> products = productService.findAll();

		ProductsList.Builder productsList = ProductsList.newBuilder();
		for(Product product: products) {
			productsList.addProduct( toObjectGrpc(product) );
		}

		responseObserver.onNext(productsList.build());
		responseObserver.onCompleted();
	}

	private ProductObject toObjectGrpc(Product product) {
		return ProductObject.newBuilder()
				.setId(product.getId())
				.setName(product.getName())
				.setType(product.getType())
				.setDescription(product.getDescription())
				.setEnabled(product.getEnabled())
				.build();
	}
}
