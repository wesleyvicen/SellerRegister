package com.wesleyvicen.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wesleyvicen.serasa.model.Acting;

@Repository
public interface ActingRepository extends JpaRepository<Acting, Integer> {
	
	@Query(value = "select * from acting where acting.region = :region", nativeQuery = true)
	Acting searchRegion(@Param("region") String region);

}
