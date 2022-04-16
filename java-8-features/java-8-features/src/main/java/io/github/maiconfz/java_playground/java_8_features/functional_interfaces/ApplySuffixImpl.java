package io.github.maiconfz.java_playground.java_8_features.functional_interfaces;

public class ApplySuffixImpl implements ApplySuffixFunction {
	@Override
	public String apply(String s, String suffix) {
		return s.concat(suffix);
	}
}
