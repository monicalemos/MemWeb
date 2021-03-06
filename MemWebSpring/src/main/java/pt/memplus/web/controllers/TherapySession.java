package pt.memplus.web.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/Therapeutic")
public class TherapySession {
	private static final Logger logger = LoggerFactory.getLogger(TherapySession.class);
	public TherapySession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		//TODO Handle the View and Model 
		return new ModelAndView("therapeutic-home");
	}
	
	/*
	 * CREATE NEW Therapeutic
	 */
	@RequestMapping(value = "/Create", method = RequestMethod.GET)
	public ModelAndView newRecord() {
		//TODO Handle the View and Model
		return new ModelAndView("therapeutic-home");
	}
	@RequestMapping(value = "/Create", method = RequestMethod.POST)
	public String  newRecord(Locale locale, Model model) {
		//TODO Handle the View and Model
		return "therapeutic-home";
	}
	/*
	 * READ A Therapeutic
	 */
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public ModelAndView viewRecord(int id) {
		//TODO Handle the View and Model
		return new ModelAndView("therapeutic-home");
	}
	/*
	 * UPDATE A Therapeutic
	 */
	@RequestMapping(value = "/Update", method = RequestMethod.GET)
	public ModelAndView editRecord(int id) {
		//TODO Handle the View and Model
		return new ModelAndView("therapeutic-home");
	}
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public String  editRecord(Locale locale, Model model) {
		//TODO Handle the View and Model
		return "therapeutic-home";
	}
	/*
	 * DELETE A Therapeutic
	 */
	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteRecord(int id) {
		//TODO Handle the View and Model
		return new ModelAndView("therapeutic-home");
	}
	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public String  deleteRecord(Locale locale, Model model) {
		//TODO Handle the View and Model
		return "therapeutic-home";
	}	
}
