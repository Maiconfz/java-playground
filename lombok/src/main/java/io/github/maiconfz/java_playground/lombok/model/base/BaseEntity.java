package io.github.maiconfz.java_playground.lombok.model.base;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 10445945306545478L;

	@ToString.Include
	@EqualsAndHashCode.Include
	private UUID id;

	@ToString.Include
	private LocalDateTime creationDate;

	@ToString.Include
	private LocalDateTime lastUpdateDate;

}
