package main.java.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import main.java.dao.CustomerDAO;
import main.java.domain.Category;
import main.java.domain.Client;
import main.java.domain.Subcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private CustomerDAO hibernateUserDao;
	
    @RequestMapping(value="/main.page")
    public ModelAndView index(Model model) {
       model.addAttribute("message", "Message from main controller to main page!");
       return new ModelAndView("main");
   }
    
//================================Client===============================================
    
	@RequestMapping(value="/formfindclient.page", method= RequestMethod.GET)
	public ModelAndView showClientById() {
		ModelAndView modelAndView = new ModelAndView("findclient");
		return modelAndView;
	}
	
	@RequestMapping(value="/clientdb.page", method= RequestMethod.GET)
	public ModelAndView showUser(@RequestParam(value="clid", required=false) 
							Integer id, HttpSession session) {
		
//		System.out.println("STEP(clientdb)-3");
//		System.err.println("hibernateUserDao = " + this.hibernateUserDao.toString());
		ModelAndView modelAndView = null;
		long idClient;
		if(id != null) {
			idClient = id;
			Client cl = hibernateUserDao.getClientById(idClient);
			modelAndView = new ModelAndView("showclient");
			modelAndView.addObject("respclient", cl);
//			System.out.println("UserName: " + u.getName());
		} else {
			modelAndView = new ModelAndView("error");
			modelAndView.addObject("message", "Client not exist!");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/clientslist.page", method= RequestMethod.GET)
	public ModelAndView showUsers() {	
//		System.out.println("STEP_USERS_ModelAndView-1");
		List<Client> clients = hibernateUserDao.getAllClients();
//		System.out.println(Arrays.toString(users.toArray()));
		ModelAndView modelAndView = new ModelAndView("clientslist");
		modelAndView.addObject("clientsall", clients);
		return modelAndView;
	}
	
	@RequestMapping(value="/addclientform.page", method= RequestMethod.GET)
	public ModelAndView showAddUserForm() {
		ModelAndView modelAndView = new ModelAndView("addclientform");
		modelAndView.addObject("newclient", new Client());
//		model.addAttribute(new User());
		return modelAndView;
	}
	
	@RequestMapping(value="/addclient.page", method= RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("newclient")Client client, BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
//		System.out.println("STEP_ADD_USER-1");
//		System.out.println(client.getName());		
		hibernateUserDao.addClient(client);
		return "redirect:/app/clientslist.page";
	}
	
	@RequestMapping(value="/clienttodel.page", method= RequestMethod.GET)
	public ModelAndView showUserToDel(HttpSession session) {	
		List<Client> clients = hibernateUserDao.getAllClients();
		ModelAndView modelAndView = new ModelAndView("clienttodel");
		modelAndView.addObject("clientsall", clients);
		return modelAndView;
	}
	
	@RequestMapping(value="/delclient.page", method= RequestMethod.GET)
	public String delUser(@RequestParam(value="clid", required=false) 
							Integer id, HttpSession session) {
		
		System.out.println("STEP_DEL_USER-1");
		if(id != null) {
//			User u = hibernateUserDao.getUserById(id);
//			System.out.println(u.getName());
			hibernateUserDao.delClient(id);
		}		
		return "redirect:/app/clientslist.page";
	}
	
//==================================Category=============================================
	
	@RequestMapping(value="/category.page", method= RequestMethod.GET)
	public ModelAndView showCategory() {	
		List<Category> categories = hibernateUserDao.getAllCategories();
		ModelAndView modelAndView = new ModelAndView("categorieslist");
		modelAndView.addObject("allcategories", categories);
		modelAndView.addObject("newcateg", new Category());
		return modelAndView;
	}
	
	@RequestMapping(value="/addcategory.page", method= RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("newcateg")Category categ, BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }	
		hibernateUserDao.addCategory(categ);
		return "redirect:/app/category.page";
	}
	
	@RequestMapping(value="/delcateg.page", method= RequestMethod.GET)
	public String delCategory(@RequestParam(value="catid", required=false) 
							Integer id, HttpSession session) {
		
		System.out.println("STEP_DEL_USER-1");
		if(id != null) {
			hibernateUserDao.delCategory(id);
		}		
		return "redirect:/app/category.page";
	}
	
//===============================Subcategory================================================
	
	@RequestMapping(value="/subcategory.page", method= RequestMethod.GET)
	public ModelAndView showCategoryCombo(@RequestParam(value="selectcateg", required=false) 
											Long id) {	

		List<Category> categories = hibernateUserDao.getAllCategories();
		if(id == null) {
			id = categories.get(0).getId();
		}
		List<Subcategory> subcategs = hibernateUserDao.getSubcategories(id);
		ModelAndView modelAndView = new ModelAndView("subcateglist");
		modelAndView.addObject("allcateg", categories);
		modelAndView.addObject("subcategs", subcategs);
		Subcategory sc = new Subcategory();
		sc.setIdCategory(id);
		modelAndView.addObject("newsubcateg", sc);
		return modelAndView;
	}
	
	@RequestMapping(value="/addsubcategory.page", method= RequestMethod.POST)
	public String addSubcategory(@Valid @ModelAttribute("newsubcateg")Subcategory subcateg, 
														BindingResult result) {
		if (result.hasErrors()) {
            return "error";
        }
		hibernateUserDao.addSubcategory(subcateg);
		return "redirect:/app/subcategory.page";
	}
	
	@RequestMapping(value="/delsubcateg.page", method= RequestMethod.GET)
	public String delSubcategory(@RequestParam(value="scid", required=false) 
							Integer id, HttpSession session) {
		
		if(id != null) {
			hibernateUserDao.delSubcategory(id);
		}		
		return "redirect:/app/subcategory.page";
	}
	
//===============================================================================	
	
}
