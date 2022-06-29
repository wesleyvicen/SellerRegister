package com.wesleyvicen.Serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesleyvicen.Serasa.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
