package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Investments;
import com.spring.model.UniqueInvestments;
import com.spring.repository.InvestmentsRepo;

@Service
public class InvestmentsService {

    @Autowired
    InvestmentsRepo investmentRepo;  
    
    public List<Investments> showAllInvestments() {
        List<Investments> investments = new ArrayList<Investments>();  
        investmentRepo.findAll().forEach(investment -> investments.add(investment));  
        return investments;  
    }

    public List<UniqueInvestments> showUniqueInvestments() {
        List<UniqueInvestments> uniqueInvestments = new ArrayList<UniqueInvestments>();  
        for(UniqueInvestments inv : investmentRepo.getUniqueInvestmentsList()){
            uniqueInvestments.add(inv);
        }
        return uniqueInvestments;
    }

	public long saveInvestment(Investments investment) {
		Investments inv = investmentRepo.save(investment);
		System.out.println(inv.getInvestment_id());
		return inv.getInvestment_id();
	}

}