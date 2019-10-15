package test.novo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.client.MongoDatabase;

import test.novo.model.SIGNUP;

import test.novo.database.database;

@Controller
public class controllers {
	@Autowired
	database DB;
	@RequestMapping(value="/signup",method = RequestMethod.GET)
	public String SignUp(Model model)
    {
  	  model.addAttribute("signup",new SIGNUP());
  	  return "signup";
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String Login(Model model)
    {
  	  model.addAttribute("signup",new SIGNUP());
  	  return "login";
	}
	@RequestMapping("/home")
	public String HomePage()
    {
  	  return "homepage";
	}
	@RequestMapping(value="/profile",method = RequestMethod.POST)

	 public String process(@ModelAttribute("signup") SIGNUP sign) {
	     int id=DB.getUniqueId();
	     sign.setEmpId(id);
	     System.out.println(id);
   	     DB.signup(sign);
   	     return "userProfile";
     }
}
