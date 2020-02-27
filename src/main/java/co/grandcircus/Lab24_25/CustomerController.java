package co.grandcircus.Lab24_25;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Lab24_25.dao.ProductDao;
import co.grandcircus.Lab24_25.dao.UserDao;
import co.grandcircus.Lab24_25.pojos.Product;
import co.grandcircus.Lab24_25.pojos.User;

@Controller
public class CustomerController {

	@Autowired
	UserDao uDao;

	@Autowired
	ProductDao pDao;

	@Autowired
	Methods m;

	@RequestMapping("/menu")
	public ModelAndView showMenu() {
		List<Product> leProductList = pDao.findAll();
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

	@Autowired
	private HttpSession sesh;

//	@RequestMapping("/")
//	public ModelAndView showSession(@SessionAttribute(name="location", required=false) String location) {
//		ModelAndView mav = new ModelAndView("index");
//		if (!(location.equals("Clear"))) {
//			mav.addObject("location", location);
//		
//		}
//		
//		UserPreferences userPr = (UserPreferences)sesh.getAttribute("userPref");
//		mav.addObject("name", userPr.getName());
//		mav.addObject("sessionID", sesh.getId());
//		
//		return mav;
//	}
//	

	@RequestMapping("/")
	public ModelAndView showHome() {
		return new ModelAndView("index");
	}

	@RequestMapping("/clearfavorite")
	public ModelAndView clearFavorite() {
		sesh.invalidate();
		return new ModelAndView("redirect:/");
	}
	@PostMapping("/")
	public ModelAndView setPreferences(String location) {
		sesh.setAttribute("location", location);
		return new ModelAndView("redirect:/");
	}
}