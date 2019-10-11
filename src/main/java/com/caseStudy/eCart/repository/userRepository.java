package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.cart;
import com.caseStudy.eCart.models.users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface userRepository extends JpaRepository<users, Long>
{
    @Override
    List<users> findAll();
    Optional<users> findByUsername(String username);
    users findByUserId(Long userid);
   // List<cart>findByUserandProducts_Active(users user, int id);
}

