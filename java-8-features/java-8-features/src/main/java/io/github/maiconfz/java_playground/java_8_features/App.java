package io.github.maiconfz.java_playground.java_8_features;

import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Animal;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Dog;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.UnknownAnimal;

public class App {
	public static void main(String[] args) {
		interfaceStaticAndDefaultMethods();
	}

	public static void interfaceStaticAndDefaultMethods() {
		final Animal a = new Dog();
		final Animal b = new UnknownAnimal();

		// It will call only Dog.getType method
		System.out.println(a.getType());
		// It will call interface default method, since UnknownAnimal doesn't implement
		// anything
		System.out.println(b.getType());
	}
}
