package main.java.controller;

import java.util.List;

import main.java.dao.CustomerDAO;
import main.java.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {
	
	@Autowired
	private CustomerDAO hibernateUserDao;	
	
	@RequestMapping(value="/shop.page", method= RequestMethod.GET)
	public ModelAndView showShop(@RequestParam(value="selectcateg", required=false) 
	 Long idCateg, @RequestParam(value="selectsubcateg", required=false) Long idSubcateg) {
		List<Category> categories = hibernateUserDao.getAllCategories();
		if(idCateg == null) {
			idCateg = categories.get(0).getId();
		}	
		Category categ = hibernateUserDao.getSelectCateg(idCateg);
		ModelAndView modelAndView = new ModelAndView("shoplist");
		modelAndView.addObject("allcateg", categories);
		modelAndView.addObject("choosecateg", categ);
		
		return modelAndView;
	}
}
