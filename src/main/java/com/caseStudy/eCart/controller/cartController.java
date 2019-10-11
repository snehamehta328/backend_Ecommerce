package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.repository.cartRepository;
//import com.caseStudy.eCart.service.CurrentUserService;
import com.caseStudy.eCart.service.UserService;
import com.caseStudy.eCart.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/cart")
public class cartController {

    private cartRepository cartRepository;

    private cartService cartService;
    private UserService userService;

    //  private CurrentUserService currentUserService;
    @Autowired
    public cartController(cartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;

    }



    @RequestMapping(value = "/removeproduct/recieve/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public cart removeproduct(@PathVariable Long product_id, Principal principal) {
        return cartService.removeproduct(userService.getUserId(principal), product_id);
    }

    @RequestMapping(value = "/addproduct/recieve/{product_id}", method = RequestMethod.POST)
    @ResponseBody
    public cart addproduct(@PathVariable Long product_id, Principal principal) {
        return cartService.addProduct(userService.getUserId(principal), product_id);
    }

    @RequestMapping(value = "/showcart/recieve", method = RequestMethod.GET)
    @ResponseBody
    public List<cart> showcart(Principal principal) {
        return cartService.showCart(userService.getUserId(principal),principal);
    }
    @RequestMapping(value="/clearcart", method = RequestMethod.GET)
    @ResponseBody
    public  String clearCart(Principal principal)
    {
        return cartService.clearCart(userService.getUserId(principal),principal);
    }
}
//}

