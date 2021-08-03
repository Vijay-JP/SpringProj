package com.spring.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.Investments;
import com.spring.model.UniqueInvestments;
import com.spring.service.InvestmentsService;
import com.spring.utility.ExcelUtil;

@RestController
public class InvestmentsController {

    @Autowired
    InvestmentsService investmentService;
    
    @GetMapping("/showInvestments")
    public List<Investments> showInvestments(){
        return investmentService.showAllInvestments();
    }
    
    @GetMapping("/uniqueInvestmentDetails")
    public List<UniqueInvestments> showUniqueInvestments(){
        return investmentService.showUniqueInvestments();
    }

    @PostMapping("/insertInvestment")
    public String insertInvestmentDetails(Investments investment){
    	long result = investmentService.saveInvestment(investment);
        return result!=0?"Sucess":"Failed";
    }
    
    @PostMapping("/loadInvestment")
    public void loadInvestment(@RequestParam("file") MultipartFile excelFile) {
        
        XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(excelFile.getInputStream());
			XSSFSheet worksheet = workbook.getSheetAt(0);
	        
	        for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        	Investments inv = new Investments();
	                
	            XSSFRow row = worksheet.getRow(i);
	                
	            inv.setPortal(row.getCell(0).getStringCellValue());
	            inv.setInvestment_date(ExcelUtil.getCellDateValue(row.getCell(1)));
	            inv.setAmount((float) row.getCell(2).getNumericCellValue());
	            
	            investmentService.saveInvestment(inv);   
	        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook!=null) 
					workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        
    }
    
}