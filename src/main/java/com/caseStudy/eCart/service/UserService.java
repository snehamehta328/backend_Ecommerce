package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private userRepository u;

    public Optional<users> CurrentUser(Principal principal) {
        String username = principal.getName();
        return u.findByUsername(username);
    }

    public Long getUserId(Principal principal) {
        String username = principal.getName();
        Long id = u.findByUsername(username).get().getUserId();
        return id;
    }

//    public Long getUserRole(Principal principal) {
//        return u.findByUsername(principal.getName()).get().getRole().getRoleId();
//    }
//
//    public ResponseEntity<?> checkDetails(users user, Principal principal) {
//        Optional<users> usercheck = u.findByUsername(principal.getName());
//        Optional<users> usercheckinfo = u.findByUsername(user.getUsername());
//        if (usercheckinfo.isPresent() & usercheckinfo.get().getUsername() != usercheck.get().getUsername()) ;
//        HttpHeaders responseHeaders = new HttpHeaders();
//    }
public Optional<users> getUserProfile(Principal principal)
{
    return u.findByUsername(principal.getName());
}
}
