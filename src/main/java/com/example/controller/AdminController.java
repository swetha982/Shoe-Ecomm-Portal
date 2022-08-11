package com.example.controller;

import com.example.bean.Category;
import com.example.bean.Product;
import com.example.service.CategoryService;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private CategoryService cs;

    @Autowired
    private ProductService ps;

    private String currentDirectory = System.getProperty("user.dir");


    private static String UPLOAD_FOLDER = "C:\\Users\\schinigepall\\Desktop\\Shoe-Portal\\src\\main\\java\\com\\example\\resources\\pictures\\";



    @GetMapping(value = "/login")
    public String adminLoginPage(){
        return "Adminlogin";
    }

    @GetMapping(value = "/category")
    public String loadCategory(){return "category";}

    @GetMapping(value = "/product")
    public String loadProduct(ModelMap model){
        System.out.println("Inside Product Load");
        List<Category> categoryList= cs.showCategory();
        System.out.println("Cat size"+categoryList.size());
        model.addAttribute("catList",categoryList);
        return "product";
    }

    @PostMapping(value = "addProduct")
    public String addProduct(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        System.out.println("PWD:"+currentDirectory);
        String result = null;
        String fileName = request.getParameter("pname");
        String prodCategory = request.getParameter("cat");
        int prodQuantity = Integer.parseInt(request.getParameter("pquan"));
        int price = Integer.parseInt(request.getParameter("price"));
        System.out.println("In File name:"+fileName);
        try {
            // read and write the file to the selected location-
            byte[] bytes = file.getBytes();
           if( bytes != null){

               String fname=file.getOriginalFilename();
               String path = currentDirectory+"\\pictures\\"+fname;
               File obj = new File(path);
               if(obj.createNewFile()){
                   System.out.println("In create");
                   FileOutputStream fos = new FileOutputStream(path);
                   fos.write(bytes);
                   //Category c= cs.showCategory(prodCategory);
                   int catId = cs.showId(prodCategory);
                   System.out.println("CategoryId:"+catId);
                   Product p= new Product(fileName,prodQuantity,path,price);
                   request.setAttribute("msg",ps.saveProduct(p,catId,prodCategory));
               }



           }else{
               System.out.println("Len is 0");
               request.setAttribute("msg","Len is 0");;
           }

        } catch (Exception e) {
            e.printStackTrace();
        }

      return "product";
    }

    @PostMapping(value = "addCategory")
    public String addCategory(HttpServletRequest request){
        String category = request.getParameter("cname");
        System.out.println("Category name:"+category);
        request.setAttribute("msg",cs.saveCategory(category));

       return "category";
    }

    @PostMapping(value = "/validateAdmin")
    public String validateAdmin(HttpServletRequest request){

        String user = request.getParameter("email");
        String pwd = request.getParameter("password");
        System.out.println("Email:"+user+" Password: "+pwd);
        if(user.equalsIgnoreCase("abc@gmail.com")
            && pwd.equals("123")){
            System.out.println("success");
            return "adminHome";
        }else{
            System.out.println("fail");
            request.setAttribute("msg","Failed to Login, Try Again");
            return "Adminlogin";
        }
    }
}
