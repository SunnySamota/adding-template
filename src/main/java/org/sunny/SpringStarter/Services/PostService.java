package org.sunny.SpringStarter.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunny.SpringStarter.models.Post;
import org.sunny.SpringStarter.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Long Id){
        return postRepository.findById(Id);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }
    public void delete(Post post){
       postRepository.delete(post);
    }
    public Post save(Post post){
        if(post.getId()==null){
            post.setCreatedAt(LocalDateTime.now());;
        }
        return postRepository.save(post);
    }
}
