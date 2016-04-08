package main.java.controller;

import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import main.java.dao.CustomerDAO;
import main.java.domain.Category;
import main.java.domain.Client;
import main.java.domain.Goods;
import main.java.domain.SaleRecord;

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
	 Long idCateg) {
		List<Category> categories = hibernateUserDao.getAllCategories();
		if(idCateg == null) {
			idCateg = categories.get(0).getId();
		}	
		Category categ = hibernateUserDao.getSelectCateg(idCateg);
		List<Client> clients = hibernateUserDao.getAllClients();
		ModelAndView modelAndView = new ModelAndView("shoplist");
		modelAndView.addObject("allcateg", categories);
		modelAndView.addObject("choosecateg", categ);
		modelAndView.addObject("clientsall", clients);
		return modelAndView;
	}
	
	@RequestMapping(value="/buygoods.page", method= RequestMethod.GET)
	public String showUser(@RequestParam(value="gid", required=false) Integer id, 
			@RequestParam(value="goodsnum", required=false) Integer num,
			@RequestParam(value="idcl", required=false) Integer cl) {
		System.out.println("===BUY GOODS=== id = " + id + " number = " + num + " clID = " + cl);
		Goods g = hibernateUserDao.getGoodsById(id);
		SaleRecord sr = new SaleRecord();
		sr.setGoods(g);
		sr.setIdClient(cl);
		sr.setCost(g.getPrice());
		sr.setNumber(num);
		sr.setData(new GregorianCalendar());
		hibernateUserDao.buyGoods(sr);
		return "redirect:/app/clienttrade.page";
	}
}
