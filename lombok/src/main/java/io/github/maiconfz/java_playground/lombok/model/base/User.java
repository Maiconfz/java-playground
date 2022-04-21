package io.github.maiconfz.java_playground.lombok.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class User extends NamedEntity {
	private static final long serialVersionUID = 4690675104269372053L;

	@ToString.Include
	private String username;

	@ToString.Include
	private String email;

	@ToString.Include
	private String password;
}
