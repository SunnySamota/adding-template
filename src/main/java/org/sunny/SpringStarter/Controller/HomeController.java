package org.sunny.SpringStarter.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.sunny.SpringStarter.Services.PostService;
import org.sunny.SpringStarter.models.Post;


@Controller
public class HomeController {

@Autowired
private PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home_views/home"; 
}
  
//   @GetMapping("/about")
//     public String about(Model model) {
//         model.addAttribute("message", "Welcome Sunny!");
//         return "about"; 
// }
//   @GetMapping("/book")
//     public String book(Model model) {
//         model.addAttribute("message", "Welcome Sunny!");
//         return "book"; 
// }
}
