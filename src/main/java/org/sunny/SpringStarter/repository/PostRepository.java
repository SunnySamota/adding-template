package org.sunny.SpringStarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sunny.SpringStarter.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    
}
