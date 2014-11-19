package pt.memplus.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Games")
public class GamesController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return  new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/Jigsaw", method = RequestMethod.GET)
	public ModelAndView login() {
		System.out.println("Estou a  entrar na pagina");
		return new ModelAndView("Games-jigsaw");
	}
	
}
