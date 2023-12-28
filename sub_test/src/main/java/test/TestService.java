package test;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {
	private final TestRepository repository;

	public TestDto findByName(String name) throws Exception {
		log.info("name : {}", name);
		Optional<TestEntity> result = repository.findByName(name);


		if (result.isEmpty()) {
			throw new Exception("No Data found");
		}

		log.info("Result : {}", result.get());

		return TestMapper.toDto(result.get());
	}

	public void addName(String name) {
		repository.save(new TestEntity(name));
		TestEntity saved = repository.getReferenceById(1L);
		log.info("Saved : {}", saved.name);
	}
}
