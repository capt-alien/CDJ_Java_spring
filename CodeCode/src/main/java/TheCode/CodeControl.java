package TheCode;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeControl {

	public CodeControl() {

	}
	@RequestMapping("/")
	public String hello() {
		return "Hello Fuckface";
	}

}
