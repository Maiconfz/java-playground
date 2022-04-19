package io.github.maiconfz.java_playground.lombok.model.base;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BaseEntityTest {

	@Test
	void testHashCodeSameAsOtherWithSameId() {
		final UUID uuid = UUID.randomUUID();
		final BaseEntity o1 = new BaseEntity(uuid, null, null);
		final BaseEntity o2 = new BaseEntity(uuid, null, null);

		Assertions.assertEquals(o1.hashCode(), o2.hashCode());
	}

	@Test
	void testHashCodeSameAsSameObjectReference() {
		final BaseEntity o1 = new BaseEntity(UUID.randomUUID(), null, null);
		final BaseEntity o2 = o1;

		Assertions.assertEquals(o1.hashCode(), o2.hashCode());
	}

	@Test
	void testEqualsSameAsOtherWithSameId() {
		final UUID uuid = UUID.randomUUID();
		final BaseEntity o1 = new BaseEntity(uuid, null, null);
		final BaseEntity o2 = new BaseEntity(uuid, null, null);

		Assertions.assertEquals(o1, o2);
	}

	@Test
	void testEqualsSameAsSameObjectReference() {
		final BaseEntity o1 = new BaseEntity(UUID.randomUUID(), null, null);
		final BaseEntity o2 = o1;

		Assertions.assertEquals(o1, o2);
	}

}
