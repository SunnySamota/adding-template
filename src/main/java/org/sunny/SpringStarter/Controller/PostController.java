package org.sunny.SpringStarter.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.sunny.SpringStarter.Services.PostService;
import org.sunny.SpringStarter.models.Post;


@Controller
public class PostController {

  @Autowired
  private PostService postService;

  @GetMapping("/posts/{id}")
  public String getPost(@PathVariable Long id, Model model) {
    Optional<Post> optionalPost = postService.getById(id);

    if (optionalPost.isPresent()) {
      Post post = optionalPost.get();
      model.addAttribute("post", post);
      return "post_views/post";
    } else {
      return "404";
    }
  
  }
    @GetMapping("/posts/add")
    public String addPost(Model model){
      model.addAttribute("post",new Post());
      return "post_add";
    }
    // @PostMapping("/posts/add")
    // public String savePost(@ModelAttribute Post post) {
    //     //TODO: process POST request
    //   postRepository.save(post)  
    //     return "redirect:/";
    // }
    
}
