package com.student.libraryapplication;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.student.libraryapplication.dao.Books;
import com.student.libraryapplication.dao.StudentLibrary;
import com.student.libraryapplication.dao.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "login";
		}
	
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/*@RequestMapping(value="login", method = RequestMethod.POST)
	public String userCheck(ModelMap model, HttpServletRequest request) {
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		System.out.println(name +":"+pwd);
		return "login";
	}
	*/
	@RequestMapping(value="/login", method = RequestMethod.POST)	
	public String DataDisplay(ModelMap model, User user, HttpSession session, HttpServletRequest request){
    	
		String userName = user.getUserName().trim();
		String userPwd = user.getPassword().trim();		
		
		try {
			System.out.println(userName);			
			
			if(userName.equalsIgnoreCase("") || userPwd.equalsIgnoreCase("")){
				model.addAttribute("LoginFailed","User Name and Password cannot be blank.");
				return "login";			
			}
			
			StudentLibrary sl = new StudentLibrary();
			int std = sl.getStdLogin(userName, userPwd);
			
			ArrayList<Books> listBooks = sl.getBooksCheckedOut(std);
			if (listBooks != null && listBooks.size() > 0) {
				System.out.println(listBooks.size());
				model.addAttribute("booksList", listBooks);
			} else {
				System.out.println("null values");
			}

			// model.addAttribute("serverTime", listBooks.get(0).getBookId()
			// +":"+listBooks.get(0).getDueDate()+":"+listBooks.get(0).getBookName()+":"+listBooks.get(0).getPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "StudentDetails";
		
	}

	
	
	@RequestMapping(value = "getBookInfo", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		try {
			
			StudentLibrary sl = new StudentLibrary();
			int std = sl.getStdLogin("sravan", "sravan123");
			
			ArrayList<Books> listBooks = sl.getBooksCheckedOut(std);
			if (listBooks != null && listBooks.size() > 0) {
				System.out.println(listBooks.size());
				model.addAttribute("booksList", listBooks);
			} else {
				System.out.println("null values");
			}

			// model.addAttribute("serverTime", listBooks.get(0).getBookId()
			// +":"+listBooks.get(0).getDueDate()+":"+listBooks.get(0).getBookName()+":"+listBooks.get(0).getPrice());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "StudentDetails";

	}
}
