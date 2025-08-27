package org.sunny.SpringStarter.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.sunny.SpringStarter.models.Account;

@Controller
public class AdminController {
    
     @GetMapping("/admin")
    public String admin(Model model) {
        return "admin"; 
    }
}
