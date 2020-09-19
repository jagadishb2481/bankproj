package bank.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.model.Review;
import bank.model.Token;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
   
	List<Review> findByService(String service);
	
}
