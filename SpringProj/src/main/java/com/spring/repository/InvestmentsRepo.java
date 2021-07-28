package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.model.Investments;
import com.spring.model.UniqueInvestments;

public interface InvestmentsRepo extends JpaRepository<Investments, Integer> {

	@Query(nativeQuery = true, name = "find_unique_investments")
	List<UniqueInvestments> getUniqueInvestmentsList();

}