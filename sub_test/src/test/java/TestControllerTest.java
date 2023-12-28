import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import test.TestController;
import test.TestDto;
import test.TestService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import static org.mockito.BDDMockito.*;


@ExtendWith(MockitoExtension.class)
public class TestControllerTest {

	@InjectMocks
	private TestController controller;

	@Mock
	private TestService service;

	@Test
	@DisplayName("getHello")
	public void test() throws Exception {
		// given
		given(service.findByName(anyString())).willReturn(new TestDto("Tony"));

		// when
		ResponseEntity<TestDto> result = controller.getHello("hello");

		// then
		then(service).should().findByName(anyString());
	}
}

