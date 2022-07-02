package main.DataObjects;

import java.util.Arrays;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
	
	@Override
	public DebitCardServices registerRequest(DebitCardServices service)  {
		service.setServiceId(1000);
		return service;
	}

	@Override
	public List<DebitCardServices> getServices()  {
		DebitCardServices service0 = new DebitCardServices(908070605L, 1234567890123456L,123);
		DebitCardServices service1 = new DebitCardServices(908070605L, 1234567890123457L,234);
		DebitCardServices service2 = new DebitCardServices(908070605L, 1234567890123458L,345);
		DebitCardServices service3 = new DebitCardServices(908070605L, 1234567890123459L,456);
		DebitCardServices service4 = new DebitCardServices(908070605L, 1234567890123460L,567);
		DebitCardServices service5 = new DebitCardServices(908070605L, 1234567890123461L,678);
		DebitCardServices service6 = new DebitCardServices(908070605L, 1234567890123462L,789);
		DebitCardServices service7 = new DebitCardServices(908070605L, 1234567890123463L,890);
		
		
		service0.setServiceId(1001);
		service1.setServiceId(1002);
		service3.setServiceId(1003);
		service2.setServiceId(1004);
		service4.setServiceId(1005);
		service5.setServiceId(1006);
		service6.setServiceId(1007);
		service7.setServiceId(1008);

		service0.setStatus(Status.IN_PROGRESS);
		service1.setStatus(Status.COMPLETED);
		service3.setStatus(Status.COMPLETED);
		service2.setStatus(Status.COMPLETED);
		service4.setStatus(Status.COMPLETED);
		service5.setStatus(Status.ACCEPTED);
		service6.setStatus(Status.COMPLETED);
		service7.setStatus(Status.COMPLETED);

		service0.setType(Type.GOLD);
		service1.setType(Type.GENERAL);
		service3.setType(Type.GENERAL);
		service2.setType(Type.SILVER);
		service4.setType(Type.PLATINUM);
		service5.setType(Type.GENERAL);
		service6.setType(Type.GENERAL);
		service7.setType(Type.GOLD);

		service0.setAmount(15f);
		service1.setAmount(5f);
		service3.setAmount(5f);
		service2.setAmount(5f);
		service4.setAmount(15f);
		service5.setAmount(10f);
		service6.setAmount(5f);
		service7.setAmount(10f);

		return Arrays.asList(service0, service1, service2, service3, service4, service5, service6, service7);
	}

}