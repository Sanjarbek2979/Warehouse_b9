package uz.pdp.warehouse_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sanjarbek Allayev, сб 8:52. 19.02.2022
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("password"));
        return "index";
    }
    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    public String dashboard(HttpServletRequest request){
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("password"));
        return "dashboard";
    }
    @RequestMapping(value = "/catalog",method = RequestMethod.GET)
    public String catalog(){
        return "catalog";
    }

}
