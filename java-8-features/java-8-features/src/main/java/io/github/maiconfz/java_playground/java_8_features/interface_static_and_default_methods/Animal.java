package io.github.maiconfz.java_playground.java_8_features.interface_static_and_default_methods;

public interface Animal {

	default String getType() {
		logDefaultMethodCall("getType");
		return Animal.class.getSimpleName();
	}

	static void logDefaultMethodCall(String methodName) {
		System.out.println(String.format("Method called: %s", methodName));
	}
}
