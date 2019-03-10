package kr.ayukawa.springaop.model;

import lombok.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Getter @Setter
	private String name;

	@Getter @Setter
	private double price;
}
