package co.grandcircus.Lab24_25;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Lab24_25.dao.ProductDao;
import co.grandcircus.Lab24_25.dao.UserDao;
import co.grandcircus.Lab24_25.entities.Product;
import co.grandcircus.Lab24_25.entities.User;

@Controller
public class CoffeeShopController {

	@Autowired
	UserDao uDao;

	@Autowired
	ProductDao pDao;
	
	@Autowired
	Methods m;

	@PostConstruct
	public void testIt() {
		System.out.println("------------ TESTING START ------------");
		Methods m = new Methods();
		
		System.out.println(pDao.findNames());
		System.out.println(m.checkIfNameExists("espresso"));
//		System.out.println(m.checkIfNameExists("test"));
	}
	
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

	@RequestMapping("/admin/create")
	public ModelAndView showForm() {
		List<String> categories = pDao.findCategories();
		ModelAndView mav = new ModelAndView("admin/adminItemForm");
		mav.addObject("title", "Add");
		mav.addObject("categories", categories);
		return mav;
	}

	@RequestMapping("/admin/")
	public ModelAndView adminHome() {
		List<Product> leProductList = pDao.findAll();
		return new ModelAndView("admin/adminMenu", "menu", leProductList);
	}

	@RequestMapping("/admin/form")
	public ModelAndView editForm(@RequestParam("id") Long id) {
		Product product = pDao.findById(id);
		List<String> categories = pDao.findCategories();
		ModelAndView mav = new ModelAndView("admin/adminItemForm");
		mav.addObject("product", product);
		mav.addObject("categories", categories);
		mav.addObject("title", "Edit");
		return mav;
	}

	@RequestMapping("/admin/checking")
	public ModelAndView checkName(@RequestParam("id") Long id, @RequestParam("category") String category,
			@RequestParam("name") String name, @RequestParam("description") String description,
			@RequestParam("price") Double price) {
		
		String mavName = "";
		Product item = new Product(id, category, name, description, null, price);
		if (id == null) {
			Boolean nameExists = m.checkIfNameExists(name);
			if (nameExists) {
				mavName = "redirect:/admin/itemerror";
			} else {
				pDao.addProduct(item);
				id = pDao.findByName(item.getName());
				mavName = "redirect:/admin/confirm?id=" + id;
			}
		} else {
			mavName = "redirect:/admin/confirm?id=" + id;
			pDao.update(item);
		}
		return new ModelAndView(mavName);
	}

	@RequestMapping("/admin/confirm")
	public ModelAndView confirmChanges(@RequestParam("id") Long id){
		Product item = pDao.findById(id);
		return new ModelAndView("admin/adminItemConfirm","item", item);
	}
	
}
