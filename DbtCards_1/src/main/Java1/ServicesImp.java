package main.Java1;
import java.util.ArrayList;
import java.util.List;

import Validation.Validator;
import main.model.DebitCardServices;
import main.Java1.Services;

public class ServicesImp impliments Services{
	
	private ServiceDAO dao = new ServiceDAOImpl();
	private Validator v = new Validator();
	
	@Override
	public List<DebitCardServices> getServices(Type type) throws Exception{
		List<DebitCardServices> svc = dao.getServices();
		List<DebitCardServices> reports = new ArrayList<DebitCardServices>();
		svc.stream().forEach(obj->{
				if(obj.getType() == type)//validation
					reports.add(new DebitCardServices(obj.getServiceId(),obj.getBrand(),obj.getServiceFee()));
			});
		return reports;
	}
	
	@Override
	public int getBalance() throws Exception{
		return null;
	}
	@Override
	public List<String> getStatement() throws Exception{
		return null;
	}
}
