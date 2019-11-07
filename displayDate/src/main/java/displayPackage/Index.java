package displayPackage;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Index {
	
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	
//	DATE
	@RequestMapping("/date")
	public String displayDate(Model model) {
		model.addAttribute("now", new Date());
		return "displaydate.jsp";
	}
//	TIME
	@RequestMapping("/time")
	public String displaytime(Model model) {
		model.addAttribute("now", new Date());
		return "displaytime.jsp";
	}
}
