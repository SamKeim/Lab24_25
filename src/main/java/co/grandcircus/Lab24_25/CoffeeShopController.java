package co.grandcircus.Lab24_25;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeShopController {
	
	@Autowired
	UserDao uDao;
	@Autowired
	ProductDao pDao;
	
	@PostConstruct
	public void testIt() {
		System.out.println("------------ TESTING START ------------");
		System.out.println(pDao.findAll());
	}
	
	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		List<Product> leProductList = pDao.findAll();
//		List<Product> leProductList = new ArrayList<>(Arrays.asList(
//				new Product("Latte", "Espresso and Milk", 2.99)
//				));
		return new ModelAndView("products", "menu", leProductList);
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegisterForm() {
		return new ModelAndView("register");
	}
	
	@PostMapping("/register")
	public ModelAndView register(User newUser) {
		uDao.addUser(newUser);
		return new ModelAndView("confirmation", "user", newUser);
	}
}
