package kr.ayukawa.springaop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Product {
	@Getter @Setter
	private String name;

	@Getter @Setter
	private double price;
}
