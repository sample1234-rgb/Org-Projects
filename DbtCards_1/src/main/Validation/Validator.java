package main.Validation;

import java.util.List;

import com.infy.exception.MobileServiceException;
import com.infy.model.ServiceRequest;
import 

public class Validator {

	public void validate(ServiceRequest service) throws Exception{	
		//your code goes here
	}	

	
	// validates the pin
	// brand should always start with a upper case alphabet 
	// and can be followed by one or more alphabets (lower case or upper case) 
	public Boolean isValidPIN(String pin){
		return null;
	}
	
	
	// validates the 
	// checks if the list is null or empty
	public Boolean isValidIssues(List<String> issues) {
		return null;
	}

	// validates the Card Number
	// it should be a 16 digit number 
	public Boolean isValidCardNumber(Long CardNumber) {
		return null;
	}
	
	// validates the contact number
	// should contain 10 numeric characters and should not contain 10 repetitive characters
	public Boolean isValidContactNumber(Long contactNumber) {
		return null;
	}
	
	
	// validates the customer name
	// should contain at least one word and each word separated by a single space should contain at least one letter.
	// the first letter of every word should be an upper case character 
	public Boolean isValidCustomerName(String customerName) {
		
		return null;
	}
}
