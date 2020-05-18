package com.weather.forecast.controller.UserController;

import com.weather.forecast.Model.DB.Facade.Facade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/Login")
@Controller
public class UserController {

    Long current_userid;

    @RequestMapping("/MyProfile")
    public String profile () {
        return "Users/UserProfile";
    }

    @RequestMapping("/UpdateInform")
    public String ProfileInformUpdate() {
        return "Users/UpdateProfile";
    }

    @RequestMapping("/PublishData")
    public String publishedData () {
        return "Users/PublishedData";
    }

    @RequestMapping("/Data")
    public String Data () {
        return "Users/Data";
    }

    @RequestMapping("/SingUpUser")
    public String singUpUser (Model m) {
        Facade facade = new Facade();
        m.addAttribute("SingUp",facade);
        return "Users/SingUp";
    }

    @RequestMapping("/UpdateProfile")
    public String updateProfileInform (Model m) {
        Facade facade = new Facade();
        m.addAttribute("updateInform",facade);
        return "Users/UpdateProfile";
    }

    @RequestMapping("/DataPublish")
    public String publishUserData (Model m) {
        Facade facade = new Facade();
        m.addAttribute("publishData",facade);
        return "Users/PublishedData";
    }

    @RequestMapping("/LoginUser")
    public String loginUser (Model m) {
       Facade facade = new Facade();
       m.addAttribute("Login",facade);
        return "Users/Singin";
    }

    @RequestMapping("/PublishUserData")
    public String Publish(@ModelAttribute("publishData")Facade facade) {
        boolean isHasRecord;
        isHasRecord = facade.getUserPublishedDao().getUseridFromPublished(current_userid);
        if (isHasRecord && facade.UpdatePublish(current_userid)) {
            return "Users/UserProfile";
        } else if (isHasRecord == false && facade.CreatePublish(current_userid)) {
            return "Users/UserProfile";
        } else {
            return "Error";
        }
    }

    @RequestMapping("/UserLogin")
    public String singIn(@ModelAttribute("Login")Facade facade) {
        current_userid = facade.getUsersDao().getUser_id(facade.getId());
        if (facade.signIn()) {
            return "Users/UserProfile";
        } else {
            return "Error";
        }
    }

    @RequestMapping("/UserRecord")
    public String singUp(@ModelAttribute("SingUp")Facade facade) {
        if (facade.signUp()) {
            current_userid = facade.getUsersDao().getUser_id(facade.getId());
            return "Users/UserProfile";
        } else {
            return "Error";
        }
    }

    @RequestMapping("/Update")
    public String update (@ModelAttribute("updateInform")Facade facade) {
        facade.updateProfile(current_userid);
        return "Users/UserProfile";
    }
}
