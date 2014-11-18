package pt.memplus.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Account")
public class AccountController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return  new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("Estou a  entrar na pagina");
		return new ModelAndView("Account-login");
	}	
	
	
	@RequestMapping(value = "/Logout", method = RequestMethod.GET)
	public ModelAndView logout(){
		//TODO: Do Something to Remove Cookies, Authentication, etc...
		System.out.println("Estou a  entrar na pagina");
		return new ModelAndView("Account-logout");
	}
}
