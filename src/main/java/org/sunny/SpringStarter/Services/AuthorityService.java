package org.sunny.SpringStarter.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunny.SpringStarter.models.Authority;
import org.sunny.SpringStarter.repository.AuthorityRepository;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }
    public Optional<Authority> findById(Long id){
        return authorityRepository.findById(id);
    }
}
