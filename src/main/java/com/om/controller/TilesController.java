package com.om.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.model.Farmer;

@Controller
public class TilesController {
	/*@RequestMapping(value="HomePage")
	public String openHomePage() {
		System.out.println("opening home page");
		return "home";
	}*/
	/*@RequestMapping(value="addStudent",method=RequestMethod.POST)
	public ModelAndView getStudent(HttpServletRequest req,HttpServletResponse res)
	{
		 
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		Student st=new Student();
		st.setName(name);
		st.setAddress(address);
		System.out.println(st);
		return new ModelAndView("home");
	}
*/
/*	@RequestMapping(value="aboutPage")
	public String getAboutPage()
	{
		System.out.println("opening about page");
		return"about";
	}*/
	@RequestMapping(value="contactPage")
	public String getContactPage()
	{
		System.out.println("opening contact page");
		return"contact";
	}


	
}
