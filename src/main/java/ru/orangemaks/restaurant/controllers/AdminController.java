package ru.orangemaks.restaurant.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import ru.orangemaks.restaurant.domain.admin.products.*;
import ru.orangemaks.restaurant.domain.admin.users.Admin_UserInputBoundary;
import ru.orangemaks.restaurant.domain.admin.users.EditUserRequestModel;
import ru.orangemaks.restaurant.domain.admin.users.FilterUserRequestModel;
import ru.orangemaks.restaurant.models.ProductDtoModel;
import ru.orangemaks.restaurant.models.UserDtoModel;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final Admin_UserInputBoundary admin_userInputBoundary;
    private final Admin_ProductInputBoundary admin_productInputBoundary;

    public AdminController(Admin_UserInputBoundary admin_userInputBoundary,
                           Admin_ProductInputBoundary admin_productInputBoundary) {
        this.admin_userInputBoundary = admin_userInputBoundary;
        this.admin_productInputBoundary = admin_productInputBoundary;
    }

    @GetMapping("/allUsers")
    public List<UserDtoModel> allUsers(){
        return admin_userInputBoundary.getAll();
    }

    @PostMapping("/filterUsers")
    public List<UserDtoModel> filter(@RequestBody FilterUserRequestModel filterUserRequestModel){
        return admin_userInputBoundary.filterUsers(filterUserRequestModel);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public UserDtoModel delete(@PathVariable Long userId){
        return admin_userInputBoundary.deleteUser(userId);
    }


    @GetMapping("/user/{userId}")
    public UserDtoModel showConcreteUser(@PathVariable Long userId){
        return admin_userInputBoundary.findConcreteUser(userId);
    }

    @PutMapping("/user/{userId}")
    public boolean editUser(@PathVariable Long userId,
                            @RequestBody EditUserRequestModel editUserRequestModel
                                 ){
        return admin_userInputBoundary.editUser(userId,editUserRequestModel);
    }

    @GetMapping("/allProducts")
    public ProductsResponseModel allProducts(){
        return admin_productInputBoundary.getAll();
    }

    @PostMapping("/filterProducts")
    public ProductsResponseModel filterProduct(@RequestBody FilterProductRequestModel filterProductRequestModel){
        return admin_productInputBoundary.filterProducts(filterProductRequestModel);
    }

    @PostMapping("/createProduct")
    public boolean createProduct(@RequestBody CreateProductRequestModel createProductRequestModel){
        return admin_productInputBoundary.createProduct(createProductRequestModel);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ProductDtoModel deleteProduct(@PathVariable Long productId){
        return admin_productInputBoundary.deleteProduct(productId);
    }

    @GetMapping("/product/{productId}")
    public ProductDtoModel showConcreteProduct(@PathVariable Long productId){
        return admin_productInputBoundary.findConcreteProduct(productId);
    }

    @PutMapping("/product/{productId}")
    public boolean editProduct(@RequestBody EditProductRequestModel editProductRequestModel,
                                 @PathVariable Long productId){
        return admin_productInputBoundary.editProduct(productId,editProductRequestModel);
    }
}
