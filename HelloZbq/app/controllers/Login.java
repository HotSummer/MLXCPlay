package controllers;

import play.mvc.Result;
import play.mvc.Controller;

public class Login extends Controller {
	public static Result login() {
		session("connnected", "user@gmail.com");
		return ok("Welcome");
	}
	
	public static Result logout() {
		session().remove("connnected");
		return ok("Bye");
	}
	
	public static Result showName() {
		String user = session("connnected");
		if(user != null){
			return ok("Hello" + user);
		}else{
			return unauthorized("Oops, you are not connected");
		}
	}
}
