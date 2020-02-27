package co.grandcircus.Lab24_25;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.Lab24_25.dao.ProductDao;
import co.grandcircus.Lab24_25.dao.UserDao;
import co.grandcircus.Lab24_25.pojos.Product;

@Controller
public class AdminController {

	@Autowired
	UserDao uDao;

	@Autowired
	ProductDao pDao;
	
	@Autowired
	Methods m;
	
	@RequestMapping("/admin/")
	public ModelAndView adminHome() {
		List<Product> leProductList = pDao.findAll();
		return new ModelAndView("admin/adminMenu", "menu", leProductList);
	}
	
	@RequestMapping("/admin/add")
	public ModelAndView addForm() {
		List<String> categories = pDao.findCategories();
		ModelAndView mav = new ModelAndView("admin/adminAddItemForm");
		mav.addObject("categories", categories);
		mav.addObject("title", "Edit");
		return mav;
	}

	@RequestMapping("/admin/edit")
	public ModelAndView editForm(@RequestParam("id") Long id) {
		Product product = pDao.findById(id);
		List<String> categories = pDao.findCategories();
		ModelAndView mav = new ModelAndView("admin/adminAddItemForm");
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
		Product item = new Product(id, category, name, description, price);
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
	
	@RequestMapping("/admin/itemerror")
	public ModelAndView error() {
		String msg = "Item Already Exists";
		return new ModelAndView("admin/adminError");
	}
	
	
	@RequestMapping("/admin/delete")
	public ModelAndView delete(@RequestParam(name="id", required=false) Long id) {
		pDao.delete(id);
		return new ModelAndView("redirect:/admin/");		
	}
	
	@RequestMapping("/admin/confirm")
	public ModelAndView confirmChanges(@RequestParam("id") Long id){
		Product item = pDao.findById(id);
		return new ModelAndView("admin/adminItemConfirm","item", item);
	}
	
}
