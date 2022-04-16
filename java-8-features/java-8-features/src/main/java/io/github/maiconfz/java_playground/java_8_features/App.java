package io.github.maiconfz.java_playground.java_8_features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Animal;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Dog;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.UnknownAnimal;

public class App {
	public static void main(String[] args) {
		interfaceStaticAndDefaultMethods();
		System.out.println("---");
		methodReferences();
		System.out.println("---");
		optionals();
		System.out.println("---");
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

	public static void methodReferences() {
		final List<String> stringsWithBlankStringAmongThem = Arrays.asList("Test 1", "", "Test 2");

		// static method reference
		boolean hasAnyBlankyStringOnListByStaticMethodReferece = stringsWithBlankStringAmongThem.stream().anyMatch(StringUtils::isBlank);
		System.out.println("has any blank string on list by static method reference? " + hasAnyBlankyStringOnListByStaticMethodReferece);

		// object method reference
		boolean hasAnyEmptyStringOnListByInstanceMethodReference = stringsWithBlankStringAmongThem.stream().anyMatch(String::isEmpty);
		System.out.println("has any empty string on list by instance method reference? " + hasAnyEmptyStringOnListByInstanceMethodReference);

		long countEqualsStringsByOtherObjectMethodReferece = stringsWithBlankStringAmongThem.stream().filter(""::equals).count();
		System.out.println("count empty strings by other object method reference: " + countEqualsStringsByOtherObjectMethodReferece);

		// constructor reference
		final List<String> listCopyByConstructorReferecen = stringsWithBlankStringAmongThem.stream().map(String::new).collect(Collectors.toList());
		System.out.println("copied list using constructor reference: " + listCopyByConstructorReferecen);
	}

	public static void optionals() {

		// Empty optional
		final Optional<Object> emptyOptional = Optional.empty();
		System.out.println("emptyOptional is present? " + emptyOptional.isPresent());

		// Optional of non-null string
		final Optional<String> stringOptional = Optional.of("String");
		System.out.println("stringOptional.get: " + stringOptional.get());

		// Optional of null
		final Optional<String> nullStringOptional = Optional.ofNullable(null);
		System.out.println("nullStringOptional.orElse: " + nullStringOptional.orElse("else String"));

		// Optional map
		final Optional<String> mapTestOptional = Optional.of("ABCDE").map(s -> s.charAt(1)).map(String::valueOf);
		System.out.println("mapTestOptional: " + mapTestOptional.get());

		final String flatMapTestOptional = Optional.ofNullable(null).flatMap(o -> Optional.of(String.valueOf(o.hashCode()))).orElse("Optional is empty");
		System.out.println("flatMapTestOptional: " + flatMapTestOptional);
	}
}
