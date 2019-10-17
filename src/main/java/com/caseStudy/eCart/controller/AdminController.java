//package com.caseStudy.eCart.controller;
//
//import com.caseStudy.eCart.models.Products;
//import com.caseStudy.eCart.service.ProductsService;
//import com.caseStudy.eCart.service.UserService;
//import org.apache.tomcat.jni.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping(path = "/admin")
//public class AdminController
//{
//    private UserService userService;
//    private ProductsService productsService;
//    @Autowired
//    public AdminController(UserService userService,ProductsService productsService){
//        this.userService=userService;
//        this.productsService=productsService;
//    }
//    @PostMapping("/add-user")
//    public Boolean addUser(@RequestBody User user)
//    {
//        return userService.addUser(user);
//    }
//        @DeleteMapping("/remove-user")
//        public List<User> removeUser(@RequestParam("id") Long id) {
//            return userService.deleteUser(id);
//        }
//
//        @PutMapping("/edit-user")
//        public List<User> editUser(@RequestBody User users, @RequestParam("id") Long id) {
//            return userService.editUser(users, id);
//        }
//
//        @GetMapping("/get-user")
//        public User getUserById(@RequestParam("id") Long id) {
//            return userService.getUserById(id);
//        }
//
//        @GetMapping("/get-users")
//        public List<User> getUsers() {
//            return userService.getUsers();
//        }
//
//        @PostMapping("/add-item")
//        public Boolean addItem(@RequestBody Products items) {
//            return productsService.addItem(items);
//        }
//
//        @DeleteMapping("/remove-item")
//        public List<Products> removeItem(@RequestParam("id") Long id) {
//            return productsService.deleteItem(id);
//        }
//
//        @PutMapping("/edit-item")
//        public  Products editItem(@RequestBody Products items, @RequestParam("id") Long id) {
//            return productsService.editItem(items, id);
//        }
//
//        @GetMapping("/get-item")
//        public Products getItemById(@RequestParam("id") Long id) {
//            return productsService.getById(id);
//        }
//
//        @GetMapping("/get-items")
//        public List<Products> getItems() {
//            return productsService.getItems();
//        }
//    }
//
//
//}
