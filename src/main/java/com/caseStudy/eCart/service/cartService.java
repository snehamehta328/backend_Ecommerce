package com.caseStudy.eCart.service;

import com.caseStudy.eCart.models.*;
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
    @Autowired
    private orderHistoryRepository orderHistoryRepository;



    public cart addProduct(Long userid, Long productid) {
        Products products = productRepository.findByProductId(productid);
        users users = userRepository.findByUserId((userid));

        if (cartRepository.findByUserAndProducts(users, products).isPresent()) {
            cart cartt = cartRepository.findByUserAndProducts(users, products).get();

            cartt.setQuantity(cartt.getQuantity() + 1);
            cartt.setTotal(cartt.getQuantity()*products.getPrice());

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

    public Optional<cart> removeproduct(Long userid,Long productid) {
        Products products = productRepository.findByProductId(productid);
        users users = userRepository.findByUserId(userid);

        if(cartRepository.findByUserAndProducts(users,products).get().getQuantity() <= 1) {
            cart cart = cartRepository.findByUserAndProducts(users,products).get();
            cartRepository.delete(cart);
        }
        else  {
            cart cart = cartRepository.findByUserAndProducts(users,products).get();
            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        }
        return cartRepository.findByUserAndProducts(users,products);
    }
    public String clearCart(Long userid, Principal principal){
        users users=userRepository.findByUserId(userid);
        List<cart> cartList=cartRepository.findAllByUser(users);
        for(cart cart: cartList){
                cartRepository.deleteById(cart.getCartId());
        }
return "Cart Cleared!!";
    }
    public Optional<cart> deleteproduct(Long userid, Long productid)
    {
        Products products=productRepository.findByProductId(productid);
        users users=userRepository.findByUserId(userid);
        cart cart=cartRepository.findByUserAndProducts(users,products).get();
        cartRepository.delete(cart);
        return cartRepository.findByUserAndProducts(users,products);
    }

    public double checkout(Long userid, Principal principal)
    {
        users users=userRepository.findByUserId(userid);
        double p;
        double total=0;
        List<cart> cartList=cartRepository.findAllByUser(users);
        for(cart cart:cartList)
        {
            orderHistory orderhistory= new orderHistory();
            orderhistory.setProducts(cart.getProducts());
            orderhistory.setUsers(cart.getUser());
            p=cart.getProducts().getPrice();
            orderhistory.setQuantity(cart.getQuantity());
            total=total+cart.getQuantity()*p;
            orderhistory.setPrice((int)(cart.getQuantity()*p));
            orderhistory.setDate();
            orderHistoryRepository.save(orderhistory);
        }
        //clearCart(userid,principal);
        return total;
    }
    public List<orderHistory> showorderhistory(Long userid,Principal principal)
    {
        users users=userRepository.findByUserId(userid);
        return orderHistoryRepository.findAllByUsers(users);
    }

    public double calPrice(Long userid,Principal principal)
    {
        users users=userRepository.findByUserId(userid);
        List<cart> cartList=cartRepository.findAllByUser(users);
        double q=0;
        for(cart cart: cartList){
            q=q+cart.getTotal();
        }
        return q;
    }
}
