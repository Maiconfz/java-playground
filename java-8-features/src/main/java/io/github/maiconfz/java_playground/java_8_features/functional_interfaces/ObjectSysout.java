package io.github.maiconfz.java_playground.java_8_features.functional_interfaces;

import java.util.function.Consumer;

public class ObjectSysout implements Consumer<Object> {

	@Override
	public void accept(Object o) {
		System.out.println(String.valueOf(o));
	}

}
