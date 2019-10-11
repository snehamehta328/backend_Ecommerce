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

//    public List<Cart> addProduct(Long productid, Principal principal)
//    {
//        Users users = userRepository.findByusername(principal.getName()).get();
//        Products products = productRepoistory.findById(productid).get();
//        if(cartRepository.findByUserandProducts(users,products).isPresent()) {
//            Cart cart = cartRepository.findByUserandProducts(users, products).get();
//            cart.setQuantity(cart.getQuantity() + 1);
//            cartRepository.save(cart);
//        } else {
//            Cart cart = new Cart();
//            cart.setQuantity(1);
//            cart.setUser(users);
//            cart.setItems(products);
//            cartRepository.save(cart);
//        }
//        return cartRepository.findAllByUsers(users);
//    }
//
//    public List<cart> removeProduct(Long productid, Principal principal) {
//        users users = userRepository.findByUsername(principal.getName()).get();
//        Products products = productRepository.findById(productid).get();
//        cart cart = cartRepository.findByUserAndProducts(users,products).get();
//        cartRepository.delete(cart);
//        return cartRepository.findAllByUsers(users);
//    }

//    public String decreseQuantity(Long productid, Principal principal) {
//        Users users = userRepository.findByUsername(principal.getName()).get();
//        Products products = productRepoistory.findById(productid).get();
//        Cart cart =  cartRepository.findByUserandProducts(users,products).get();
//        if(cart.getQuantity() == 1)
//        {
//            return "Quantity can be deceresed further";
//        }
//        else
//        {
//            cart.setQuantity(cart.getQuantity() - 1);
//            cartRepository.save(cart);
//            return "quantity removed";
//        }
//    }

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

    public List<cart> showCart(Long user_id) {
        users user = userRepository.findByUserId(user_id);
        return cartRepository.findAllByUser(user);
    }
    //
////    public String clearCart(Long userId) {
////
////        Users user = userRepository.findByUserandProducts_Active(user, 1);
////        for (Cart cart : cartItems) {
////            cartRepository.deleteById(cart.getId());
////        }
////        return "cart cleared!";
////    }
//
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
//    public String addtocart(Long userid,Long productid) {
//        Products products = productRepoistory.findByProductId(productid);
//        Users users = userRepository.findByUserId(userid);
//        if(cartRepository.findByUserandProducts(users,products).isPresent()) {
//            return "This item is already present in your cart";
//        }
//        else {
//            Cart cart = new Cart();
//            cart.setItems(products);
//            cart.setUser(users);
//            cart.setQuantity(1);
//            cartRepository.save(cart);
//            return "This item is added to your cart";
//        }
//    }
}
