package main.java.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import main.java.dao.CustomerDAO;
import main.java.domain.Category;
import main.java.domain.Goods;
import main.java.domain.Subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsController {
	@Autowired
	private CustomerDAO hibernateUserDao;

	@RequestMapping(value="/goods.page", method= RequestMethod.GET)
	public ModelAndView showCategoryCombo(@RequestParam(value="selectcateg", required=false) 
		 Long idCateg, @RequestParam(value="selectsubcateg", required=false) Long idSubcateg) {	

		List<Category> categories = hibernateUserDao.getAllCategories();
		if(idCateg == null) {
			idCateg = categories.get(0).getId();
		}
		List<Subcategory> subcategs = hibernateUserDao.getSubcategories(idCateg);
		if(idSubcateg == null) {
			idSubcateg = subcategs.get(0).getId();
		}
		List<Goods> listGoods = hibernateUserDao.getGoods(idCateg,idSubcateg);
		
		ModelAndView modelAndView = new ModelAndView("goodslist");
		modelAndView.addObject("allcateg", categories);
		modelAndView.addObject("subcategs", subcategs);
		modelAndView.addObject("listgoods", listGoods);
		
		Goods g = new Goods();
		g.setIdCategory(idCateg);
		g.setIdSubcategory(idSubcateg);
		modelAndView.addObject("newgoods", g);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/addgoods.page", method= RequestMethod.POST)
	public String addSubcategory(@Valid @ModelAttribute("newgoods")Goods goods, 
														BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
		hibernateUserDao.addGoods(goods);
		return "redirect:/app/goods.page";
	}
	
	@RequestMapping(value="/delgoods.page", method= RequestMethod.GET)
	public String delSubcategory(@RequestParam(value="gid", required=false) 
							Integer id) {
		
		if(id != null) {
			hibernateUserDao.delGoods(id);;
		}		
		return "redirect:/app/goods.page";
	}
}
