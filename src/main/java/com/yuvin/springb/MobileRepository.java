package com.yuvin.springb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yuvin.springb.model.Lob;
import com.yuvin.springb.model.Mobiles;
import com.yuvin.springb.model.Status;

@Repository
public interface MobileRepository extends JpaRepository<Mobiles, Integer>{

	/*@Query("select m from Mobiles m "
			+ "where (:name is null or m.name = :name) "
			+ "and (:price is null or m.price = :price)"
			+ "and (:status is null or m.status= :status)"
	        +" and (:lob is null or m.lob= :lob)")*/
			//+ "and EXTRACT (year FROM m.publicationDate) = :year AND EXTRACT (month FROM m.publicationDate) = :month")
	public List<Mobiles> getAllResults(String name, Integer price, Status status, Lob lob); 
			//@Param("year") Integer year, @Param("month") Integer month);
			
}
