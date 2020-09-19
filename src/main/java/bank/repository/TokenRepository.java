package bank.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token,Integer> {
   
	List<Token> findByIdLessThan(Integer id);
	List<Token> findByStatusOrderById(String status);
	List<Token> findByService(String service);
}
