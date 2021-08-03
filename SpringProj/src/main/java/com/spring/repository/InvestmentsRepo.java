package com.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.model.Investments;
import com.spring.model.UniqueInvestments;

public interface InvestmentsRepo extends JpaRepository<Investments, Integer> {

	@Override
	default Page<Investments> findAll(Pageable p) {
	    if (p.getSort().isUnsorted()) {
	        findAllBy(PageRequest.of(p.getPageNumber(), p.getPageSize(), 
	        		Sort.by(Sort.Direction.DESC, "id")));
	    }
	    return findAllBy(p);
	}

	Page<Investments> findAllBy(Pageable pageable);
	
	@Query(nativeQuery = true, name = "find_unique_investments")
	List<UniqueInvestments> getUniqueInvestmentsList();

}