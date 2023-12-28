package test;

public class TestMapper {
	private TestMapper() {}

	public static TestDto toDto(TestEntity entity) {
		return new TestDto(entity.getName());
	}

	public static TestEntity toEntity(TestDto dto) {
		return new TestEntity(dto.getName());
	}
}
