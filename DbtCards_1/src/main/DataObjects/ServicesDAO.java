package main.DataObjects;

import java.util.List;
import main.Java1.Services;

public interface ServicesDAO {
	public Service registerRequest(Service service);
	public List<DebitCardServices> getServices();
	
}
