package io.github.maiconfz.java_playground.java_8_features;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import org.apache.commons.lang3.StringUtils;

import io.github.maiconfz.java_playground.java_8_features.functional_interfaces.ApplySuffixFunction;
import io.github.maiconfz.java_playground.java_8_features.functional_interfaces.ApplySuffixImpl;
import io.github.maiconfz.java_playground.java_8_features.functional_interfaces.FibonacciSupplier;
import io.github.maiconfz.java_playground.java_8_features.functional_interfaces.ObjectSysout;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Animal;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.Dog;
import io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods.UnknownAnimal;

public class App {
	public static void main(String[] args) {
		System.out.println("## Interface static and default methods ##\n");
		interfaceStaticAndDefaultMethods();
		System.out.println("\n## Method References ##\n");
		methodReferences();
		System.out.println("\n## Optionals ##\n");
		optionals();
		System.out.println("\n## Functional Interfaces ##\n");
		functionalInterfaces();
		System.out.println("\n## Streams ##\n");
		streams();
		System.out.println("\n## New Date and Time APIs ##\n");
		newDateAndTimeAPI();
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

		try {
			Optional.ofNullable(null).orElseThrow(IllegalStateException::new);
		} catch (Exception e) {
			System.out.println("Entered on catch block due exception: " + e);
		}
	}

	public static void functionalInterfaces() {

		final Function<String, Integer> stringToIntegerFunction = Integer::valueOf;
		System.out.println("stringToIntegerFunction:" + stringToIntegerFunction.apply("10"));

		final ApplySuffixFunction applySuffixFunction = (s, suffix) -> s.concat(suffix + " lambda");
		System.out.println("applySuffixFunction: " + applySuffixFunction.apply("inline call", " inline suffix"));

		final ApplySuffixFunction customApplySuffixFunction = new ApplySuffixImpl();
		System.out.println("customApplySuffixFunction" + customApplySuffixFunction.apply("object call", " suffix"));

		final Supplier<List<Integer>> integerSupplier = () -> Arrays.asList(1, 2, 3);
		System.out.println("integerSupplier: " + integerSupplier.get());

		final Supplier<Integer> fibonacciSupplier = new FibonacciSupplier(10);
		System.out.println("fibonacciSupplier(10): " + fibonacciSupplier.get());

		final Consumer<Integer> integerConsumer = System.out::println;
		integerConsumer.accept(10);

		final Consumer<Object> objectSysoutConsumer = new ObjectSysout();
		objectSysoutConsumer.accept(1000);
	}

	public static void streams() {

		// Empty stream
		final Stream<String> emptyStream = Stream.empty();

		// Iterate
		final List<Integer> integers1to9 = Stream.iterate(1, i -> i + 1).limit(9).collect(Collectors.toList());

		// iterate with forEach
		integers1to9.stream().forEach(System.out::print);
		System.out.println();
		// filter even
		integers1to9.stream().filter((i) -> i % 2 == 0).forEach(System.out::print);
		System.out.println();
		// Convert Integer to string using map
		integers1to9.stream().map(String::valueOf).forEach(s -> System.out.print(String.format("%s - ", s)));
		System.out.println();
		// Reduce
		System.out.println(integers1to9.stream().reduce(0, (i1, i2) -> i1 + i2));

		// Stream builder

		Builder<String> streamBuilder = Stream.builder();
		streamBuilder.add("a").add("b").add("c").add("...");

		Stream<String> abcStream = streamBuilder.build();
		abcStream.forEach(System.out::print);
		System.out.println();

		IntStream intStream = IntStream.range(1, 10);
		intStream.forEach(System.out::print);
		System.out.println();

		LongStream longStream = LongStream.rangeClosed(1, 10);
		longStream.forEach(System.out::print);
		System.out.println();

		DoubleStream doubleStream = new Random().doubles(3);
		doubleStream.forEach(d -> System.out.printf("%s ; ", d));
		System.out.println();

		// Parallel stream
		IntStream paralellIntStream = IntStream.range(1, 100).parallel();
		paralellIntStream.forEach((i) -> System.out.printf("%s ;", i));
	}

	public static void newDateAndTimeAPI() {
		final LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		final LocalDate localDate19900102 = LocalDate.of(1990, 1, 2);
		System.out.println(localDate19900102);

		final LocalDate localDate20000102 = LocalDate.parse("2000-01-02");
		System.out.println(localDate20000102);

		final LocalDate tomorrow = LocalDate.now().plusDays(1);
		System.out.println("tomorrow: " + tomorrow);

	}
}
