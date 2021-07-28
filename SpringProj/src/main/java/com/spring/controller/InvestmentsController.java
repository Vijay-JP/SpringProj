package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Investments;
import com.spring.model.UniqueInvestments;
import com.spring.service.InvestmentsService;

@RestController
public class InvestmentsController {

    @Autowired
    InvestmentsService investmentService;
    
    @PostMapping
    public String insertInvestmentDetails(Investments investment){
    	long result = investmentService.saveInvestment(investment);
        return result!=0?"Sucess":"Failed";
    }
    
    @GetMapping("/showInvestments")
    public List<Investments> showInvestments(){
        return investmentService.showAllInvestments();
    }
    
    @GetMapping("/uniqueInvestmentDetails")
    public List<UniqueInvestments> showUniqueInvestments(){
        return investmentService.showUniqueInvestments();
    }
    
}