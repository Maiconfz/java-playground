package io.github.maiconfz.java_playground.collections.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CollectionUtilsTests {

    @Test
    void addIfNotNull_AddingNull_ShouldNotAddToCollection() {
        var emptyList = new ArrayList<String>();
        CollectionUtils.addIfNotNull(null, emptyList);
        assertTrue(emptyList.isEmpty(), "Collection should be empty after adding null value");
    }

    @Test
    void addIfNotNull_AddingNotNull_ShouldAddObjectToCollection() {
        var list = new ArrayList<String>();
        var stringToAdd = "Maiconfz";
        CollectionUtils.addIfNotNull(stringToAdd, list);
        assertTrue(list.contains(stringToAdd), "Should have added the object to the collection");
    }
}
