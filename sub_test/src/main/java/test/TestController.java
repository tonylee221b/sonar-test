package test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {
	private final TestService service;

	@GetMapping("/tony")
	public ResponseEntity<TestDto> getHello(
			@RequestParam String certName
	) {
		try {
			TestDto result = service.findByName(certName);
			log.info("Result = {}", result);

			return ResponseEntity.ok(result);
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return null;
	}

	@PostMapping("/tony")
	public String add(@RequestBody String name) {
		service.addName(name);

		return "ok";
	}
}
