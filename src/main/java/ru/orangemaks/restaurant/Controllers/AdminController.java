package ru.orangemaks.restaurant.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.orangemaks.restaurant.Domain.Admin.Users.Admin_UserInputBoundary;
import ru.orangemaks.restaurant.Domain.Admin.Users.EditUserRequestModel;
import ru.orangemaks.restaurant.Domain.Admin.Users.FilterRequestModel;

import javax.validation.Valid;
import java.util.HashMap;

@Controller()
@RequestMapping("/admin")
public class AdminController {
    private final Admin_UserInputBoundary admin_userInputBoundary;

    public AdminController(Admin_UserInputBoundary admin_userInputBoundary) {
        this.admin_userInputBoundary = admin_userInputBoundary;
    }

    @GetMapping("/users")
    public ModelAndView allUsers(){
        ModelAndView modelAndView = new ModelAndView("Admin/admin_users");
        modelAndView.addAllObjects(admin_userInputBoundary.getAll());
        return modelAndView;
    }

    @PostMapping("/users")
    public ModelAndView users(FilterRequestModel filterRequestModel,
                              Long userId,
                              String action){
        if(action.equals("filter")){
            if (filterRequestModel.getROLE_USER()==null)
                filterRequestModel.setROLE_USER("");
            if (filterRequestModel.getROLE_ADMIN()==null)
                filterRequestModel.setROLE_ADMIN("");

            ModelAndView modelAndView = new ModelAndView("Admin/admin_users");
            modelAndView.addAllObjects(admin_userInputBoundary.filterUsers(filterRequestModel));
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
}
