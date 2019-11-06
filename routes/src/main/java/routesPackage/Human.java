package routesPackage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/human")
public class Human {
	
	@RequestMapping("/human")
	public String greetings(@RequestParam(value="first", required=false) String firstName) {
		System.out.println("test");
		if( firstName == null) {
			return "Greetings Human!";
		} else {
			return "Greetings " + firstName + "!";
		}
		
	}

}
