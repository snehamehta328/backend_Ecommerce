package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.Products;
import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface cartRepository extends JpaRepository<cart, Long> {
    Optional<cart> findByUserAndProducts(users user, Products products);
//    List<cart>findByUserAndProducts_Active(users user,int id);
   List<cart> findAllByUser(users user);
}

