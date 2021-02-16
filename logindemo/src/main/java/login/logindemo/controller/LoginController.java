package login.logindemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home(ModelAndView modelAndView) {
        return "home";
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/adminOnly")
    public String adminOnly() {
        return "Secret Page";
    }

    @RequestMapping("/login")
    public String loginForm() {
        return "login-form";
    }
}
