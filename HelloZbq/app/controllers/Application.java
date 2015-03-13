package controllers;

import play.*;
import play.mvc.*;

import views.html.*;
import org.mindrot.jbcrypt.BCrypt;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    /*
     * 明文密码进行哈希(Hash)转换
     */
    public static Result bcrypt() {
        String passwordHash = BCrypt.hashpw("Hello",BCrypt.gensalt());
        boolean correct = BCrypt.checkpw("Hello", passwordHash);
        boolean wrong = BCrypt.checkpw("World", passwordHash);
        return ok(passwordHash + " " + correct + " " + wrong);
    }
}
