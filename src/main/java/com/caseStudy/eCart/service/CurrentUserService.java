//package com.caseStudy.eCart.service;
//
//import com.caseStudy.eCart.models.cart;
//import com.caseStudy.eCart.models.users;
//import com.caseStudy.eCart.repository.cartRepository;
//import com.caseStudy.eCart.repository.userRepository;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.task.DelegatingSecurityContextAsyncTaskExecutor;
//
//import java.security.Principal;
//import java.util.Optional;
//
//public class CurrentUserService
//{
//private userRepository u;
//private cartRepository c;
//public Optional<users> CurrentUser(Principal principal){
//    String email=principal.getName();
//    return u.findByUsername(email);
//}
// public Long getuserid(Principal principal)
// {
//     String email=principal.getName();
//     Long id=u.findByUsername(email).get().getId();
//     return  id;
// }
//  public Optional<users> getuserprofile(Principal principal){
//    return u.findByUsername(principal.getName());
//  }
//  public ResponseEntity<?> checkdetails(users user, Principal principal){
//    Optional<users> usercheck=u.findByUsername(principal.getName());
//    Optional<users> usercheckinfo=u.findByUsername(user.getUsername());
//    if(usercheckinfo.isPresent() & usercheckinfo.get().getUsername()!=usercheck.get().getUsername())
//    {
//        HttpHeaders responseHeaders=new HttpHeaders();
//  }
//  else
//    {
//        cart cr=new cart();
//        cr.setItems(product);
//        cr.getUser(user);
//        cr.setQuantity(1);
//        c.save(cr);
//    }
//}
