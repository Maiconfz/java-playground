package io.github.maiconfz.java_playground.collections.utils;

import java.util.Collection;
import java.util.Optional;

public class CollectionUtils {
    private CollectionUtils() {
    }

    public static <T> void addIfNotNull(T o, Collection<T> collection) {
        addIfPresent(Optional.ofNullable(o), collection);
    }

    public static <T> void addIfPresent(Optional<T> opt, Collection<T> collection) {
        opt.ifPresent((obj) -> {
            collection.add(obj);
        });
    }
}
