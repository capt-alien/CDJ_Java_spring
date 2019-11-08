package survey.controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class Index {

	public Index() {
	}
//	GET INDEX
	@RequestMapping("")
	public String index() {
		return"index.jsp";
	}
	
//	POST
	@RequestMapping(path="", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value="name", defaultValue="")String name,
											  @RequestParam(value="dojo") String dojo,
											  @RequestParam(value="lang") String lang, 
											  @RequestParam(value="comment", required=false) String comment) {
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("lang", lang);
		session.setAttribute("comment", "null");
		if(comment != "null") {
			session.setAttribute("comment", comment);
		}

//		END
		return "redirect:/result";
	}
	
//	RESULT
	@RequestMapping("/result")
	public String result() {
		return "results.jsp";
	}

}
