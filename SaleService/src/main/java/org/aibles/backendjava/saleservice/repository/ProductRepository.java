package org.aibles.backendjava.saleservice.repository;

import org.aibles.backendjava.saleservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
