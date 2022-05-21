package io.github.maiconfz.java_playground.java_8_features.functional_interfaces;

@FunctionalInterface
public interface ApplySuffixFunction {
	String apply(String s, String suffix);
}
