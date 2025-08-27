package org.sunny.SpringStarter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sunny.SpringStarter.models.Authority;




@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
 Optional<Authority> findByName(String name);
}
