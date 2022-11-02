package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/users")
    public String printUsers(Model model){
        List<User> userList  = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @RequestMapping(value = "/new")
    public String addNewUser(Model model){
        User user = new User();
        model.addAttribute("newUser", user);
        return "new-user";
    }

    @RequestMapping(value = "/saveNewUser")
    public String saveNewUser(@ModelAttribute("newUser") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit-user/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("editUser", user);
        return "edit-user";
    }

    @PostMapping(value = "/update-user")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }

}
