package survey.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Index {

	public Index() {
		// TODO Auto-generated constructor stub
	}
	public String index() {
		return"index.jsp";
	}

}
