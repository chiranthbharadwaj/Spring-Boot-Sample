package com.springbootdev.examples.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.springbootdev.examples.entity.User;

@RestController
@RequestMapping("/springBoot")
public class UserController {
	
	String filePath = "E:\\EmployeeSchema\\longInt.csv";

    @PutMapping("/duplicatecheck")
    public Boolean findNCreate(@RequestBody User userObject) throws Exception
    {
        CSVReader reader = new CSVReader(new FileReader(filePath));
		List<String[]> nextRecord = reader.readAll(); 
		
		for (String[] empRecord : nextRecord) {
			if(Long.parseLong(empRecord[0]) == userObject.getLongValue()) {	
				return true;
			}
        }		
		String empDataContruct = String.valueOf(userObject.getLongValue());
		FileWriter outputfile = new FileWriter(filePath,true);
		CSVWriter writer = new CSVWriter(outputfile); 
		String[] empDataContruct1 = {empDataContruct};
		writer.writeNext(empDataContruct1); 
		writer.close(); 
		outputfile.close();
        return false;
        }  
    
}
