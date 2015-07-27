package com.jabong.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;  

import com.jabong.controllers.AppController;
import com.jabong.models.dao.UserDAO;
import com.jabong.models.User;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/user")
public class UserController extends AppController{
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/home")
	public @ResponseBody
	List<User> home() {
	//String home() {
		
		List<User> listUsers = userDao.list();
		
		return listUsers;
		//ModelAndView model = new ModelAndView("home");
		//model.addObject("userList", listUsers);
		//return model;
	}
	
	@RequestMapping(value="/name")
	public @ResponseBody
	List<User> name() {
	//String home() {
		
		List<User> listUsers = userDao.list();
		
		return listUsers;
		//ModelAndView model = new ModelAndView("home");
		//model.addObject("userList", listUsers);
		//return model;
	}
	
}
