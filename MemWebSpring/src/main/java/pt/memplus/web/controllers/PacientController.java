package pt.memplus.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pt.memplus.web.models.Pacient;
import pt.memplus.web.models.entities.monica.Paciente;

@Controller
@RequestMapping(value = "/Pacient")
public class PacientController {
	private static final Logger logger = LoggerFactory.getLogger(PacientController.class);
	private Pacient pacient;

	public PacientController() {
		pacient = new Pacient();
		pacient.setId(1234);
		pacient.setDateOfBirth(getDate("1977-05-27"));
		pacient.setFirstName("Nuno");
		pacient.setGender("Masculino");
		pacient.setLastName("Cancelo");
		pacient.setMaritalStatus("Casado");
		pacient.setProfession("Informático");
		pacient.setMiddleName("Alexandre");
		pacient.getAddress().setCity("Lisboa");
		pacient.getAddress().setCountry("Portugal");
		pacient.getAddress().setRegion("Lisboa");
	}
	private Date getDate(String dateAsString) {
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		try {
			return ft.parse(dateAsString);
			
		} catch (ParseException e) {
		}
		return null;
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index() {
		//TODO Devolver lista de Pacientes 
		return new ModelAndView("pacient-home");
	}
	
	/*
	 * CREATE NEW PACIENT
	 */
	@RequestMapping(value = "/Create", method = RequestMethod.GET)
	public ModelAndView newRecord() {
		return new ModelAndView("pacient-new", "pacientModel",new Pacient());
	}
	
	@RequestMapping(value = "/Create", method = RequestMethod.POST)
	public String  newRecord( @ModelAttribute("pacientModel") @Valid Pacient pacientModel,BindingResult result) {
		//TODO Handle the View and Model
		logger.debug("Existem Erros:" +result.hasErrors());
		
		
		pacientModel.setId(-1);
		if (!result.hasErrors()) {
			//Add To Repository
			
//			if (_repo.create(pacientModel))
//				return "pacient-detail";
//			else {
//				result.rejectValue("id", "CustomMessage", "Ocorreu um erro");
//			}
			return "pacient-detail";
		}
		System.out.println("Erro");
		return "pacient-new";

	}
	/*
	 * READ A PACIENT
	 */
	@RequestMapping(value = "/Detail", method = RequestMethod.GET)
	public ModelAndView viewRecord(int id) {
		//TODO Handle the View and Model
		return new ModelAndView("pacient-detail","pacientModel",pacient);
	}
	/*
	 * UPDATE A PACIENT
	 */
	@RequestMapping(value = "/Update", method = RequestMethod.GET)
	public ModelAndView editRecord(int id) {
		//TODO Handle the View and Model

		return new ModelAndView("pacient-edit","pacientModel",pacient);
	}
	@RequestMapping(value = "/Update", method = RequestMethod.POST)
	public String  editRecord(Locale locale, Model model) {
		//TODO Handle the View and Model
		return "pacient-edit";
	}
	/*
	 * DELETE A PACIENT
	 */
	@RequestMapping(value = "/Delete", method = RequestMethod.GET)
	public ModelAndView deleteRecord(int id) {
		//TODO Handle the View and Model
		return new ModelAndView("pacient-delete","pacientModel",pacient);
	}
	@RequestMapping(value = "/Delete", method = RequestMethod.POST)
	public String  deleteRecord(Locale locale, Model model) {
		//TODO Handle the View and Model
		return "pacient-delete";
	}	
	
}
