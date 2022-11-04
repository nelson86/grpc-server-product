package com.narabel.grpc_server_product.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class Product {
	private String id;
	private String name;
	private String type;
	private String description;
	private Boolean enabled;
}
