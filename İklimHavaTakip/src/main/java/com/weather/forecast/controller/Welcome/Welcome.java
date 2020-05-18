package com.weather.forecast.controller.Welcome;

import com.weather.forecast.Model.DB.Entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {

    @RequestMapping(value = "/")
    public String home() {
        return "welcome";
    }

}
