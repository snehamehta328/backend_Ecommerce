package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface productRepository extends JpaRepository<Products, Long>
{
  @Override
   List<Products> findAll();

 List<Products>findAllByName(String Name);
Products findByProductId(Long id);
  List<Products>findAllByCategory(String product_category);
 List<Products>findAllByCategoryAndPriceBetween(String cat,Double p1,Double p2);
  List<Products>findByPriceBetween(Double product_price1,Double product_price2);
}