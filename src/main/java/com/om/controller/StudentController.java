package com.om.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.model.Farmer;
import com.om.service.FarmerService;
import com.om.service.FarmerServiceInterface;

import net.sf.jasperreports.engine.JRException;
import util.PrintJasperReport;

@Controller
public class StudentController {

	@Autowired
	private FarmerServiceInterface farmerServiceInterface;

	@RequestMapping(value = "HomePage")
	public String openHomePage() {
		System.out.println("opening home page");
		return "home";

	}

	@RequestMapping(value = "Login")
	public String openLoginPage() {
		System.out.println("opening home page");
		return "login";

	}

	// checkLogin
	
	@RequestMapping(value="checkLogin")
	public ModelAndView checkLogin(HttpServletRequest req,Model model) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username.equals("Vishal") && password.equals("Vishal123")) {
			System.out.println("Login Success");
			return new ModelAndView("home");
		} else {
			model.addAttribute("errorMsg", "Incorrect Username or Password");
			return new ModelAndView("login");
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "addFarmer")
	public ModelAndView addFarmer(HttpServletRequest req, HttpServletResponse res) {
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		Farmer f1 = new Farmer();
		f1.setName(name);
		f1.setAddress(address);
		f1.setPhone(phone);
		System.out.println(f1);
		farmerServiceInterface.addFarmerinService(f1);
		farmerServiceInterface.addFarmer(f1);

		return new ModelAndView("home");

	}

	@RequestMapping(value = "aboutPage")
	public ModelAndView showData() {

		List<Farmer> list = farmerServiceInterface.getFarmer();
		System.out.println(list);
		ModelAndView model = new ModelAndView();
		model.addObject("list", list);
		model.setViewName("about");
		return model;

	}

	@RequestMapping(value = "updateFarmer")
	
	public ModelAndView openUpdateStudentPage(HttpServletRequest req) {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Farmer obj = farmerServiceInterface.getFarmerById(id);
		ModelAndView model = new ModelAndView("updateFarmerPage");
		model.addObject("Farmer", obj);
		
		return model;
	}

	@RequestMapping(value = "updateFarmer", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute Farmer f) {
		farmerServiceInterface.updateFarmer(f);
		List<Farmer> list = farmerServiceInterface.getFarmer();
		System.out.println(list);
		ModelAndView model = new ModelAndView();
		model.addObject("list", list);
		model.setViewName("about");
		return model;
	}
	@RequestMapping(value="AllStudentReport")
	public String AllStudentReport(HttpServletRequest request, HttpSession httpSession,
			HttpServletResponse response) throws JRException, NamingException, SQLException, IOException
	{
		System.out.println("opening AllStudentReport");
		
		String filename = "report2";
		HashMap<String, Object> hm = new HashMap<String, Object>();
		PrintJasperReport.printreport(filename, request, response, hm);
		
		return "home";
	}

}
