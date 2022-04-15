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

/**
 * Controller for response by endpoints /admin/*
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    /**
     * Admin_UserInteractor
     */
    private final Admin_UserInputBoundary admin_userInputBoundary;
    /**
     * Admin_ProductInteractor
     */
    private final Admin_ProductInputBoundary admin_productInputBoundary;

    public AdminController(Admin_UserInputBoundary admin_userInputBoundary,
                           Admin_ProductInputBoundary admin_productInputBoundary) {
        this.admin_userInputBoundary = admin_userInputBoundary;
        this.admin_productInputBoundary = admin_productInputBoundary;
    }

    /**
     * get all users
     * @return list of all user
     */
    @GetMapping("/allUsers")
    public List<UserDtoModel> allUsers(){
        return admin_userInputBoundary.getAll();
    }

    /**
     * get all users by filter
     * @param filterUserRequestModel filtering parameters
     * @return list of filtered users
     */
    @PostMapping("/filterUsers")
    public List<UserDtoModel> filter(@RequestBody FilterUserRequestModel filterUserRequestModel){
        return admin_userInputBoundary.filterUsers(filterUserRequestModel);
    }

    /**
     * delete user by id
     * @param userId  id
     * @return deleted user
     */
    @DeleteMapping("/deleteUser/{userId}")
    public UserDtoModel delete(@PathVariable Long userId){
        return admin_userInputBoundary.deleteUser(userId);
    }

    /**
     * give concrete user by id
     * @param userId id
     * @return user by id
     */
    @GetMapping("/user/{userId}")
    public UserDtoModel showConcreteUser(@PathVariable Long userId){
        return admin_userInputBoundary.findConcreteUser(userId);
    }

    /**
     * edit user by id
     * @param userId id
     * @param editUserRequestModel edit parameters
     * @return edit status
     */
    @PutMapping("/user/{userId}")
    public boolean editUser(@PathVariable Long userId,
                            @RequestBody EditUserRequestModel editUserRequestModel
                                 ){
        return admin_userInputBoundary.editUser(userId,editUserRequestModel);
    }

    /**
     * get all products
     * @return list of all products
     */
    @GetMapping("/allProducts")
    public ProductsResponseModel allProducts(){
        return admin_productInputBoundary.getAll();
    }

    /**
     * get all products by filter
     * @param filterProductRequestModel filtering parameters
     * @return list of filtered products
     */
    @PostMapping("/filterProducts")
    public ProductsResponseModel filterProduct(@RequestBody FilterProductRequestModel filterProductRequestModel){
        return admin_productInputBoundary.filterProducts(filterProductRequestModel);
    }

    /**
     * create new product
     * @param createProductRequestModel product data
     * @return create status
     */
    @PostMapping("/createProduct")
    public boolean createProduct(@RequestBody CreateProductRequestModel createProductRequestModel){
        return admin_productInputBoundary.createProduct(createProductRequestModel);
    }

    /**
     * delete product by id
     * @param productId  id
     * @return deleted product
     */
    @DeleteMapping("/deleteProduct/{productId}")
    public ProductDtoModel deleteProduct(@PathVariable Long productId){
        return admin_productInputBoundary.deleteProduct(productId);
    }

    /**
     * give concrete product by id
     * @param productId id
     * @return product by id
     */
    @GetMapping("/product/{productId}")
    public ProductDtoModel showConcreteProduct(@PathVariable Long productId){
        return admin_productInputBoundary.findConcreteProduct(productId);
    }

    /**
     * edit product by id
     * @param productId id
     * @param editProductRequestModel edit parameters
     * @return edit status
     */
    @PutMapping("/product/{productId}")
    public boolean editProduct(@RequestBody EditProductRequestModel editProductRequestModel,
                                 @PathVariable Long productId){
        return admin_productInputBoundary.editProduct(productId,editProductRequestModel);
    }
}
