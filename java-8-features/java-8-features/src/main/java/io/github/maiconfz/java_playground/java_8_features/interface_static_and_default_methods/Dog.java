package io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods;

public class Dog implements Animal {
	@Override
	public String getType() {
		return Dog.class.getSimpleName();
	}
}
