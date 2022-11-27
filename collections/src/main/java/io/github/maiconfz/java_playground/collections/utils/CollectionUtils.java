package io.github.maiconfz.java_playground.collections.utils;

import java.util.Collection;
import java.util.Objects;

public class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> void addIfNotNull(T o, Collection<T> collection) {
        if (Objects.nonNull(o)) {
            collection.add(o);
        }
    }
}
