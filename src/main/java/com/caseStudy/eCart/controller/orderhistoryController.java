package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.orderHistory;
import com.caseStudy.eCart.repository.orderHistoryRepository;
import com.caseStudy.eCart.service.UserService;
import com.caseStudy.eCart.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.DELETE, RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/order")
public class orderhistoryController {
    @Autowired
    orderHistoryRepository orderhistory;
    @Autowired
    private cartService cartService;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    @ResponseBody
    public List<orderHistory> showHistory(Principal principal)
    {
        return cartService.showorderhistory(userService.getUserId(principal),principal);
    }

}
