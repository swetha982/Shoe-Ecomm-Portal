package com.example.controller;

import com.example.bean.Cart;
import com.example.bean.Product;
import com.example.bean.User;
import com.example.service.CartService;
import com.example.service.ProductService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService us;

    @Autowired
    private ProductService ps;

    @Autowired
    private CartService cs;

    @GetMapping(value = "userSignUp")
    public String signUp(){
        return "signUp";
    }
    @GetMapping(value = "welcome")
    public String land(){
        return "welcome";
    }

    @GetMapping(value = "cart")
    public String cart(){
        return "cart";
    }

    @GetMapping(value ="userLogin")
    public String login(){
        return "userLogin";
    }

    @PostMapping(value = "validateUser")
    @ResponseBody
    public String validateUser(HttpServletRequest request){
        String mail= request.getParameter("email");
        String pwd = request.getParameter("password");
        System.out.println(mail+pwd);
        if(us.checkUser(mail,pwd))
        return "welcome";
        else {
            request.setAttribute("msg","Login Failed. Please try again");
            return "userLogin";
        }

    }
    @GetMapping(value = "show")
    public String showProducts(ModelMap model){
        List<Product> pList = ps.showProducts();
        System.out.println(pList);
    model.addAttribute("products",pList);
    return "showProduct";
    }

    @PostMapping(value = "registerUser")
    @ResponseBody
    public String storeUser(HttpServletRequest request){
       String name = request.getParameter("name");
       int age = Integer.parseInt(request.getParameter("age"));
       String gender = request.getParameter("gender");
       String email = request.getParameter("email");
       String pwd = request.getParameter("password");

       System.out.println("Name:"+name+"Age:"+age+"Gender:"+gender+"Email:"+email+"Password:"+pwd);
       User u= new User(name,age,gender,email,pwd);
       String output= us.saveSignUpInfo(u);
       return output;

    }

    @GetMapping(value = "/addtocart")

    public String addToCart(ModelMap map,@RequestParam(value="Id",required=true) int ProductId){
        System.out.println(ProductId);
        Product prod=ps.getProduct(ProductId);
        String result = cs.saveCartItem(new Cart(prod.getName(),1,prod.getPrice(),prod.getFilePath()) );
        return "cart";

    }
}
