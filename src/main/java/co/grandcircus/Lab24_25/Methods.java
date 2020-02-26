package co.grandcircus.Lab24_25;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.grandcircus.Lab24_25.dao.ProductDao;

@Service
public class Methods {
	
	@Autowired
	ProductDao pDao;
	
	//@Bean
	public boolean checkIfNameExists(String name) {
		boolean returnBool = false;
		List<String> listONames = pDao.findNames();
//		for (String listName : listONames) {
//			if (listName.equalsIgnoreCase(name)) {
//				returnBool = true;
//				break;
//			}
//		}
		return returnBool;
	}
}
