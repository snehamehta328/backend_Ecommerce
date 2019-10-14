package com.caseStudy.eCart.repository;

import com.caseStudy.eCart.models.orderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface orderHistoryRepository extends JpaRepository<orderHistory, Long> {
}
