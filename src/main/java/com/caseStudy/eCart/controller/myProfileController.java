package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.userRepository;
import com.caseStudy.eCart.service.currentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profile")
public class myProfileController
{
    @Autowired
   private currentUser currentUser;
    @Autowired
    private userRepository userRepository;
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public users getData(Principal principal)
    {
        return currentUser.getProfile(principal);
    }
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public users update(@Valid @RequestBody users users){
        users.setActive(1);
        userRepository.save(users);
        return users;
    }
}
