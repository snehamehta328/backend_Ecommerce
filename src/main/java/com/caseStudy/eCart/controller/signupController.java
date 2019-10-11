package com.caseStudy.eCart.controller;

import com.caseStudy.eCart.exception.ResourceNotFoundException;
import com.caseStudy.eCart.models.users;
import com.caseStudy.eCart.repository.signuprepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST})
@RestController
@RequestMapping("/login")
public class signupController
{
    @Autowired
    signuprepository s;
    @GetMapping(path= "/getUser")
    public List<users> getAllUser()
    {
        return s.findAll();
    }
    @PostMapping("/addUser")
    public users createNote(@Valid @RequestBody users us)
    {
        us.setRole("user");
        us.setActive(1);
        return s.save(us);
    }
    @GetMapping("/getUsersById/{UserId}")
    public users getUserById(@PathVariable(value="UserId") Long product_id) {
        return s.findById(product_id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id",product_id));
    }
    @PutMapping("/updateById/{UserId}")
    public users updateNote(@PathVariable(value="UserId")Long noteId,
                            @Valid @RequestBody users userDetails){
        users u=s.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));
        u.setUserId(userDetails.getUserId());
        u.setPassword(userDetails.getPassword());
        u.setUsername(userDetails.getUsername());
        u.setActive(userDetails.getActive());
        u.setRole(userDetails.getRole());

        users updatedProduct= s.save(u);
        return updatedProduct;

    }
    @DeleteMapping("/users/{UserId}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value="UserId")Long product_Id)
    {
        users product=s.findById(product_Id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", product_Id));
        s.delete(product);
        return ResponseEntity.ok().build();
    }

}
