package main.UI;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import main.model.DebitCardServices;
import main.model.Status;
import main.Java1.Service;
import main.Java1.ServiceImpl;


public class ServiceTester {
	private static final Log LOGGER = LogFactory.getLog(ServiceTester.class);
	public static void main(String[] args) throws ConfigurationException{

		//    		registerRequest();
			getServices();
	
		
	}
	
	public static void registerRequest() throws ConfigurationException{
	    Configurations configurations = new Configurations();
	    PropertiesConfiguration config = configurations.properties("configuration.properties");

		Service service = new ServiceImpl();
		try {
			DebitCardServices obj = new DebitCardServices("Abc", Arrays.asList("Battery"), 9876543210L,"Chap",3214567890123456L);
			obj = service.registerRequest(obj);
			LOGGER.info(config.getProperty("Tester.SUCCESS") + ""+ obj.getServiceId() +", status of the request is "+obj.getStatus()+" on "+obj.getTimeOfRequest().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy  hh:mm:ss")));
		} catch (Exception e) {
			LOGGER.info(config.getProperty(e.getMessage()));
		}
		
	}
	
	public static void getServices() throws Exception{
		Configurations configurations = new Configurations();
		PropertiesConfiguration config = configurations.properties("configuration.properties");
		Service service = new ServiceImpl();
		try {
			
			List<DebitCardServices> list = service.getServices(); 
			LOGGER.info("=================================");
			LOGGER.info(" ID \t Card Number \t\t Amount");
			LOGGER.info("=================================");
			list.stream().forEach(obj->{
//				uncomment the below line when you have implemented the ServiceReport class
				LOGGER.info(obj.getServiceId()+"\t"+obj.getCardNumber()+"\t"+obj.getAmount()+" $");
			});
			LOGGER.info("=================================");
		} catch (Exception e) {
			LOGGER.info(config.getProperty(e.getMessage()));
		}
	}	
}