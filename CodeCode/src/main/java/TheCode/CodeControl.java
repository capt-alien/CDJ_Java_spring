package TheCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeControl {

	public CodeControl() {

	}
	
//	GET
	@RequestMapping("/")
	public String index(@ModelAttribute("errors") String errors) {
		System.out.println(errors);
		return "index.jsp";
	}
	
//	POST
	@RequestMapping(path="/guess", method=RequestMethod.POST)
	public String submit(@RequestParam(value="aGuess") String guess) {
		if(guess.equals("alien")) {
			return "redirect:/code";
		}else {
			return "redirect:/errors";
		}
	}
	
	@RequestMapping("/errors")
	public String errors(RedirectAttributes redirect) {
		redirect.addFlashAttribute("errors", "You must try harder!");
		return "redirect:/";
	}
	
	@RequestMapping("/code")
	public String theCode() {
		return "code.jsp";
	}

}
