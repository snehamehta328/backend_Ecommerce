package com.caseStudy.eCart.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.caseStudy.eCart.exception.ResourceNotFoundException;
import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.repository.productRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.hibernate.HibernateException;
import javax.validation.Valid;
import java.util.List;
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.DELETE, RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class ProductsController
{
    @Autowired
  productRepository p;
    @GetMapping("/prodetails")
    public List<Products> getAlldetails()
    {
        return p.findAll();
    }
    @PostMapping("/insert")
    public Products createNewItem( @Valid @RequestBody Products ifc)
    {
        return p.save(ifc);
    }
//    @DeleteMapping("/del")
//public ResponseEntity<?> deleteDetails(@PathVariable(value="id")Long productId)
//    {
//        Products abc = p.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Details", "Id", productId));
//        p.delete(abc);
//        return ResponseEntity.ok().build();
//    }
@DeleteMapping("/del/{id}")
public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
    Products abc =  p.findById(noteId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

    p.delete(abc);

    return ResponseEntity.ok().build();
}
    @GetMapping("/par/{product_id}")
public Products getDetailsById(@PathVariable(value="product_id") Long productId)
    {
    return p.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Details", "product_id", productId));
    }
@GetMapping("/getProductsByPrice/{price1}/between/{price2}")
public List<Products> getProductsByPrice(@PathVariable(value="price1")Double product_price1,@PathVariable(value="price2")Double product_price2)
{
    return p.findByPriceBetween(product_price1,product_price2);
}
@GetMapping("/getProductsByCategory/{category}")
    public List<Products> getProductsByCategory(@PathVariable(value="category")String product_category)
{
        return p.findAllByCategory(product_category);
}
@PutMapping("/updateProduct/{id}")
    public Products updateProduct(@PathVariable(value="id") Long productId,
                                  @Valid @RequestBody Products productDetails) {
        Products product= p.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Products","id",productId));
        product.setProductId(productDetails.getProductId());
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setDetails(productDetails.getDetails());
        product.setImage(productDetails.getImage());
        product.setSubcategory(productDetails.getSubcategory());
        product.setPrice(productDetails.getPrice());
        product.setActive(productDetails.getActive());

         Products updatedProduct=p.save(product);
         return updatedProduct;
    }
@PutMapping("/notes/{id}")
public Products updateNote(@PathVariable(value = "id") Long noteId,
                       @Valid @RequestBody Products noteDetails) {
    Products note = p.findById(noteId)
            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    note.setName(noteDetails.getName());
    note.setProductId(noteDetails.getProductId());
    note.setCategory(noteDetails.getCategory());
    note.setSubcategory(noteDetails.getSubcategory());
    note.setDetails(noteDetails.getDetails());
    note.setImage(noteDetails.getImage());
    note.setPrice(noteDetails.getPrice());
    note.setActive((int) noteDetails.getPrice());


    Products updatedNote = p.save(note);
    return updatedNote;
}


}
