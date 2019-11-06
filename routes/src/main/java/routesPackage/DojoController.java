package routesPackage;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("{location}")
	public String dojo(@PathVariable("location") String location){
		if(location.equals("dojo")) {
			return "The Dojo is OK!";
		}
		else if(location.equals("burbank")) {
			return "Burbank is in So-Cal";
		}
		else if(location.equals("sj")) {
			return "San Jose is boss!";
		}
		return "";
	}

}
