package ru.orangemaks.restaurant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.orangemaks.restaurant.Domain.Admin.Products.*;
import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_UserInputBoundary;
import ru.orangemaks.restaurant.Domain.Admin.Users.EditUserRequestModel;
import ru.orangemaks.restaurant.Domain.Admin.Users.FilterUserRequestModel;

import javax.validation.Valid;
import java.util.HashMap;

@Controller()
@RequestMapping("/admin")
public class AdminController {
    private final Admin_UserInputBoundary admin_userInputBoundary;
    private final Admin_ProductInputBoundary admin_productInputBoundary;

    public AdminController(Admin_UserInputBoundary admin_userInputBoundary,
                           Admin_ProductInputBoundary admin_productInputBoundary) {
        this.admin_userInputBoundary = admin_userInputBoundary;
        this.admin_productInputBoundary = admin_productInputBoundary;
    }

    @GetMapping("/users")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("Admin/admin_users");
        modelAndView.addAllObjects(admin_userInputBoundary.getAll());
        return modelAndView;
    }

    @PostMapping("/users")
    public ModelAndView users(FilterUserRequestModel filterUserRequestModel,
                              Long userId,
                              String action){
        if(action.equals("filter")){
            if (filterUserRequestModel.getROLE_USER()==null)
                filterUserRequestModel.setROLE_USER("");
            if (filterUserRequestModel.getROLE_ADMIN()==null)
                filterUserRequestModel.setROLE_ADMIN("");

            ModelAndView modelAndView = new ModelAndView("Admin/admin_users");
            modelAndView.addAllObjects(admin_userInputBoundary.filterUsers(filterUserRequestModel));
            return modelAndView;
        }
        else if(action.equals("delete")){
            ModelAndView modelAndView = new ModelAndView("Admin/admin_users");
            HashMap<String,String> map = admin_userInputBoundary.deleteUser(userId);
            for (String key: map.keySet()) {
                modelAndView.addObject(key,map.get(key));
            }
            modelAndView.addAllObjects(admin_userInputBoundary.getAll());
            return modelAndView;
        }
        else{
            return new ModelAndView("redirect:/admin/users/"+userId);
        }
    }

    @GetMapping("/users/{userId}")
    public ModelAndView showConcreteUser(@PathVariable Long userId){
        ModelAndView modelAndView = new ModelAndView("Admin/concreteUser");
        modelAndView.addAllObjects(admin_userInputBoundary.findConcreteUser(userId));
        return modelAndView;
    }

    @PostMapping("/users/{userId}")
    public ModelAndView editUser(@Valid EditUserRequestModel editUserRequestModel,
                                 @PathVariable Long userId){
        if (editUserRequestModel.getROLE_USER()==null)
            editUserRequestModel.setROLE_USER("");
        if (editUserRequestModel.getROLE_ADMIN()==null)
            editUserRequestModel.setROLE_ADMIN("");

        ModelAndView modelAndView = new ModelAndView("Admin/concreteUser");
        modelAndView.addAllObjects(admin_userInputBoundary.editUser(userId,editUserRequestModel));
        return modelAndView;
    }

    @GetMapping("/products")
    public ModelAndView allProducts(){
        ModelAndView modelAndView = new ModelAndView("Admin/admin_products");
        modelAndView.addObject("categories", ProductCategories.class);
        modelAndView.addAllObjects(admin_productInputBoundary.getAll());
        return modelAndView;
    }

    @PostMapping("/products")
    public ModelAndView products(FilterProductRequestModel filterProductRequestModel,
                                 CreateProductRequestModel createProductRequestModel,
                                 Long productId,
                                 String action){
        ModelAndView modelAndView = new ModelAndView("Admin/admin_products");
        switch (action) {
            case "create":
                modelAndView.addObject(admin_productInputBoundary.createProduct(createProductRequestModel));
                modelAndView.addAllObjects(admin_productInputBoundary.getAll());
                break;
            case "filter":
                if(filterProductRequestModel.getCategoryFilter().equals("none")) filterProductRequestModel.setCategoryFilter("");
                modelAndView.addAllObjects(admin_productInputBoundary.filterProducts(filterProductRequestModel));
                break;
            case "delete":
                modelAndView.addObject(admin_productInputBoundary.deleteProduct(productId));
                modelAndView.addAllObjects(admin_productInputBoundary.getAll());
                break;
            case "show":
                return new ModelAndView("redirect:/admin/products/" + productId);
            default:
                break;
        }
        modelAndView.addObject("categories", ProductCategories.class);
        return modelAndView;
    }

    @GetMapping("/products/{productId}")
    public ModelAndView showConcreteProduct(@PathVariable Long productId){
        ModelAndView modelAndView = new ModelAndView("Admin/concreteProduct");
        modelAndView.addObject("categories", ProductCategories.class);
        modelAndView.addAllObjects(admin_productInputBoundary.findConcreteProduct(productId));
        return modelAndView;
    }

    @PostMapping("/products/{productId}")
    public ModelAndView editUser(@Valid EditProductRequestModel editProductRequestModel,
                                 @PathVariable Long productId){

        ModelAndView modelAndView = new ModelAndView("Admin/concreteProduct");
        modelAndView.addAllObjects(admin_productInputBoundary.editProduct(productId,editProductRequestModel));
        modelAndView.addObject("categories", ProductCategories.class);
        modelAndView.addAllObjects(admin_productInputBoundary.findConcreteProduct(productId));
        return modelAndView;
    }
}
