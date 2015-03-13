package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class RequestGet extends Controller {
	public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
	public static Result show(String para) {
		response().setContentType("text/html");
		return ok("<h1>Hello Summer!</h1>");
	}
}
