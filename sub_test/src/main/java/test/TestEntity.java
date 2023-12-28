package test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class TestEntity {
	@Id
			@GeneratedValue
	Long id;

	String name;

	public TestEntity(String name) {
		this.name = name;
	}
}
