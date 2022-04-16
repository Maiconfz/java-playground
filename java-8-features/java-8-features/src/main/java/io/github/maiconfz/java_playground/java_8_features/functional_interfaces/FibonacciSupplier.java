package io.github.maiconfz.java_playground.java_8_features.functional_interfaces;

import java.util.function.Supplier;

public class FibonacciSupplier implements Supplier<Integer> {

	private int position;

	public FibonacciSupplier(int position) {
		this.position = position;
	}

	@Override
	public Integer get() {
		return calculate(position);

	}

	private Integer calculate(int n) {
		return n <= 1 ? n : (calculate(n - 1) + calculate(n - 2));
	}

}
