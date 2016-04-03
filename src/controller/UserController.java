package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.User;
import service.RateService;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService us;
	
	@Autowired
	RateService rs;
	
	@RequestMapping(value="/index")
	public String firstLogonPage(){
		return "index";
	}
	
	@RequestMapping(value="/logonCheck")
	public String logonCheck(HttpServletRequest request,String username,String password,Model model){
		boolean isValid=us.isValidUser(username, password);
		if(isValid){
			User user=us.getUserDetail(username);
			request.getSession().setAttribute("user", user);
			//TODO show admin summary view
			if(username.equals("admin")){
				return "show";
			}else{
				//TODO show normal user rating view
				return "show";
			}
		}
		else{
			model.addAttribute("error","invalid username or password");
			return "error";
		}
	}
	
	@RequestMapping(value="/submitRating")
	public String submitRating(HttpServletRequest request){
		//TODO receive the rating data
		return "index";
	}
	
	@RequestMapping(value="/error")
	public String getErrorPage(){
		return "error";
	}
}
