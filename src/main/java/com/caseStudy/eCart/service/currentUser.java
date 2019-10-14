package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class currentUser {
    @Autowired
    userRepository userRepository;
    public users getProfile(Principal principal){
        Optional<users>myp=userRepository.findByUsername(principal.getName());
        return myp.get();
    }
}
