package routesPackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")
public class CodingControler {
	
	@RequestMapping("")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String django() {
		return "Python/Django was great!!";
	}
	@RequestMapping("/java")
	public String jspring() {
		return "Java/Spring is OK";
	}
}
