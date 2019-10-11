package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.fixedCart;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
@Service


public class cartService {
    @Autowired
    private productRepository productRepository;
    @Autowired
    private cartRepository cartRepository;
    @Autowired
    private userRepository userRepository;
    private orderHistoryRepository orderHistoryRepository;



    public cart addProduct(Long userid, Long productid) {
        Products products = productRepository.findByProductId(productid);
        users users = userRepository.findByUserId((userid));

        if (cartRepository.findByUserAndProducts(users, products).isPresent()) {
            cart cartt = cartRepository.findByUserAndProducts(users, products).get();

            cartt.setQuantity(cartt.getQuantity() + 1);

            cartRepository.save(cartt);

        } else {
            cart c = new cart(products, users, 1);

            cartRepository.save(c);

        }
        return cartRepository.findByUserAndProducts(users, products).get();
    }

    public List<cart> showCart(Long user_id, Principal principal) {
        users user = userRepository.findByUserId(user_id);
        return cartRepository.findByUserAndProducts_Active(user,1);
    }

    public cart removeproduct(Long userid,Long productid) {
        Products products = productRepository.findByProductId(productid);
        users users = userRepository.findByUserId(userid);

        if(cartRepository.findByUserAndProducts(users,products).get().getQuantity() == 1) {
            cart cart = cartRepository.findByUserAndProducts(users,products).get();
            cart.setQuantity(0);
            cartRepository.save(cart);
        }
        else if(cartRepository.findByUserAndProducts(users,products).get().getQuantity() > 1) {
            cart cart = cartRepository.findByUserAndProducts(users,products).get();

            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        }
        return cartRepository.findByUserAndProducts(users,products).get();
    }
    public String clearCart(Long userid, Principal principal){
        users users=userRepository.findByUserId(userid);
        List<cart> cartList=cartRepository.findAllByUser(users);
        for(cart cart: cartList){
                cartRepository.deleteById(cart.getCartId());
        }
return "Cart Cleared!!";
    }
}
