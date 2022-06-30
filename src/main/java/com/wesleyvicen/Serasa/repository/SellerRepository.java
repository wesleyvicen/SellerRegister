package com.wesleyvicen.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wesleyvicen.serasa.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer> {

}
