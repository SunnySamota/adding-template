package org.sunny.SpringStarter.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.sunny.SpringStarter.models.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.sunny.SpringStarter.Services.AccountServices;

@Controller
public class AccountController {

    @Autowired
    private AccountServices accountService;

    // ✅ Show registration page
    @GetMapping("/register")
    public String register(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "register";
    }

    // ✅ Handle form submission
    @PostMapping("/register")
    public String register_user(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/"; // after save, go back to homepage
    }

    @GetMapping("/login")
    public String login(Model model) {
        Account account = new Account();

        return "account_views/login";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        return "account_views/profile";
    }
    @GetMapping("/test")
    public String test(Model model) {
        return "test";
    }
}