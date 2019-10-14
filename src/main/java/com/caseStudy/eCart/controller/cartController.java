package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.repository.cartRepository;
import com.caseStudy.eCart.service.UserService;
import com.caseStudy.eCart.service.cartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class cartController {

    private cartRepository cartRepository;
@Autowired
    private cartService cartService;
  @Autowired
    private UserService userService;

    //  private CurrentUserService currentUserService;
    @Autowired
    public cartController(cartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }
    @RequestMapping(value = "/removeproduct/recieve/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<cart> removeproduct(@PathVariable Long product_id, Principal principal) {
        return cartService.removeproduct(userService.getUserId(principal), product_id);
    }

    @RequestMapping(value = "/deleteproduct/recieve/{product_id}" ,method = RequestMethod.GET)
    @ResponseBody
    public Optional<cart> deleteproduct(@PathVariable Long product_id, Principal principal)
    {
        return cartService.deleteproduct(userService.getUserId(principal), product_id);
    }
    @RequestMapping(value = "/addproduct/recieve/{product_id}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/checkout/recieve", method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal){
        return cartService.checkout(userService.getUserId(principal),principal);
    }
}
//}

